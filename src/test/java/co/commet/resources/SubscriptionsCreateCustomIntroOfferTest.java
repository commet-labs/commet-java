package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Subscription;
import co.commet.params.CreateSubscriptionParams;
import co.commet.params.CustomIntroOffer;
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
    void createSendsCustomIntroOfferAsNestedCamelCaseInRequestBody() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("{\"success\":true,\"data\":{\"id\":\"sub_1\"}}"));

        ApiResponse<Subscription> response = subscriptions.create(
                CreateSubscriptionParams.builder("cus_1", "plan_pro")
                        .customIntroOffer(CustomIntroOffer.builder("percentage", 2500, 3).build())
                        .build());

        RecordedRequest request = server.takeRequest();
        assertEquals("POST", request.getMethod());
        assertTrue(request.getPath().endsWith("/subscriptions"),
                "unexpected path: " + request.getPath());

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertFalse(body.has("custom_intro_offer"), "body must not carry the snake_case key on the wire");

        JsonNode offer = body.get("customIntroOffer");
        assertNotNull(offer, "body must carry the nested customIntroOffer object");
        assertEquals("percentage", offer.get("discountType").asText());
        assertEquals(2500, offer.get("discountValue").asLong());
        assertEquals(3, offer.get("durationCycles").asInt());
        assertFalse(offer.has("discount_type"), "nested object must not carry snake_case keys");
        assertFalse(offer.has("discount_value"), "nested object must not carry snake_case keys");
        assertFalse(offer.has("duration_cycles"), "nested object must not carry snake_case keys");

        assertTrue(response.isSuccess());
    }
}
