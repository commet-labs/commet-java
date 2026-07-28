package co.commet.resources;

import co.commet.CommetHttpClient;
import co.commet.models.Subscription;
import co.commet.models.SubscriptionStatus;
import co.commet.params.GetActiveSubscriptionParams;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionsGetActiveTest {

    private MockWebServer server;
    private SubscriptionsResource subscriptions;

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
    void getActiveDeserializesRawSubscription() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("{\"success\":true,\"data\":{"
                        + "\"id\":\"sub_123\","
                        + "\"customerId\":\"cus_456\","
                        + "\"name\":\"Pro\","
                        + "\"status\":\"active\","
                        + "\"cancelAtPeriodEnd\":false,"
                        + "\"startDate\":\"2026-01-01\"}}"));

        Subscription response = subscriptions.getActive(
                GetActiveSubscriptionParams.builder("cus_456").build());

        RecordedRequest request = server.takeRequest();
        assertEquals("GET", request.getMethod());
        assertTrue(request.getPath().startsWith("/api/subscriptions/active"),
                "unexpected path: " + request.getPath());

        Subscription subscription = response;
        assertNotNull(subscription, "a raw subscription object under data must hydrate, not deserialize to null");
        assertEquals("sub_123", subscription.id());
        assertEquals("cus_456", subscription.customerId());
        assertEquals("Pro", subscription.name());
        assertEquals(SubscriptionStatus.ACTIVE, subscription.status());
    }

    @Test
    void getActiveDeserializesNullDataToNull() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("{\"success\":true,\"data\":null}"));

        Subscription response = subscriptions.getActive(
                GetActiveSubscriptionParams.builder("cus_456").build());

        assertNull(response, "data: null (no active subscription) must parse to null data");
    }
}
