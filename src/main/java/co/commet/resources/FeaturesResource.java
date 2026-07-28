package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.DeletedObject;
import co.commet.models.Feature;
import co.commet.models.FeaturesListResult;
import co.commet.params.CreateFeatureParams;
import co.commet.params.UpdateFeatureParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class FeaturesResource {

    private final CommetHttpClient http;

    public FeaturesResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Get a single feature definition by code from the organization's feature catalog.
     */
    public Feature get(String code) {
        return http.get("/features/" + code, new TypeReference<Feature>() {}).getData();
    }

    /**
     * Update a feature's name, description, or unit name. At least one field must be provided.
     */
    public Feature update(String code, UpdateFeatureParams params) {
        return http.patch("/features/" + code, buildBody(
                "name", params.getName(),
                "description", params.getDescription(),
                "unit_name", params.getUnitName()
        ), params.getIdempotencyKey(), new TypeReference<Feature>() {}).getData();
    }

    /**
     * Delete a feature. Fails if the feature is attached to active plans or has an active add-on.
     */
    public DeletedObject delete(String code) {
        return http.delete("/features/" + code, null, new TypeReference<DeletedObject>() {}).getData();
    }

    /**
     * List every feature defined in the organization. This is the organization's feature catalog (definitions), not a customer's feature access.
     */
    public FeaturesListResult list() {
        return http.get("/features", new TypeReference<FeaturesListResult>() {}).getData();
    }

    /**
     * Create a new feature. Code must be lowercase alphanumeric with underscores.
     */
    public Feature create(CreateFeatureParams params) {
        return http.post("/features", buildBody(
                "name", params.getName(),
                "code", params.getCode(),
                "type", params.getType(),
                "description", params.getDescription(),
                "unit_name", params.getUnitName()
        ), params.getIdempotencyKey(), new TypeReference<Feature>() {}).getData();
    }
}
