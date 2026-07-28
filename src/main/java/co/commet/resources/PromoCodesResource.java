package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.PromoCode;
import co.commet.models.PromoCodesListResult;
import co.commet.params.CreatePromoCodeParams;
import co.commet.params.ListPromoCodesParams;
import co.commet.params.UpdatePromoCodeParams;
import com.fasterxml.jackson.core.type.TypeReference;

import static co.commet.CommetHttpClient.buildBody;

public class PromoCodesResource {

    private final CommetHttpClient http;

    public PromoCodesResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Retrieve a promo code by its public ID.
     */
    public PromoCode get(String id) {
        return http.get("/promo-codes/" + id, new TypeReference<PromoCode>() {}).getData();
    }

    /**
     * Update a promo code's billing interval, redemption limits, expiration, active status, or plan restrictions.
     */
    public PromoCode update(String id, UpdatePromoCodeParams params) {
        return http.patch("/promo-codes/" + id, buildBody(
                "billing_interval", params.getBillingInterval(),
                "max_redemptions", params.getMaxRedemptions(),
                "expires_at", params.getExpiresAt(),
                "active", params.getActive(),
                "plan_ids", params.getPlanIds()
        ), params.getIdempotencyKey(), new TypeReference<PromoCode>() {}).getData();
    }

    /**
     * List promo codes with cursor-based pagination.
     */
    public PromoCodesListResult list(ListPromoCodesParams params) {
        return http.get("/promo-codes", buildBody(
                "cursor", params.getCursor(),
                "limit", params.getLimit()
        ), new TypeReference<PromoCodesListResult>() {}).getData();
    }

    /**
     * Create a distribution code for an existing promotional offer. Offer economics remain owned by the referenced Offer.
     */
    public PromoCode create(CreatePromoCodeParams params) {
        return http.post("/promo-codes", buildBody(
                "code", params.getCode(),
                "offer_id", params.getOfferId(),
                "billing_interval", params.getBillingInterval(),
                "max_redemptions", params.getMaxRedemptions(),
                "expires_at", params.getExpiresAt(),
                "plan_ids", params.getPlanIds()
        ), params.getIdempotencyKey(), new TypeReference<PromoCode>() {}).getData();
    }
}
