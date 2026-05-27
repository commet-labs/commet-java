package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.ApiKey;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class ApiKeysResource {

    private final CommetHttpClient http;

    public ApiKeysResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<List<ApiKey>> list() {
        return list(null, null);
    }

    public ApiResponse<List<ApiKey>> list(Integer limit, String cursor) {
        return http.get("/api-keys", buildBody(
                "limit", limit,
                "cursor", cursor
        ), new TypeReference<>() {});
    }

    public ApiResponse<ApiKey> create(String name) {
        return create(name, null);
    }

    public ApiResponse<ApiKey> create(String name, Integer expiresInDays) {
        return http.post("/api-keys", buildBody(
                "name", name,
                "expires_in_days", expiresInDays
        ), new TypeReference<>() {});
    }

    public ApiResponse<Void> delete(String id) {
        return http.delete("/api-keys/" + id, null, new TypeReference<>() {});
    }
}
