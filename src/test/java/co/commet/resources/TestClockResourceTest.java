package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.TestClock;
import co.commet.models.TestClockBilling;
import co.commet.params.AdvanceTestClockParams;
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

class TestClockResourceTest {

    private MockWebServer server;
    private TestClockResource testClock;
    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() throws IOException {
        server = new MockWebServer();
        server.start();

        String baseUrl = server.url("/").toString();
        CommetHttpClient http = new QuotaResourceTest.TestableHttpClient("ck_test_key", baseUrl, Duration.ofSeconds(5), 0);
        testClock = new TestClockResource(http);
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    @Test
    void getReadsClockStateAndMapsBoxedAndPrimitiveBooleans() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", true,
                        "data", mapOf(
                                "simulatedTime", "2026-07-01T00:00:00.000Z",
                                "isActive", true,
                                "now", "2026-06-08T00:00:00.000Z",
                                "object", "test_clock",
                                "livemode", false
                        )
                ))));

        TestClock response = testClock.get();

        RecordedRequest request = server.takeRequest();
        assertEquals("GET", request.getMethod());
        assertEquals("/api/test-clock", request.getPath());

        TestClock clock = response;
        // camelCase wire keys deserialize into snake_case @JsonProperty record fields.
        assertEquals("2026-07-01T00:00:00.000Z", clock.simulatedTime());
        assertTrue(clock.isActive());
        assertEquals("2026-06-08T00:00:00.000Z", clock.now());
        assertFalse(clock.livemode());
    }

    @Test
    void advanceSendsOnlyAdvanceDaysWhenFrozenTimeUnset() throws Exception {
        server.enqueue(clockResponse());

        testClock.advance(AdvanceTestClockParams.builder()
                .advanceDays(7L)
                .idempotencyKey("idem_adv")
                .build());

        RecordedRequest request = server.takeRequest();
        assertEquals("POST", request.getMethod());
        assertEquals("/api/test-clock", request.getPath());
        assertEquals("idem_adv", request.getHeader("Idempotency-Key"));

        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertEquals(7, body.get("advanceDays").asLong());
        assertFalse(body.has("advance_days"), "no snake_case key may leak onto the wire");
        // frozenTime never set -> NON_NULL must drop it (the two params are mutually exclusive).
        assertFalse(body.has("frozenTime"), "unset optional must not be sent");
        assertFalse(body.has("frozen_time"), "unset optional must not be sent");
    }

    @Test
    void advanceSendsOnlyFrozenTimeWhenAdvanceDaysUnset() throws Exception {
        server.enqueue(clockResponse());

        testClock.advance(AdvanceTestClockParams.builder()
                .frozenTime("2026-08-01T00:00:00.000Z")
                .build());

        RecordedRequest request = server.takeRequest();
        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertEquals("2026-08-01T00:00:00.000Z", body.get("frozenTime").asText());
        assertFalse(body.has("advanceDays"), "unset optional must not be sent");
    }

    @Test
    void processBillingPostsEmptyBodyAndParsesCounts() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", true,
                        "data", mapOf(
                                "customersFound", 12,
                                "enqueued", 11,
                                "failed", 1,
                                "object", "test_clock_billing",
                                "livemode", false
                        )
                ))));

        TestClockBilling response = testClock.processBilling();

        RecordedRequest request = server.takeRequest();
        assertEquals("POST", request.getMethod());
        assertEquals("/api/test-clock/process-billing", request.getPath());

        // No-param POST: the empty Map.of() body must serialize to an empty JSON object.
        JsonNode body = mapper.readTree(request.getBody().readUtf8());
        assertTrue(body.isObject());
        assertEquals(0, body.size(), "no-param POST must send an empty object, not stray keys");

        TestClockBilling billing = response;
        assertEquals(12L, billing.customersFound());
        assertEquals(11L, billing.enqueued());
        assertEquals(1L, billing.failed());
    }

    private MockResponse clockResponse() throws Exception {
        return new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", true,
                        "data", mapOf(
                                "simulatedTime", "2026-07-08T00:00:00.000Z",
                                "isActive", true,
                                "now", "2026-06-08T00:00:00.000Z",
                                "object", "test_clock",
                                "livemode", false
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
