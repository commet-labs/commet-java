package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.ActiveAddon;
import co.commet.models.AddonDetail;
import co.commet.models.DeleteResult;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class AddonsResource {

    private final CommetHttpClient http;

    public AddonsResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<List<ActiveAddon>> listActive(String customerId) {
        return http.get("/addons/active", Map.of("customer_id", customerId),
                new TypeReference<>() {});
    }

    public ApiResponse<List<AddonDetail>> list() {
        return list(null, null);
    }

    public ApiResponse<List<AddonDetail>> list(Integer limit, String cursor) {
        return http.get("/addons", buildBody(
                "limit", limit,
                "cursor", cursor
        ), new TypeReference<>() {});
    }

    public ApiResponse<AddonDetail> get(String id) {
        return http.get("/addons/" + id, new TypeReference<>() {});
    }

    public ApiResponse<AddonDetail> create(String name, long basePrice, String featureId,
                                           String consumptionModel) {
        return create(name, basePrice, featureId, consumptionModel, null, null, null, null, null);
    }

    public ApiResponse<AddonDetail> create(String name, long basePrice, String featureId,
                                           String consumptionModel, String description,
                                           Integer includedUnits, Long overageRate,
                                           Integer creditCost, Map<String, Object> extra) {
        Map<String, Object> body = buildBody(
                "name", name,
                "base_price", basePrice,
                "feature_id", featureId,
                "consumption_model", consumptionModel,
                "description", description,
                "included_units", includedUnits,
                "overage_rate", overageRate,
                "credit_cost", creditCost
        );
        return http.post("/addons", body, new TypeReference<>() {});
    }

    public ApiResponse<AddonDetail> update(String id, String name, String description,
                                           Long basePrice, Integer includedUnits, Long overageRate) {
        return http.put("/addons/" + id, buildBody(
                "name", name,
                "description", description,
                "base_price", basePrice,
                "included_units", includedUnits,
                "overage_rate", overageRate
        ), new TypeReference<>() {});
    }

    public ApiResponse<DeleteResult> delete(String id) {
        return http.delete("/addons/" + id, null, new TypeReference<>() {});
    }
}
