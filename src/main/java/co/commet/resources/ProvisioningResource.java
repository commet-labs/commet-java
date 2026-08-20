package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.ClaimLink;
import co.commet.params.CreateClaimLinkParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class ProvisioningResource {

    private final CommetHttpClient http;

    public ProvisioningResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Issue a fresh claim link for an organization that was provisioned headlessly and has not been claimed yet. Any previously issued link stops working.
     */
    public ClaimLink createClaimLink(CreateClaimLinkParams params) {
        return http.post("/claim-link", null, params.getIdempotencyKey(), new TypeReference<ClaimLink>() {}).getData();
    }
}
