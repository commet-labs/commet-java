package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;

import static co.commet.CommetHttpClient.buildBody;

public class PlansResource {

    private final CommetHttpClient http;

    public PlansResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse list() {
        return list(null, null, null);
    }

    public ApiResponse list(Boolean includePrivate, Integer limit, String cursor) {
        return http.get("/plans", buildBody(
                "include_private", includePrivate,
                "limit", limit,
                "cursor", cursor
        ));
    }

    public ApiResponse get(String planCode) {
        return http.get("/plans/" + planCode);
    }
}
