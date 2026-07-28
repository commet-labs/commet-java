package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.CreditPack;
import co.commet.models.CreditPacksListResult;
import co.commet.models.DeletedObject;
import co.commet.params.CreateCreditPackParams;
import co.commet.params.UpdateCreditPackParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class CreditPacksResource {

    private final CommetHttpClient http;

    public CreditPacksResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Update a credit pack's name, description, credits, price, or active status.
     */
    public CreditPack update(String id, UpdateCreditPackParams params) {
        return http.patch("/credit-packs/" + id, buildBody(
                "name", params.getName(),
                "description", params.getDescription(),
                "credits", params.getCredits(),
                "price", params.getPrice(),
                "is_active", params.getIsActive()
        ), params.getIdempotencyKey(), new TypeReference<CreditPack>() {}).getData();
    }

    /**
     * Soft-delete a credit pack.
     */
    public DeletedObject delete(String id) {
        return http.delete("/credit-packs/" + id, null, new TypeReference<DeletedObject>() {}).getData();
    }

    /**
     * List all active credit packs.
     */
    public CreditPacksListResult list() {
        return http.get("/credit-packs", new TypeReference<CreditPacksListResult>() {}).getData();
    }

    /**
     * Create a new credit pack.
     */
    public CreditPack create(CreateCreditPackParams params) {
        return http.post("/credit-packs", buildBody(
                "name", params.getName(),
                "description", params.getDescription(),
                "credits", params.getCredits(),
                "price", params.getPrice(),
                "is_active", params.getIsActive()
        ), params.getIdempotencyKey(), new TypeReference<CreditPack>() {}).getData();
    }
}
