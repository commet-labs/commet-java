package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.QuotaAllowance;
import co.commet.models.QuotaEvent;
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
    void addPostsToUsageQuotaWithCountDefaultingToOne() throws Exception {
        server.enqueue(quotaEventResponse());

        ApiResponse<QuotaEvent> response = quota.add("projects");

        RecordedRequest request = server.takeRequest();
        assertEquals("POST", request.getMethod());
        assertEquals("/api/usage/quota", request.getPath());

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertEquals("projects", body.get("featureCode").asText());
        assertEquals(1, body.get("count").asInt());
        assertFalse(body.has("customerId"));

        assertTrue(response.isSuccess());
        assertEquals("qe_1", response.getData().id());
        assertEquals(11, response.getData().newBalance());
    }

    @Test
    void addPassesExplicitCountAndCustomerId() throws Exception {
        server.enqueue(quotaEventResponse());

        quota.add("projects", 5, "cus_1", "idem_1");

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

        quota.set("projects", 100);

        RecordedRequest request = server.takeRequest();
        assertEquals("PUT", request.getMethod());
        assertEquals("/api/usage/quota", request.getPath());

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertEquals("projects", body.get("featureCode").asText());
        assertEquals(100, body.get("count").asInt());
    }

    @Test
    void removeDeletesFromUsageQuotaWithCountDefaultingToOne() throws Exception {
        server.enqueue(quotaEventResponse());

        quota.remove("projects");

        RecordedRequest request = server.takeRequest();
        assertEquals("DELETE", request.getMethod());
        assertEquals("/api/usage/quota", request.getPath());

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertEquals("projects", body.get("featureCode").asText());
        assertEquals(1, body.get("count").asInt());
    }

    @Test
    void getReturnsSingleAllowanceFromUsageQuota() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", true,
                        "data", Map.of(
                                "featureCode", "projects",
                                "current", 5,
                                "included", 100,
                                "remaining", 95,
                                "billedQuantity", 100,
                                "unlimited", false,
                                "overageEnabled", true,
                                "asOf", "2026-05-29T00:00:00.000Z"
                        )
                ))));

        ApiResponse<QuotaAllowance> response = quota.get("projects", "cus_1");

        RecordedRequest request = server.takeRequest();
        assertEquals("GET", request.getMethod());
        assertEquals("/api/usage/quota?featureCode=projects&customerId=cus_1", request.getPath());

        assertTrue(response.isSuccess());
        QuotaAllowance allowance = response.getData();
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
                                        "featureCode", "projects",
                                        "current", 42,
                                        "included", 1000,
                                        "remaining", 958,
                                        "billedQuantity", 1000,
                                        "unlimited", false,
                                        "overageEnabled", true,
                                        "asOf", "2026-05-29T00:00:00.000Z"
                                )
                        )
                ))));

        ApiResponse<List<QuotaAllowance>> response = quota.getAll("cus_1");

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
                                "customerId", "cus_1",
                                "featureCode", "projects",
                                "previousBalance", 10,
                                "newBalance", 11,
                                "ts", "2026-05-29T00:00:00.000Z",
                                "createdAt", "2026-05-29T00:00:00.000Z"
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
