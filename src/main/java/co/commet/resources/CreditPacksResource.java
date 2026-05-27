package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.CreditPack;
import co.commet.models.CreditPackDetail;
import co.commet.models.DeleteResult;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

import static co.commet.CommetHttpClient.buildBody;

public class CreditPacksResource {

    private final CommetHttpClient http;

    public CreditPacksResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<List<CreditPack>> list() {
        return http.get("/credit-packs", new TypeReference<>() {});
    }

    public ApiResponse<CreditPackDetail> create(String name, int credits, long price) {
        return create(name, credits, price, null, null);
    }

    public ApiResponse<CreditPackDetail> create(String name, int credits, long price,
                                                String description, Boolean isActive) {
        return http.post("/credit-packs/manage", buildBody(
                "name", name,
                "credits", credits,
                "price", price,
                "description", description,
                "is_active", isActive
        ), new TypeReference<>() {});
    }

    public ApiResponse<CreditPackDetail> update(String id, String name, String description,
                                                Integer credits, Long price, Boolean isActive) {
        return http.put("/credit-packs/" + id, buildBody(
                "name", name,
                "description", description,
                "credits", credits,
                "price", price,
                "is_active", isActive
        ), new TypeReference<>() {});
    }

    public ApiResponse<DeleteResult> delete(String id) {
        return http.delete("/credit-packs/" + id, null, new TypeReference<>() {});
    }
}
