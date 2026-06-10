package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.FeatureAccess;
import co.commet.models.FeatureLookup;
import co.commet.params.CanUseFeatureParams;
import co.commet.params.GetFeatureAccessParams;
import co.commet.params.ListFeatureAccessParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

import static co.commet.CommetHttpClient.buildBody;

public class FeatureAccessResource {

    private final CommetHttpClient http;

    public FeatureAccessResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * List all features for a customer's active subscription, scoped by the customerId query parameter.
     */
    public ApiResponse<List<FeatureAccess>> list(ListFeatureAccessParams params) {
        return http.get("/feature-access", buildBody(
                "customer_id", params.getCustomerId()
        ), new TypeReference<>() {});
    }

    /**
     * Get feature access details for a customer. Use action=canUse to check if the customer can consume one more unit.
     */
    public ApiResponse<FeatureLookup> get(String code, GetFeatureAccessParams params) {
        return http.get("/feature-access/" + code, buildBody(
                "customer_id", params.getCustomerId(),
                "action", params.getAction()
        ), new TypeReference<>() {});
    }

    /**
     * Get feature access details for a customer. Use action=canUse to check if the customer can consume one more unit.
     */
    public ApiResponse<FeatureLookup> canUse(String code, CanUseFeatureParams params) {
        return http.get("/feature-access/" + code, buildBody(
                "customer_id", params.getCustomerId(),
                "action", "canUse"
        ), new TypeReference<>() {});
    }
}
