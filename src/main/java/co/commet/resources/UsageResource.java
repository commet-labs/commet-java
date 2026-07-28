package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.UsageAdjustment;
import co.commet.models.UsageCheck;
import co.commet.models.UsageEvent;
import co.commet.params.CheckUsageAvailabilityParams;
import co.commet.params.SetUsageParams;
import co.commet.params.TrackUsageParams;
import com.fasterxml.jackson.core.type.TypeReference;

import static co.commet.CommetHttpClient.buildBody;

public class UsageResource {

    private final CommetHttpClient http;

    public UsageResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Check if a customer can consume a feature before actual consumption. Returns availability and cost estimates based on the plan's consumption model.
     */
    public UsageCheck check(CheckUsageAvailabilityParams params) {
        return http.post("/usage/check", buildBody(
                "customer_id", params.getCustomerId(),
                "feature_code", params.getFeatureCode(),
                "quantity", params.getQuantity()
        ), params.getIdempotencyKey(), new TypeReference<UsageCheck>() {}).getData();
    }

    /**
     * Track a usage event for a metered feature. Deducts from balance/credits if applicable.
     */
    public UsageEvent track(TrackUsageParams params) {
        return http.post("/usage/events", buildBody(
                "feature_code", params.getFeatureCode(),
                "customer_id", params.getCustomerId(),
                "event_id", params.getEventId(),
                "timestamp", params.getTimestamp(),
                "properties", params.getProperties(),
                "model", params.getModel(),
                "input_tokens", params.getInputTokens(),
                "output_tokens", params.getOutputTokens(),
                "value", params.getValue(),
                "cache_read_tokens", params.getCacheReadTokens(),
                "cache_write_tokens", params.getCacheWriteTokens()
        ), params.getIdempotencyKey(), new TypeReference<UsageEvent>() {}).getData();
    }

    /**
     * Set a metered feature's usage to an exact value for the current period. Use the Idempotency-Key header to make retries safe.
     */
    public UsageAdjustment set(SetUsageParams params) {
        return http.put("/usage", buildBody(
                "customer_id", params.getCustomerId(),
                "feature_code", params.getFeatureCode(),
                "value", params.getValue(),
                "reason", params.getReason()
        ), params.getIdempotencyKey(), new TypeReference<UsageAdjustment>() {}).getData();
    }
}
