package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.DeletedOffer;
import co.commet.models.Offer;
import co.commet.models.OffersListResult;
import co.commet.params.CreateOfferParams;
import co.commet.params.ListOffersParams;
import co.commet.params.UpdateOfferParams;
import com.fasterxml.jackson.core.type.TypeReference;

import static co.commet.CommetHttpClient.buildBody;

public class OffersResource {

    private final CommetHttpClient http;

    public OffersResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Retrieve a canonical offer by its public ID.
     */
    public Offer get(String id) {
        return http.get("/offers/" + id, new TypeReference<Offer>() {}).getData();
    }

    /**
     * Replace an offer's catalog definition. Existing offer applications keep their immutable accepted terms.
     */
    public Offer update(String id, UpdateOfferParams params) {
        return http.patch("/offers/" + id, buildBody(
                "name", params.getName(),
                "purpose", params.getPurpose(),
                "plan_price_ids", params.getPlanPriceIds(),
                "phases", params.getPhases(),
                "metadata", params.getMetadata(),
                "starts_at", params.getStartsAt(),
                "ends_at", params.getEndsAt(),
                "active", params.getActive()
        ), params.getIdempotencyKey(), new TypeReference<Offer>() {}).getData();
    }

    /**
     * Soft-delete an offer. Existing applications and their accepted terms remain available for billing and audit.
     */
    public DeletedOffer delete(String id) {
        return http.delete("/offers/" + id, null, new TypeReference<DeletedOffer>() {}).getData();
    }

    /**
     * List the organization's canonical introductory and promotional offers.
     */
    public OffersListResult list(ListOffersParams params) {
        return http.get("/offers", buildBody(
                "cursor", params.getCursor(),
                "limit", params.getLimit(),
                "plan_price_id", params.getPlanPriceId(),
                "purpose", params.getPurpose(),
                "active", params.getActive()
        ), new TypeReference<OffersListResult>() {}).getData();
    }

    /**
     * Create a canonical offer scoped to one or more plan prices. Currency-specific phases require an explicit USD value and never fall back across currencies.
     */
    public Offer create(CreateOfferParams params) {
        return http.post("/offers", buildBody(
                "name", params.getName(),
                "purpose", params.getPurpose(),
                "plan_price_ids", params.getPlanPriceIds(),
                "phases", params.getPhases(),
                "metadata", params.getMetadata(),
                "starts_at", params.getStartsAt(),
                "ends_at", params.getEndsAt(),
                "active", params.getActive()
        ), params.getIdempotencyKey(), new TypeReference<Offer>() {}).getData();
    }
}
