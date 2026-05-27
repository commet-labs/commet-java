package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.DeleteResult;
import co.commet.models.Feature;
import co.commet.models.FeatureAccess;
import co.commet.models.FeatureDefinition;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class FeaturesResource {

    private final CommetHttpClient http;

    public FeaturesResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<Feature> get(String code, String customerId) {
        return http.get("/features/" + code, Map.of("customer_id", customerId),
                new TypeReference<>() {});
    }

    public ApiResponse<FeatureAccess> canUse(String code, String customerId) {
        return http.get("/features/" + code, Map.of("customer_id", customerId, "action", "canUse"),
                new TypeReference<>() {});
    }

    public ApiResponse<List<Feature>> list(String customerId) {
        return http.get("/features", Map.of("customer_id", customerId),
                new TypeReference<>() {});
    }

    public ApiResponse<FeatureDefinition> create(String code, String name, String type) {
        return create(code, name, type, null, null);
    }

    public ApiResponse<FeatureDefinition> create(String code, String name, String type,
                                                 String description, String unitName) {
        return http.post("/features/manage", buildBody(
                "code", code,
                "name", name,
                "type", type,
                "description", description,
                "unit_name", unitName
        ), new TypeReference<>() {});
    }

    public ApiResponse<FeatureDefinition> update(String code, String name, String description,
                                                 String unitName) {
        return http.put("/features/" + code + "/manage", buildBody(
                "name", name,
                "description", description,
                "unit_name", unitName
        ), new TypeReference<>() {});
    }

    public ApiResponse<DeleteResult> delete(String code) {
        return http.delete("/features/" + code + "/manage", null, new TypeReference<>() {});
    }
}
