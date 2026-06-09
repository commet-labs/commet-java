package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.CreditPack;
import co.commet.models.DeletedObject;
import co.commet.params.CreateCreditPackParams;
import co.commet.params.UpdateCreditPackParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class CreditPacksResource {

    private final CommetHttpClient http;

    public CreditPacksResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * List all active credit packs.
     */
    public ApiResponse<List<CreditPack>> list() {
        return http.get("/credit-packs", new TypeReference<>() {});
    }

    /**
     * Create a new credit pack.
     */
    public ApiResponse<CreditPack> create(CreateCreditPackParams params) {
        return http.post("/credit-packs/manage", buildBody(
                "name", params.getName(),
                "description", params.getDescription(),
                "credits", params.getCredits(),
                "price", params.getPrice(),
                "is_active", params.getIsActive()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Update a credit pack's name, description, credits, price, or active status.
     */
    public ApiResponse<CreditPack> update(String id, UpdateCreditPackParams params) {
        return http.put("/credit-packs/" + id, buildBody(
                "name", params.getName(),
                "description", params.getDescription(),
                "credits", params.getCredits(),
                "price", params.getPrice(),
                "is_active", params.getIsActive()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Soft-delete a credit pack.
     */
    public ApiResponse<DeletedObject> delete(String id) {
        return http.delete("/credit-packs/" + id, null, new TypeReference<>() {});
    }
}
