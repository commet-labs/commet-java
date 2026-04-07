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
        return track(feature, null, null, null, null, null, null, null, null, null, null);
    }

    public ApiResponse track(String feature, String customerId) {
        return track(feature, customerId, null, null, null, null, null, null, null, null, null);
    }

    public ApiResponse track(String feature, String customerId,
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

}
