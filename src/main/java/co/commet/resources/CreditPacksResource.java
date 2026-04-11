package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.CreditPack;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class CreditPacksResource {

    private final CommetHttpClient http;

    public CreditPacksResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<List<CreditPack>> list() {
        return http.get("/credit-packs", new TypeReference<>() {});
    }
}
