package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.CheckResult;
import co.commet.models.Feature;
import co.commet.models.FeatureAccess;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

public class FeaturesResource {

    private final CommetHttpClient http;

    public FeaturesResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<Feature> get(String code, String customerId) {
        return http.get("/features/" + code, Map.of("customer_id", customerId),
                new TypeReference<>() {});
    }

    public ApiResponse<CheckResult> check(String code, String customerId) {
        ApiResponse<Feature> result = http.get("/features/" + code, Map.of("customer_id", customerId),
                new TypeReference<>() {});

        if (!result.isSuccess()) {
            return new ApiResponse<>(false, null, result.getCode(), result.getMessage(), null, null);
        }

        return new ApiResponse<>(true, new CheckResult(result.getData().allowed()), null, null, null, null);
    }

    public ApiResponse<FeatureAccess> canUse(String code, String customerId) {
        return http.get("/features/" + code, Map.of("customer_id", customerId, "action", "canUse"),
                new TypeReference<>() {});
    }

    public ApiResponse<List<Feature>> list(String customerId) {
        return http.get("/features", Map.of("customer_id", customerId),
                new TypeReference<>() {});
    }
}
