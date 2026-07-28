package co.commet.resources;

import co.commet.CommetHttpClient;
import co.commet.models.CreatedSubscription;
import co.commet.params.CreateSubscriptionParams;
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

class SubscriptionsCreateCustomIntroOfferTest {

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
    void createSendsOfferIdFromContract() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("{\"success\":true,\"data\":{\"id\":\"sub_1\"}}"));

        CreatedSubscription response = subscriptions.create(
                CreateSubscriptionParams.builder("cus_1")
                        .planId("plan_pro")
                        .offerId("offer_1")
                        .build());

        RecordedRequest request = server.takeRequest();
        assertEquals("POST", request.getMethod());
        assertTrue(request.getPath().endsWith("/subscriptions"),
                "unexpected path: " + request.getPath());

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertEquals("offer_1", body.get("offerId").asText());
        assertFalse(body.has("introOffer"));
        assertNotNull(response);
    }
}
