package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.UsageEvent;
import co.commet.params.TrackParams;
import com.fasterxml.jackson.core.type.TypeReference;

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

    public ApiResponse<UsageEvent> track(String feature, String customerId) {
        return track(TrackParams.builder(feature).customerId(customerId).build());
    }

    public ApiResponse<UsageEvent> track(TrackParams params) {
        List<Map<String, Object>> formattedProperties = null;
        if (params.getProperties() != null) {
            formattedProperties = new ArrayList<>();
            for (Map.Entry<String, String> entry : params.getProperties().entrySet()) {
                formattedProperties.add(Map.of("property", entry.getKey(), "value", entry.getValue()));
            }
        }

        Map<String, Object> body = buildBody(
                "feature", params.getFeature(),
                "customer_id", params.getCustomerId(),
                "idempotency_key", params.getIdempotencyKey(),
                "timestamp", params.getTimestamp() != null ? params.getTimestamp() : Instant.now().toString(),
                "properties", formattedProperties
        );

        if (params.getModel() != null) {
            body.putAll(buildBody(
                    "model", params.getModel(),
                    "input_tokens", params.getInputTokens(),
                    "output_tokens", params.getOutputTokens(),
                    "cache_read_tokens", params.getCacheReadTokens(),
                    "cache_write_tokens", params.getCacheWriteTokens()
            ));
        } else if (params.getValue() != null) {
            body.put("value", params.getValue());
        }

        return http.post("/usage/events", body, params.getIdempotencyKey(), new TypeReference<>() {});
    }

}
