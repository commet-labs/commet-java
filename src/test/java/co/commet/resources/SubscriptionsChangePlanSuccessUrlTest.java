package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.PlanChange;
import co.commet.params.ChangePlanParams;
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

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionsChangePlanSuccessUrlTest {

    private MockWebServer server;
    private SubscriptionsResource subscriptions;
    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() throws IOException {
        server = new MockWebServer();
        server.start();

        String baseUrl = server.url("/").toString();
        CommetHttpClient http = new QuotaResourceTest.TestableHttpClient("ck_test_key", baseUrl, Duration.ofSeconds(5), 0);
        subscriptions = new SubscriptionsResource(http);
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    @Test
    void changePlanSendsSuccessUrlAndNewPlanIdInRequestBody() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("{\"success\":true,\"data\":{\"id\":\"sub_1\",\"scheduled\":false}}"));

        PlanChange response = subscriptions.changePlan(
                "sub_1",
                ChangePlanParams.builder()
                        .newPlanId("plan_pro")
                        .successUrl("https://app.example.com/billing/success")
                        .build());

        RecordedRequest request = server.takeRequest();
        assertEquals("POST", request.getMethod());
        assertTrue(request.getPath().endsWith("/subscriptions/sub_1/change-plan"),
                "unexpected path: " + request.getPath());

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertEquals("https://app.example.com/billing/success", body.get("successUrl").asText());
        assertFalse(body.has("success_url"), "body must not carry the snake_case key on the wire");
        assertEquals("plan_pro", body.get("newPlanId").asText());

        assertNotNull(response);
    }
}
