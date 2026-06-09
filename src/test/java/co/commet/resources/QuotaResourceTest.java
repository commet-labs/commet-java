package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.UsageQuota;
import co.commet.models.UsageQuotaEvent;
import co.commet.params.AddQuotaParams;
import co.commet.params.GetAllQuotaAllowancesParams;
import co.commet.params.GetQuotaAllowanceParams;
import co.commet.params.RemoveQuotaParams;
import co.commet.params.SetQuotaParams;
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
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuotaResourceTest {

    private MockWebServer server;
    private QuotaResource quota;
    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() throws IOException {
        server = new MockWebServer();
        server.start();

        String baseUrl = server.url("/").toString();
        CommetHttpClient http = new TestableHttpClient("ck_test_key", baseUrl, Duration.ofSeconds(5), 0);
        quota = new QuotaResource(http);
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    @Test
    void addPostsToUsageQuotaWithoutClientSideCountDefault() throws Exception {
        server.enqueue(quotaEventResponse());

        ApiResponse<UsageQuotaEvent> response = quota.add(AddQuotaParams.builder("projects").build());

        RecordedRequest request = server.takeRequest();
        assertEquals("POST", request.getMethod());
        assertEquals("/api/usage/quota", request.getPath());

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertEquals("projects", body.get("featureCode").asText());
        assertFalse(body.has("count"));
        assertFalse(body.has("customerId"));

        assertTrue(response.isSuccess());
        assertEquals("qe_1", response.getData().id());
        assertEquals(11, response.getData().newBalance());
    }

    @Test
    void addPassesExplicitCountAndCustomerId() throws Exception {
        server.enqueue(quotaEventResponse());

        quota.add(AddQuotaParams.builder("projects")
                .count(5L)
                .customerId("cus_1")
                .idempotencyKey("idem_1")
                .build());

        RecordedRequest request = server.takeRequest();
        assertEquals("POST", request.getMethod());
        assertEquals("/api/usage/quota", request.getPath());
        assertEquals("idem_1", request.getHeader("Idempotency-Key"));

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertEquals("projects", body.get("featureCode").asText());
        assertEquals(5, body.get("count").asInt());
        assertEquals("cus_1", body.get("customerId").asText());
    }

    @Test
    void setPutsExactCountToUsageQuota() throws Exception {
        server.enqueue(quotaEventResponse());

        quota.set(SetQuotaParams.builder("projects", 100L).build());

        RecordedRequest request = server.takeRequest();
        assertEquals("PUT", request.getMethod());
        assertEquals("/api/usage/quota", request.getPath());

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertEquals("projects", body.get("featureCode").asText());
        assertEquals(100, body.get("count").asInt());
    }

    @Test
    void removeDeletesFromUsageQuotaWithoutClientSideCountDefault() throws Exception {
        server.enqueue(quotaEventResponse());

        quota.remove(RemoveQuotaParams.builder("projects").build());

        RecordedRequest request = server.takeRequest();
        assertEquals("DELETE", request.getMethod());
        assertEquals("/api/usage/quota", request.getPath());

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertEquals("projects", body.get("featureCode").asText());
        assertFalse(body.has("count"));
    }

    @Test
    void getReturnsSingleAllowanceFromUsageQuota() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", true,
                        "data", Map.of(
                                "feature_code", "projects",
                                "current", 5,
                                "included", 100,
                                "remaining", 95,
                                "billed_quantity", 100,
                                "unlimited", false,
                                "overage_enabled", true,
                                "as_of", "2026-05-29T00:00:00.000Z"
                        )
                ))));

        ApiResponse<UsageQuota> response = quota.get(GetQuotaAllowanceParams.builder("cus_1", "projects").build());

        RecordedRequest request = server.takeRequest();
        assertEquals("GET", request.getMethod());
        assertEquals("/api/usage/quota?customerId=cus_1&featureCode=projects", request.getPath());

        assertTrue(response.isSuccess());
        UsageQuota allowance = response.getData();
        assertEquals("projects", allowance.featureCode());
        assertEquals(5, allowance.current());
        assertEquals(100, allowance.included());
        assertEquals(95, allowance.remaining());
        assertEquals(100, allowance.billedQuantity());
        assertFalse(allowance.unlimited());
        assertTrue(allowance.overageEnabled());
        assertEquals("2026-05-29T00:00:00.000Z", allowance.asOf());
    }

    @Test
    void getAllReturnsListOfAllowancesFromUsageQuotaAll() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", true,
                        "data", List.of(
                                Map.of(
                                        "feature_code", "projects",
                                        "current", 42,
                                        "included", 1000,
                                        "remaining", 958,
                                        "billed_quantity", 1000,
                                        "unlimited", false,
                                        "overage_enabled", true,
                                        "as_of", "2026-05-29T00:00:00.000Z"
                                )
                        )
                ))));

        ApiResponse<List<UsageQuota>> response = quota.getAll(GetAllQuotaAllowancesParams.builder("cus_1").build());

        RecordedRequest request = server.takeRequest();
        assertEquals("GET", request.getMethod());
        assertEquals("/api/usage/quota/all?customerId=cus_1", request.getPath());

        assertTrue(response.isSuccess());
        assertEquals(1, response.getData().size());
        assertEquals("projects", response.getData().get(0).featureCode());
        assertEquals(42, response.getData().get(0).current());
        assertEquals(958, response.getData().get(0).remaining());
        assertEquals(1000, response.getData().get(0).billedQuantity());
    }

    private MockResponse quotaEventResponse() throws Exception {
        return new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", true,
                        "data", Map.of(
                                "id", "qe_1",
                                "customer_id", "cus_1",
                                "feature_code", "projects",
                                "previous_balance", 10,
                                "new_balance", 11,
                                "ts", "2026-05-29T00:00:00.000Z",
                                "created_at", "2026-05-29T00:00:00.000Z"
                        )
                )));
    }

    static class TestableHttpClient extends CommetHttpClient {
        TestableHttpClient(String apiKey, String baseUrl, Duration timeout, int retries) {
            super(apiKey, timeout, retries);
            try {
                var field = CommetHttpClient.class.getDeclaredField("baseUrl");
                field.setAccessible(true);
                field.set(this, baseUrl + "api");
            } catch (Exception e) {
                throw new RuntimeException("Failed to set base URL for testing", e);
            }
        }
    }
}
