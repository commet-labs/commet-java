package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.PortalSession;
import com.fasterxml.jackson.core.type.TypeReference;

import static co.commet.CommetHttpClient.buildBody;

public class PortalResource {

    private final CommetHttpClient http;

    public PortalResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<PortalSession> getUrl() {
        return getUrl(null, null, null);
    }

    public ApiResponse<PortalSession> getUrl(String customerId, String email,
                              String idempotencyKey) {
        return http.post("/portal/request-access", buildBody(
                "customer_id", customerId,
                "email", email
        ), idempotencyKey, new TypeReference<>() {});
    }
}
