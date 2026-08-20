package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.TestClock;
import co.commet.models.TestClockRun;
import co.commet.params.AdvanceTestClockParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class TestClockResource {

    private final CommetHttpClient http;

    public TestClockResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Deprecated. POST /test-clock now advances time and processes every due billing deadline in one durable run.
     * @deprecated
     */
    public Void processBilling() {
        return http.post("/test-clock/process-billing", Map.of(), new TypeReference<Void>() {}).getData();
    }

    /**
     * Returns the organization's current test clock state and latest durable run. Sandbox only.
     */
    public TestClock get() {
        return http.get("/test-clock", new TypeReference<TestClock>() {}).getData();
    }

    /**
     * Starts a durable run that moves the test clock forward and processes every billing deadline due before the target time. Poll GET /test-clock for progress and terminal results. Sandbox only.
     */
    public TestClockRun advance(AdvanceTestClockParams params) {
        return http.post("/test-clock", buildBody(
                "advance_days", params.getAdvanceDays(),
                "frozen_time", params.getFrozenTime()
        ), params.getIdempotencyKey(), new TypeReference<TestClockRun>() {}).getData();
    }
}
