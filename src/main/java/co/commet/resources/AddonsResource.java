package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Addon;
import co.commet.models.AddonsListActiveResult;
import co.commet.models.AddonsListResult;
import co.commet.models.DeletedObject;
import co.commet.params.CreateAddonParams;
import co.commet.params.ListActiveAddonsParams;
import co.commet.params.ListAddonsParams;
import co.commet.params.UpdateAddonParams;
import com.fasterxml.jackson.core.type.TypeReference;

import static co.commet.CommetHttpClient.buildBody;

public class AddonsResource {

    private final CommetHttpClient http;

    public AddonsResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * List all active add-ons for a customer's subscription.
     */
    public AddonsListActiveResult listActive(ListActiveAddonsParams params) {
        return http.get("/active-addons", buildBody(
                "customer_id", params.getCustomerId()
        ), new TypeReference<AddonsListActiveResult>() {}).getData();
    }

    /**
     * Retrieve an add-on by its public ID or slug.
     */
    public Addon get(String id) {
        return http.get("/addons/" + id, new TypeReference<Addon>() {}).getData();
    }

    /**
     * Update an add-on's name, description, or pricing.
     */
    public Addon update(String id, UpdateAddonParams params) {
        return http.patch("/addons/" + id, buildBody(
                "name", params.getName(),
                "description", params.getDescription(),
                "base_price", params.getBasePrice(),
                "included_units", params.getIncludedUnits(),
                "overage_rate", params.getOverageRate()
        ), params.getIdempotencyKey(), new TypeReference<Addon>() {}).getData();
    }

    /**
     * Soft-delete an add-on. Fails if the add-on has active subscriptions.
     */
    public DeletedObject delete(String id) {
        return http.delete("/addons/" + id, null, new TypeReference<DeletedObject>() {}).getData();
    }

    /**
     * List all add-ons with cursor-based pagination.
     */
    public AddonsListResult list(ListAddonsParams params) {
        return http.get("/addons", buildBody(
                "cursor", params.getCursor(),
                "limit", params.getLimit()
        ), new TypeReference<AddonsListResult>() {}).getData();
    }

    /**
     * Create a new add-on linked to a feature. Each feature can only be assigned to one add-on.
     */
    public Addon create(CreateAddonParams params) {
        return http.post("/addons", buildBody(
                "name", params.getName(),
                "description", params.getDescription(),
                "base_price", params.getBasePrice(),
                "feature_id", params.getFeatureId(),
                "consumption_model", params.getConsumptionModel(),
                "included_units", params.getIncludedUnits(),
                "overage_rate", params.getOverageRate(),
                "credit_cost", params.getCreditCost()
        ), params.getIdempotencyKey(), new TypeReference<Addon>() {}).getData();
    }
}
