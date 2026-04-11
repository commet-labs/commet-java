package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Plan;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

import static co.commet.CommetHttpClient.buildBody;

public class PlansResource {

    private final CommetHttpClient http;

    public PlansResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<List<Plan>> list() {
        return list(null, null, null);
    }

    public ApiResponse<List<Plan>> list(Boolean includePrivate, Integer limit, String cursor) {
        return http.get("/plans", buildBody(
                "include_private", includePrivate,
                "limit", limit,
                "cursor", cursor
        ), new TypeReference<>() {});
    }

    public ApiResponse<Plan> get(String planCode) {
        return http.get("/plans/" + planCode, new TypeReference<>() {});
    }
}
