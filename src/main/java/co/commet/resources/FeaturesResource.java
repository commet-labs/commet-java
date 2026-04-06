package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;

import java.util.Map;

public class FeaturesResource {

    private final CommetHttpClient http;

    public FeaturesResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse get(String code, String externalId) {
        return http.get("/features/" + code, Map.of("external_id", externalId));
    }

    public ApiResponse check(String code, String externalId) {
        ApiResponse result = http.get("/features/" + code, Map.of("external_id", externalId));

        if (!result.isSuccess() || result.getData() == null) {
            return new ApiResponse(false, Map.of("allowed", false), null, result.getMessage(), null, null);
        }

        @SuppressWarnings("unchecked")
        Map<String, Object> data = (Map<String, Object>) result.getData();
        boolean allowed = Boolean.TRUE.equals(data.get("allowed"));

        return new ApiResponse(true, Map.of("allowed", allowed), null, result.getMessage(), null, null);
    }

    public ApiResponse canUse(String code, String externalId) {
        return http.get("/features/" + code, Map.of("external_id", externalId, "action", "canUse"));
    }

    public ApiResponse list(String externalId) {
        return http.get("/features", Map.of("external_id", externalId));
    }
}
