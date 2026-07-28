package co.commet.resources;

import co.commet.CommetHttpClient;
import co.commet.models.Addon;
import co.commet.models.CreditPack;
import co.commet.models.CreditPacksListResult;
import co.commet.models.Feature;
import co.commet.models.FeatureType;
import co.commet.models.Invoice;
import co.commet.models.InvoiceType;
import co.commet.models.SeatEvent;
import co.commet.models.Transaction;
import co.commet.models.TransactionStatus;
import co.commet.params.AddSeatsParams;
import co.commet.params.CreateFeatureParams;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cross-resource Jackson round-trip, enum mapping and nullability coverage for the
 * complex-typed resources that codegen produced without dedicated tests:
 * invoices, transactions, seats, add-ons, credit packs and features.
 */
class ComplexModelSerializationTest {

    private MockWebServer server;
    private CommetHttpClient http;
    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() throws IOException {
        server = new MockWebServer();
        server.start();
        String baseUrl = server.url("/").toString();
        http = new QuotaResourceTest.TestableHttpClient("ck_test_key", baseUrl, Duration.ofSeconds(5), 0);
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    @Test
    void invoiceGetDeserializesEnumLineItemsAndTotals() throws Exception {
        Map<String, Object> lineItem = mapOf(
                "lineType", "subscription",
                "featureName", "API Calls",
                "description", "Monthly base",
                "quantity", 1,
                "unitAmount", 10000,
                "amount", 10000,
                "includedAmount", null,
                "usedAmount", 4200,
                "overageAmount", null,
                "discountType", "percentage",
                "discountValue", 1000,
                "discountName", "Launch",
                "chargeType", "recurring"
        );
        Map<String, Object> data = mapOf(
                "id", "inv_1",
                "customerId", "cus_1",
                "subscriptionId", "sub_1",
                "invoiceNumber", "INV-0001",
                "status", "paid",
                "invoiceType", "recurring",
                "currency", "usd",
                "subtotal", 10000,
                "discountAmount", 1000,
                "creditApplied", 0,
                "taxAmount", 900,
                "total", 9900,
                "periodStart", "2026-06-01T00:00:00.000Z",
                "periodEnd", "2026-07-01T00:00:00.000Z",
                "issueDate", "2026-06-01T00:00:00.000Z",
                "dueDate", "2026-06-08T00:00:00.000Z",
                "planName", "Pro",
                "memo", null,
                "poNumber", null,
                "reference", null,
                "metadata", mapOf("source", "api"),
                "createdAt", "2026-06-01T00:00:00.000Z",
                "updatedAt", "2026-06-01T00:00:00.000Z",
                "lineItems", List.of(lineItem),
                "object", "invoice",
                "livemode", true
        );
        server.enqueue(jsonData(data));

        Invoice response = new InvoicesResource(http).get("inv_1");

        RecordedRequest request = server.takeRequest();
        assertEquals("GET", request.getMethod());
        assertEquals("/api/invoices/inv_1", request.getPath());

        Invoice invoice = response;
        assertEquals("inv_1", invoice.id());
        // status is a free-form String, invoice_type is the typed enum.
        assertEquals("paid", invoice.status());
        assertEquals(InvoiceType.RECURRING, invoice.invoiceType());
        assertEquals(9900L, invoice.total());
        assertEquals(0L, invoice.creditApplied());
        assertEquals("api", invoice.metadata().get("source"));
        // Nested line item list with mixed boxed nullability.
        assertEquals(1, invoice.lineItems().size());
        assertEquals("subscription", invoice.lineItems().get(0).lineType());
        assertEquals(4200L, invoice.lineItems().get(0).usedAmount());
        assertNull(invoice.lineItems().get(0).includedAmount());
        assertNull(invoice.lineItems().get(0).overageAmount());
        assertEquals(1000L, invoice.lineItems().get(0).discountValue());
    }

    @Test
    void transactionGetMapsTransactionStatusEnum() throws Exception {
        Map<String, Object> data = mapOf(
                "id", "txn_1",
                "invoiceId", "inv_1",
                "grossAmount", 9900,
                "subtotal", 9000,
                "taxAmount", 900,
                "currency", "usd",
                "status", "succeeded",
                "customerEmail", "ada@acme.test",
                "customerName", "Ada",
                "paidAt", "2026-06-01T00:00:00.000Z",
                "createdAt", "2026-06-01T00:00:00.000Z",
                "updatedAt", "2026-06-01T00:00:00.000Z",
                "availableAt", "2026-06-03T00:00:00.000Z",
                "object", "transaction",
                "livemode", true
        );
        server.enqueue(jsonData(data));

        Transaction response = new TransactionsResource(http).get("txn_1");

        RecordedRequest request = server.takeRequest();
        assertEquals("/api/transactions/txn_1", request.getPath());

        Transaction txn = response;
        assertEquals(TransactionStatus.SUCCEEDED, txn.status());
        assertEquals(9900L, txn.grossAmount());
        assertEquals("ada@acme.test", txn.customerEmail());
    }

    @Test
    void seatAddSendsCamelCaseBodyAndParsesBalanceDelta() throws Exception {
        Map<String, Object> data = mapOf(
                "id", "se_1",
                "customerId", "cus_1",
                "featureCode", "seats",
                "previousBalance", 3,
                "newBalance", 5,
                "ts", "2026-06-01T00:00:00.000Z",
                "createdAt", "2026-06-01T00:00:00.000Z",
                "object", "seat_event",
                "livemode", true
        );
        server.enqueue(jsonData(data));

        SeatEvent response = new SeatsResource(http).add(
                AddSeatsParams.builder("cus_1", "seats", 2L).idempotencyKey("idem_seat").build());

        RecordedRequest request = server.takeRequest();
        assertEquals("POST", request.getMethod());
        assertEquals("/api/seats", request.getPath());
        assertEquals("idem_seat", request.getHeader("Idempotency-Key"));

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertEquals("cus_1", body.get("customerId").asText());
        assertEquals("seats", body.get("featureCode").asText());
        assertEquals(2, body.get("count").asLong());
        assertFalse(body.has("customer_id"), "no snake_case key may leak onto the wire");
        assertFalse(body.has("feature_code"), "no snake_case key may leak onto the wire");

        SeatEvent event = response;
        assertEquals(3L, event.previousBalance());
        assertEquals(5L, event.newBalance());
    }

    @Test
    void addonGetMapsBoxedNullableUnitsAndRates() throws Exception {
        Map<String, Object> data = mapOf(
                "id", "addon_1",
                "name", "Extra Storage",
                "slug", "extra-storage",
                "description", "More GB",
                "basePrice", 500,
                "consumptionModel", "metered",
                "featureCode", "storage",
                "featureName", "Storage",
                "includedUnits", 100,
                "overageRate", 5,
                "creditCost", null,
                "createdAt", "2026-06-01T00:00:00.000Z",
                "updatedAt", "2026-06-01T00:00:00.000Z",
                "object", "addon",
                "livemode", true
        );
        server.enqueue(jsonData(data));

        Addon response = new AddonsResource(http).get("addon_1");

        RecordedRequest request = server.takeRequest();
        assertEquals("/api/addons/addon_1", request.getPath());

        Addon addon = response;
        assertEquals("extra-storage", addon.slug());
        assertEquals(500L, addon.basePrice());
        assertEquals(100L, addon.includedUnits());
        assertEquals(5L, addon.overageRate());
        // creditCost null on the wire -> boxed Long null, not 0.
        assertNull(addon.creditCost());
    }

    @Test
    void creditPackListMapsListItems() throws Exception {
        server.enqueue(jsonData(mapOf(
                "object", "list",
                "data", List.of(
                mapOf("id", "cp_1", "name", "Starter", "description", "100 credits",
                        "credits", 100, "price", 1000, "currency", "usd",
                        "createdAt", "2026-06-01T00:00:00.000Z", "updatedAt", "2026-06-01T00:00:00.000Z",
                        "object", "credit_pack", "livemode", true),
                mapOf("id", "cp_2", "name", "Legacy", "description", "retired",
                        "credits", 500, "price", 4000, "currency", "usd",
                        "createdAt", "2026-06-01T00:00:00.000Z", "updatedAt", "2026-06-01T00:00:00.000Z",
                        "object", "credit_pack", "livemode", true)),
                "hasMore", false
        )));

        CreditPacksListResult response = new CreditPacksResource(http).list();

        RecordedRequest request = server.takeRequest();
        assertEquals("GET", request.getMethod());
        assertEquals("/api/credit-packs", request.getPath());

        assertEquals(2, response.data().size());
        assertEquals("usd", response.data().get(0).currency());
        assertEquals("usd", response.data().get(1).currency());
        assertEquals(100L, response.data().get(0).credits());
    }

    @Test
    void featureCreateSerializesFeatureTypeEnumAsWireString() throws Exception {
        server.enqueue(jsonData(mapOf(
                "id", "feat_1",
                "name", "API Calls",
                "code", "api_calls",
                "type", "usage",
                "description", "Metered API calls",
                "unitName", "call",
                "createdAt", "2026-06-01T00:00:00.000Z",
                "updatedAt", "2026-06-01T00:00:00.000Z",
                "object", "feature",
                "livemode", true
        )));

        Feature response = new FeaturesResource(http).create(
                CreateFeatureParams.builder("API Calls", "api_calls", "usage")
                        .unitName("call")
                        .description("Metered API calls")
                        .build());

        RecordedRequest request = server.takeRequest();
        assertEquals("POST", request.getMethod());
        assertEquals("/api/features", request.getPath());

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        // FeatureType enum must serialize via @JsonValue to the wire string, never the Java name USAGE.
        assertEquals("usage", body.get("type").asText());
        assertEquals("api_calls", body.get("code").asText());
        assertEquals("call", body.get("unitName").asText());
        assertFalse(body.has("unit_name"), "no snake_case key may leak onto the wire");

        Feature feature = response;
        assertEquals(FeatureType.USAGE, feature.type());
        assertEquals("call", feature.unitName());
    }

    private MockResponse jsonData(Object data) throws IOException {
        return new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(data));
    }

    private static Map<String, Object> mapOf(Object... kv) {
        Map<String, Object> m = new LinkedHashMap<>();
        for (int i = 0; i < kv.length; i += 2) {
            m.put((String) kv[i], kv[i + 1]);
        }
        return m;
    }
}
