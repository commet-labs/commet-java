package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.FeatureAccess;
import co.commet.models.FeatureAccessListResult;
import co.commet.params.GetFeatureAccessParams;
import co.commet.params.ListFeatureAccessParams;
import com.fasterxml.jackson.core.type.TypeReference;

import static co.commet.CommetHttpClient.buildBody;

public class FeatureAccessResource {

    private final CommetHttpClient http;

    public FeatureAccessResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Get one feature's access and current usage for a customer. To evaluate a prospective consumption, use POST /usage/check.
     */
    public FeatureAccess get(String code, GetFeatureAccessParams params) {
        return http.get("/feature-access/" + code, buildBody(
                "customer_id", params.getCustomerId()
        ), new TypeReference<FeatureAccess>() {}).getData();
    }

    /**
     * List a customer's feature access and current usage.
     */
    public FeatureAccessListResult list(ListFeatureAccessParams params) {
        return http.get("/feature-access", buildBody(
                "customer_id", params.getCustomerId()
        ), new TypeReference<FeatureAccessListResult>() {}).getData();
    }
}
