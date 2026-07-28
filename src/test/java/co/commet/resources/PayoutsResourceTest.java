package co.commet.resources;

import co.commet.CommetHttpClient;
import co.commet.models.CompletePayoutVerificationParamsBank;
import co.commet.models.CompletePayoutVerificationParamsCompany;
import co.commet.models.CompletePayoutVerificationParamsCompanyAddress;
import co.commet.models.CompletePayoutVerificationParamsCompanyRepresentative;
import co.commet.models.CompletePayoutVerificationParamsIndividual;
import co.commet.models.CompletePayoutVerificationParamsIndividualAddress;
import co.commet.models.Payout;
import co.commet.models.PayoutBankAccount;
import co.commet.models.PayoutVerification;
import co.commet.models.PayoutVerificationVariant1;
import co.commet.models.PayoutVerificationVariant2;
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
    void completeVerificationSerializesDeeplyNestedBankIndividualAndCompanyRecords() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", true,
                        "data", mapOf(
                                "providerAccountId", "acct_1",
                                "status", "pending_verification",
                                "transfersEnabled", false,
                                "outcome", "created",
                                "businessType", "company",
                                "country", "US",
                                "object", "payout_verification",
                                "livemode", true
                        )
                ))));

        CompletePayoutVerificationParamsBank bank = new CompletePayoutVerificationParamsBank(
                "000123456789", "Acme Inc", "110000000", "checking");
        CompletePayoutVerificationParamsIndividual individual = new CompletePayoutVerificationParamsIndividual(
                "Ada", "Lovelace", "+15555550123", "1990-01-01", "1234", "id_99",
                new CompletePayoutVerificationParamsIndividualAddress(
                        "1 Main St", null, "Springfield", "IL", "62704", "US"));
        CompletePayoutVerificationParamsCompany company = new CompletePayoutVerificationParamsCompany(
                "Acme Inc", "tax_123",
                new CompletePayoutVerificationParamsCompanyAddress(
                        "2 Market St", "Suite 5", "San Francisco", "CA", "94103", "US"),
                new CompletePayoutVerificationParamsCompanyRepresentative(
                        "Grace", "Hopper", "+15555550124", "grace@acme.test"));

        PayoutVerification response = payouts.completeVerification(
                CompletePayoutVerificationParams.builder(
                                "ops@acme.test", "https://acme.test", "https://files/doc.pdf", bank, "company")
                        .individual(individual)
                        .company(company)
                        .build());

        RecordedRequest request = server.takeRequest();
        assertEquals("POST", request.getMethod());
        assertEquals("/api/payouts/verification", request.getPath());

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertEquals("ops@acme.test", body.get("email").asText());
        assertEquals("company", body.get("businessType").asText());
        assertEquals("https://acme.test", body.get("businessUrl").asText());
        assertEquals("https://files/doc.pdf", body.get("documentUrl").asText());

        // Nested bank record: @JsonProperty snake -> wire camelCase via convertKeys recursion.
        JsonNode wireBank = body.get("bank");
        assertNotNull(wireBank, "nested bank record must be serialized");
        assertEquals("000123456789", wireBank.get("accountNumber").asText());
        assertEquals("Acme Inc", wireBank.get("accountHolderName").asText());
        assertEquals("110000000", wireBank.get("routingNumber").asText());
        assertEquals("checking", wireBank.get("accountType").asText());
        assertFalse(wireBank.has("account_number"), "nested snake_case must not survive on the wire");

        // Doubly-nested individual.address record.
        JsonNode wireIndividual = body.get("individual");
        assertEquals("Ada", wireIndividual.get("firstName").asText());
        assertEquals("Lovelace", wireIndividual.get("lastName").asText());
        assertEquals("1990-01-01", wireIndividual.get("dateOfBirth").asText());
        assertEquals("1234", wireIndividual.get("ssnLast4").asText());
        assertEquals("id_99", wireIndividual.get("idNumber").asText());
        JsonNode individualAddress = wireIndividual.get("address");
        assertEquals("1 Main St", individualAddress.get("line1").asText());
        assertEquals("62704", individualAddress.get("postalCode").asText());
        // line2 was null: NON_NULL drops it inside the nested record too.
        assertFalse(individualAddress.has("line2"), "null nested field must be omitted");

        // Doubly-nested company.address and company.representative records.
        JsonNode wireCompany = body.get("company");
        assertEquals("Acme Inc", wireCompany.get("name").asText());
        assertEquals("tax_123", wireCompany.get("taxId").asText());
        assertEquals("Suite 5", wireCompany.get("address").get("line2").asText());
        assertEquals("grace@acme.test", wireCompany.get("representative").get("email").asText());
        assertEquals("Hopper", wireCompany.get("representative").get("lastName").asText());

        assertInstanceOf(PayoutVerificationVariant2.class, response);
        PayoutVerificationVariant2 verification = (PayoutVerificationVariant2) response;
        assertEquals("acct_1", verification.providerAccountId());
        assertFalse(verification.transfersEnabled());
        assertEquals("created", verification.outcome());
        assertEquals("company", verification.businessType());
    }

    @Test
    void completeVerificationOmitsOptionalIndividualAndCompanyWhenNotProvided() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("{\"success\":true,\"data\":{\"providerAccountId\":\"acct_2\",\"status\":\"pending_verification\","
                        + "\"transfersEnabled\":false,\"outcome\":\"existing\",\"object\":\"payout_account\",\"livemode\":false}}"));

        CompletePayoutVerificationParamsBank bank = new CompletePayoutVerificationParamsBank(
                "000999", "Solo Dev", null, null);

        PayoutVerification response = payouts.completeVerification(
                CompletePayoutVerificationParams.builder(
                                "solo@dev.test", "https://solo.dev", "https://files/id.pdf", bank, "individual")
                        .build());

        RecordedRequest request = server.takeRequest();
        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertTrue(body.has("bank"));
        assertFalse(body.has("individual"), "optional nested record left unset must be omitted");
        assertFalse(body.has("company"), "optional nested record left unset must be omitted");
        // Optional fields inside the bank record left null are omitted too.
        assertFalse(body.get("bank").has("routingNumber"));
        assertFalse(body.get("bank").has("accountType"));

        assertInstanceOf(PayoutVerificationVariant1.class, response);
        assertEquals("existing", ((PayoutVerificationVariant1) response).outcome());
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
