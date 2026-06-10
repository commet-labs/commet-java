package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.DeletedObject;
import co.commet.models.Feature;
import co.commet.params.CreateFeatureParams;
import co.commet.params.UpdateFeatureParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class FeaturesResource {

    private final CommetHttpClient http;

    public FeaturesResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * List every feature defined in the organization. This is the organization's feature catalog (definitions), not a customer's feature access.
     */
    public ApiResponse<List<Feature>> list() {
        return http.get("/features", new TypeReference<>() {});
    }

    /**
     * Get a single feature definition by code from the organization's feature catalog.
     */
    public ApiResponse<Feature> get(String code) {
        return http.get("/features/" + code, new TypeReference<>() {});
    }

    /**
     * Create a new feature. Code must be lowercase alphanumeric with underscores.
     */
    public ApiResponse<Feature> create(CreateFeatureParams params) {
        return http.post("/features/manage", buildBody(
                "name", params.getName(),
                "code", params.getCode(),
                "type", params.getType(),
                "description", params.getDescription(),
                "unit_name", params.getUnitName()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Update a feature's name, description, or unit name. At least one field must be provided.
     */
    public ApiResponse<Feature> update(String code, UpdateFeatureParams params) {
        return http.put("/features/" + code + "/manage", buildBody(
                "name", params.getName(),
                "description", params.getDescription(),
                "unit_name", params.getUnitName()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Delete a feature. Fails if the feature is attached to active plans or has an active add-on.
     */
    public ApiResponse<DeletedObject> delete(String code) {
        return http.delete("/features/" + code + "/manage", null, new TypeReference<>() {});
    }
}
