package co.commet.resources;

import co.commet.CommetHttpClient;
import co.commet.models.Payout;
import co.commet.models.PayoutBankAccount;
import co.commet.params.AddPayoutBankAccountParams;
import co.commet.params.CompletePayoutVerificationParams;
import co.commet.params.RequestPayoutParams;
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
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PayoutsResourceTest {

    private MockWebServer server;
    private PayoutsResource payouts;
    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() throws IOException {
        server = new MockWebServer();
        server.start();

        String baseUrl = server.url("/").toString();
        CommetHttpClient http = new QuotaResourceTest.TestableHttpClient("ck_test_key", baseUrl, Duration.ofSeconds(5), 0);
        payouts = new PayoutsResource(http);
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    @Test
    void addBankAccountSendsCamelCaseWireKeysAndOmitsUnsetOptional() throws Exception {
        server.enqueue(bankAccountResponse());

        PayoutBankAccount response = payouts.addBankAccount(
                AddPayoutBankAccountParams.builder("000123456789", "Acme Inc")
                        .routingNumber("110000000")
                        .accountType("checking")
                        .idempotencyKey("idem_bank")
                        .build());

        RecordedRequest request = server.takeRequest();
        assertEquals("POST", request.getMethod());
        assertEquals("/api/payouts/bank-accounts", request.getPath());
        assertEquals("idem_bank", request.getHeader("Idempotency-Key"));

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        // Body is built with snake_case keys but the wire must carry camelCase.
        assertEquals("000123456789", body.get("accountNumber").asText());
        assertEquals("Acme Inc", body.get("accountHolderName").asText());
        assertEquals("110000000", body.get("routingNumber").asText());
        assertEquals("checking", body.get("accountType").asText());
        assertFalse(body.has("account_number"), "no snake_case key may leak onto the wire");
        assertFalse(body.has("account_holder_name"), "no snake_case key may leak onto the wire");
        // setDefault was never set: NON_NULL inclusion must drop it entirely.
        assertFalse(body.has("setDefault"), "unset optional must not be sent");
        assertFalse(body.has("set_default"), "unset optional must not be sent");

        // The full account number is never returned, only last4 — verify deserialization.
        PayoutBankAccount account = response;
        assertEquals("ba_1", account.id());
        assertEquals("6789", account.last4());
        assertEquals("Acme Inc", account.holderName());
        assertEquals("US", account.country());
        assertTrue(account.isDefault());
        assertTrue(account.livemode());
    }

    @Test
    void requestSendsAmountAndDescriptionAndParsesNetAmount() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", true,
                        "data", mapOf(
                                "id", "po_1",
                                "status", "pending",
                                "amount", 50000,
                                "fee", 250,
                                "netAmount", 49750,
                                "currency", "usd",
                                "description", "Weekly payout",
                                "providerTransferId", "tr_abc",
                                "createdAt", "2026-06-01T00:00:00.000Z",
                                "object", "payout",
                                "livemode", true
                        )
                ))));

        Payout response = payouts.request(
                RequestPayoutParams.builder(50000L)
                        .description("Weekly payout")
                        .idempotencyKey("idem_po")
                        .build());

        RecordedRequest request = server.takeRequest();
        assertEquals("POST", request.getMethod());
        assertEquals("/api/payouts", request.getPath());

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertEquals(50000, body.get("amount").asLong());
        assertEquals("Weekly payout", body.get("description").asText());

        // camelCase wire field net_amount@JsonProperty must map onto the long.
        Payout payout = response;
        assertEquals("po_1", payout.id());
        assertEquals(50000L, payout.amount());
        assertEquals(250L, payout.fee());
        assertEquals(49750L, payout.netAmount());
        assertEquals("tr_abc", payout.providerTransferId());
        assertTrue(payout.livemode());
    }

    @Test
    void completeVerificationSendsNoKycBody() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("{\"success\":true,\"data\":null}"));

        Void response = payouts.completeVerification(
                CompletePayoutVerificationParams.builder()
                        .idempotencyKey("idem_payout_verification")
                        .build());

        RecordedRequest request = server.takeRequest();
        assertEquals("POST", request.getMethod());
        assertEquals("/api/payouts/verification", request.getPath());
        assertEquals("idem_payout_verification", request.getHeader("Idempotency-Key"));
        assertEquals(0, request.getBodySize());
        assertNull(response);
    }

    private MockResponse bankAccountResponse() throws Exception {
        return new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", true,
                        "data", mapOf(
                                "id", "ba_1",
                                "providerExternalAccountId", "ext_1",
                                "holderName", "Acme Inc",
                                "last4", "6789",
                                "bankName", "Test Bank",
                                "country", "US",
                                "currency", "usd",
                                "accountType", "checking",
                                "isDefault", true,
                                "status", "new",
                                "createdAt", "2026-06-01T00:00:00.000Z",
                                "object", "payout_bank_account",
                                "livemode", true
                        )
                )));
    }

    private static Map<String, Object> mapOf(Object... kv) {
        Map<String, Object> m = new LinkedHashMap<>();
        for (int i = 0; i < kv.length; i += 2) {
            m.put((String) kv[i], kv[i + 1]);
        }
        return m;
    }
}
