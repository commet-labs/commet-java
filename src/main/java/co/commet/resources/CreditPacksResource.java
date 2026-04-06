package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;

public class CreditPacksResource {

    private final CommetHttpClient http;

    public CreditPacksResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse list() {
        return http.get("/credit-packs");
    }
}
