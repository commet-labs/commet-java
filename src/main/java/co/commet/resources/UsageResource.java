package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class UsageResource {

    private final CommetHttpClient http;

    public UsageResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse track(String feature) {
        return track(feature, null, null, null, null, null, null, null, null, null, null, null);
    }

    public ApiResponse track(String feature, String externalId) {
        return track(feature, null, externalId, null, null, null, null, null, null, null, null, null);
    }

    public ApiResponse track(String feature, String customerId, String externalId,
                             Integer value, String model, Integer inputTokens,
                             Integer outputTokens, Integer cacheReadTokens,
                             Integer cacheWriteTokens, String idempotencyKey,
                             String timestamp, Map<String, String> properties) {
        List<Map<String, Object>> formattedProperties = null;
        if (properties != null) {
            formattedProperties = new ArrayList<>();
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                formattedProperties.add(Map.of("property", entry.getKey(), "value", entry.getValue()));
            }
        }

        Map<String, Object> body = buildBody(
                "feature", feature,
                "customer_id", customerId,
                "external_id", externalId,
                "idempotency_key", idempotencyKey,
                "timestamp", timestamp != null ? timestamp : Instant.now().toString(),
                "properties", formattedProperties
        );

        if (model != null) {
            body.putAll(buildBody(
                    "model", model,
                    "input_tokens", inputTokens,
                    "output_tokens", outputTokens,
                    "cache_read_tokens", cacheReadTokens,
                    "cache_write_tokens", cacheWriteTokens
            ));
        } else if (value != null) {
            body.put("value", value);
        }

        return http.post("/usage/events", body, idempotencyKey);
    }

    public ApiResponse trackBatch(List<Map<String, Object>> events) {
        return trackBatch(events, null);
    }

    @SuppressWarnings("unchecked")
    public ApiResponse trackBatch(List<Map<String, Object>> events, String idempotencyKey) {
        List<Map<String, Object>> mapped = new ArrayList<>();

        for (Map<String, Object> evt : events) {
            Map<String, String> props = (Map<String, String>) evt.get("properties");
            List<Map<String, Object>> formattedProperties = null;
            if (props != null) {
                formattedProperties = new ArrayList<>();
                for (Map.Entry<String, String> entry : props.entrySet()) {
                    formattedProperties.add(Map.of("property", entry.getKey(), "value", entry.getValue()));
                }
            }

            Map<String, Object> entry = buildBody(
                    "feature", evt.get("feature"),
                    "customer_id", evt.get("customer_id"),
                    "external_id", evt.get("external_id"),
                    "idempotency_key", evt.get("idempotency_key"),
                    "timestamp", evt.get("timestamp") != null ? evt.get("timestamp") : Instant.now().toString(),
                    "properties", formattedProperties
            );

            if (evt.get("model") != null) {
                entry.putAll(buildBody(
                        "model", evt.get("model"),
                        "input_tokens", evt.get("input_tokens"),
                        "output_tokens", evt.get("output_tokens"),
                        "cache_read_tokens", evt.get("cache_read_tokens"),
                        "cache_write_tokens", evt.get("cache_write_tokens")
                ));
            } else if (evt.get("value") != null) {
                entry.put("value", evt.get("value"));
            }

            mapped.add(entry);
        }

        return http.post("/usage/events/batch", Map.of("events", mapped), idempotencyKey);
    }
}
