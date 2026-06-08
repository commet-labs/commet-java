package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.BillingInterval;
import co.commet.models.ConsumptionModel;
import co.commet.models.DiscountType;
import co.commet.models.FeatureType;
import co.commet.models.Plan;
import co.commet.models.PlanFeaturesItem;
import co.commet.models.PlanPricesItem;
import co.commet.models.PlanPricesItemIntroOffer;
import co.commet.models.PlanPricesItemRegionalPricesItem;
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

class PlansResourceTest {

    private MockWebServer server;
    private PlansResource plans;
    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() throws IOException {
        server = new MockWebServer();
        server.start();

        String baseUrl = server.url("/").toString();
        CommetHttpClient http = new QuotaResourceTest.TestableHttpClient("ck_test_key", baseUrl, Duration.ofSeconds(5), 0);
        plans = new PlansResource(http);
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    @Test
    void getDeserializesNestedPricesIntroOfferRegionalAndFeatureEnums() throws Exception {
        Map<String, Object> introOffer = mapOf(
                "enabled", true,
                "discountType", "percentage",
                "discountValue", 2500,
                "durationCycles", 3
        );
        Map<String, Object> regionalPrice = mapOf(
                "currency", "eur",
                "price", 9000,
                "includedBalance", 50000,
                "autoSynced", true
        );
        Map<String, Object> monthlyPrice = mapOf(
                "billingInterval", "monthly",
                "price", 10000,
                "isDefault", true,
                "trialDays", 14,
                "includedBalance", null,
                "includedCredits", 1000,
                "introOffer", introOffer,
                "regionalPrices", List.of(regionalPrice)
        );
        Map<String, Object> feature = mapOf(
                "code", "api_calls",
                "name", "API Calls",
                "type", "usage",
                "unitName", "call",
                "enabled", true,
                "includedAmount", 100000,
                "unlimited", false,
                "overage", mapOf("enabled", true, "model", "per_unit", "unitPrice", 50),
                "regionalPrices", List.of(mapOf("currency", "eur", "overageUnitPrice", 45, "autoSynced", false))
        );
        Map<String, Object> planData = mapOf(
                "id", "plan_pro",
                "name", "Pro",
                "code", "pro",
                "description", "Pro plan",
                "consumptionModel", "metered",
                "isPublic", true,
                "isDefault", false,
                "isFree", false,
                "blockOnExhaustion", null,
                "sortOrder", 2,
                "planGroupId", "pg_1",
                "metadata", mapOf("tier", "gold"),
                "createdAt", "2026-06-01T00:00:00.000Z",
                "updatedAt", "2026-06-02T00:00:00.000Z",
                "features", List.of(feature),
                "prices", List.of(monthlyPrice),
                "exchangeRates", List.of(),
                "object", "plan",
                "livemode", true
        );

        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of("success", true, "data", planData))));

        ApiResponse<Plan> response = plans.get("plan_pro");

        RecordedRequest request = server.takeRequest();
        assertEquals("GET", request.getMethod());
        assertEquals("/api/plans/plan_pro", request.getPath());

        assertTrue(response.isSuccess());
        Plan plan = response.getData();
        assertEquals("plan_pro", plan.id());
        // Enum mapping: wire "metered" -> ConsumptionModel.METERED via @JsonCreator.
        assertEquals(ConsumptionModel.METERED, plan.consumptionModel());
        // Boxed Boolean blockOnExhaustion sent as null must stay null (not silently false).
        assertNull(plan.blockOnExhaustion());
        assertEquals("gold", plan.metadata().get("tier"));

        // Nested price record with enum + nullability.
        assertEquals(1, plan.prices().size());
        PlanPricesItem price = plan.prices().get(0);
        assertEquals(BillingInterval.MONTHLY, price.billingInterval());
        assertEquals(10000L, price.price());
        assertTrue(price.isDefault());
        // includedBalance null -> boxed Long stays null; includedCredits present -> 1000.
        assertNull(price.includedBalance());
        assertEquals(1000L, price.includedCredits());

        // Doubly-nested intro offer with its own enum.
        PlanPricesItemIntroOffer offer = price.introOffer();
        assertNotNull(offer);
        assertTrue(offer.enabled());
        assertEquals(DiscountType.PERCENTAGE, offer.discountType());
        assertEquals(2500L, offer.discountValue());
        assertEquals(3L, offer.durationCycles());

        // Doubly-nested regional price list.
        PlanPricesItemRegionalPricesItem regional = price.regionalPrices().get(0);
        assertEquals("eur", regional.currency());
        assertEquals(9000L, regional.price());
        assertEquals(50000L, regional.includedBalance());
        assertTrue(regional.autoSynced());

        // Nested feature with FeatureType enum and overage record.
        PlanFeaturesItem feat = plan.features().get(0);
        assertEquals("api_calls", feat.code());
        assertEquals(FeatureType.USAGE, feat.type());
        assertEquals(100000L, feat.includedAmount());
        assertFalse(feat.unlimited());
        assertTrue(feat.overage().enabled());
        assertEquals(50L, feat.overage().unitPrice());
        assertEquals(45L, feat.regionalPrices().get(0).overageUnitPrice());
    }

    @Test
    void getThrowsOnUnknownEnumValueInsteadOfSilentlyAccepting() throws Exception {
        // An unrecognized consumption_model from the wire must fail loudly (@JsonCreator throws),
        // never default to a silent fallback enum.
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("{\"success\":true,\"data\":{\"id\":\"plan_x\",\"consumptionModel\":\"telepathy\","
                        + "\"object\":\"plan\",\"livemode\":true}}"));

        assertThrows(Exception.class, () -> plans.get("plan_x"));
    }

    private static Map<String, Object> mapOf(Object... kv) {
        Map<String, Object> m = new LinkedHashMap<>();
        for (int i = 0; i < kv.length; i += 2) {
            m.put((String) kv[i], kv[i + 1]);
        }
        return m;
    }
}
