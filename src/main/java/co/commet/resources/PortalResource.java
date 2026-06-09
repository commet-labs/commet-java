package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.PortalAccess;
import co.commet.params.RequestPortalAccessParams;
import com.fasterxml.jackson.core.type.TypeReference;

import static co.commet.CommetHttpClient.buildBody;

public class PortalResource {

    private final CommetHttpClient http;

    public PortalResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Generate a customer portal URL. Exactly one identifier (email or customerId) is required.
     */
    public ApiResponse<PortalAccess> getUrl(RequestPortalAccessParams params) {
        return http.post("/portal/request-access", buildBody(
                "email", params.getEmail(),
                "customer_id", params.getCustomerId()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }
}
