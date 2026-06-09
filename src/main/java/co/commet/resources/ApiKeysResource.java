package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.ApiKey;
import co.commet.models.CreatedApiKey;
import co.commet.models.DeletedObject;
import co.commet.params.CreateApiKeyParams;
import co.commet.params.ListApiKeysParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

import static co.commet.CommetHttpClient.buildBody;

public class ApiKeysResource {

    private final CommetHttpClient http;

    public ApiKeysResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * List API keys with cursor-based pagination. Keys are returned without the full secret.
     */
    public ApiResponse<List<ApiKey>> list(ListApiKeysParams params) {
        return http.get("/api-keys", buildBody(
                "cursor", params.getCursor(),
                "limit", params.getLimit()
        ), new TypeReference<>() {});
    }

    /**
     * Create a new API key. The full key is only returned once in the response.
     */
    public ApiResponse<CreatedApiKey> create(CreateApiKeyParams params) {
        return http.post("/api-keys", buildBody(
                "name", params.getName(),
                "expires_in_days", params.getExpiresInDays()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Permanently revoke and delete an API key.
     */
    public ApiResponse<DeletedObject> delete(String id) {
        return http.delete("/api-keys/" + id, null, new TypeReference<>() {});
    }
}
