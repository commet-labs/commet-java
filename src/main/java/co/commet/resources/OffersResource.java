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
     * Retrieve reusable offer terms by public ID.
     */
    public Offer get(String id) {
        return http.get("/offers/" + id, new TypeReference<Offer>() {}).getData();
    }

    /**
     * Replace reusable offer terms. Existing applications keep their immutable accepted terms.
     */
    public Offer update(String id, UpdateOfferParams params) {
        return http.patch("/offers/" + id, buildBody(
                "name", params.getName(),
                "phases", params.getPhases(),
                "metadata", params.getMetadata(),
                "starts_at", params.getStartsAt(),
                "ends_at", params.getEndsAt(),
                "active", params.getActive()
        ), params.getIdempotencyKey(), new TypeReference<Offer>() {}).getData();
    }

    /**
     * Soft-delete an Offer. Existing applications and their accepted terms remain available for billing and audit.
     */
    public DeletedOffer delete(String id) {
        return http.delete("/offers/" + id, null, new TypeReference<DeletedOffer>() {}).getData();
    }

    /**
     * List reusable offer terms. Offers are independent from plans, prices, eligibility, and distribution channels.
     */
    public OffersListResult list(ListOffersParams params) {
        return http.get("/offers", buildBody(
                "cursor", params.getCursor(),
                "limit", params.getLimit(),
                "active", params.getActive()
        ), new TypeReference<OffersListResult>() {}).getData();
    }

    /**
     * Create reusable offer terms without assigning a plan, price, eligibility rule, or distribution channel.
     */
    public Offer create(CreateOfferParams params) {
        return http.post("/offers", buildBody(
                "name", params.getName(),
                "phases", params.getPhases(),
                "metadata", params.getMetadata(),
                "starts_at", params.getStartsAt(),
                "ends_at", params.getEndsAt(),
                "active", params.getActive()
        ), params.getIdempotencyKey(), new TypeReference<Offer>() {}).getData();
    }
}
