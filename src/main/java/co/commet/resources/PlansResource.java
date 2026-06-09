package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.DefaultPlanPrice;
import co.commet.models.DeletedObject;
import co.commet.models.DeletedPlanRegionalPricing;
import co.commet.models.Plan;
import co.commet.models.PlanFeature;
import co.commet.models.PlanPrice;
import co.commet.models.PlanRegionalPricing;
import co.commet.models.PlanRegionalPricingResult;
import co.commet.models.PlanVisibility;
import co.commet.models.RemovedPlanFeature;
import co.commet.params.AddPlanFeatureParams;
import co.commet.params.AddPlanPriceParams;
import co.commet.params.CreatePlanParams;
import co.commet.params.ListPlansParams;
import co.commet.params.SetDefaultPlanPriceParams;
import co.commet.params.SetPlanRegionalPricingParams;
import co.commet.params.SetPlanVisibilityParams;
import co.commet.params.UpdatePlanFeatureParams;
import co.commet.params.UpdatePlanParams;
import co.commet.params.UpdatePlanPriceParams;
import co.commet.params.UpsertRegionalPricesParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class PlansResource {

    private final CommetHttpClient http;

    public PlansResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * List all plans with their prices and features. Optionally include private plans.
     */
    public ApiResponse<List<Plan>> list(ListPlansParams params) {
        return http.get("/plans", buildBody(
                "include_private", params.getIncludePrivate()
        ), new TypeReference<>() {});
    }

    /**
     * Get detailed plan information by code or ID.
     */
    public ApiResponse<Plan> get(String id) {
        return http.get("/plans/" + id, new TypeReference<>() {});
    }

    /**
     * Create a new plan with optional consumption model, visibility, and plan group assignment.
     */
    public ApiResponse<Plan> create(CreatePlanParams params) {
        return http.post("/plans/manage", buildBody(
                "name", params.getName(),
                "code", params.getCode(),
                "description", params.getDescription(),
                "consumption_model", params.getConsumptionModel(),
                "is_public", params.getIsPublic(),
                "is_free", params.getIsFree(),
                "block_on_exhaustion", params.getBlockOnExhaustion(),
                "plan_group_id", params.getPlanGroupId(),
                "metadata", params.getMetadata()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Update a plan's name, description, visibility, or metadata.
     */
    public ApiResponse<Plan> update(String id, UpdatePlanParams params) {
        return http.put("/plans/" + id + "/manage", buildBody(
                "name", params.getName(),
                "description", params.getDescription(),
                "metadata", params.getMetadata(),
                "is_public", params.getIsPublic()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Soft-delete a plan.
     */
    public ApiResponse<DeletedObject> delete(String id) {
        return http.delete("/plans/" + id + "/manage", null, new TypeReference<>() {});
    }

    /**
     * Toggle a plan between public and private.
     */
    public ApiResponse<PlanVisibility> setVisibility(String id, SetPlanVisibilityParams params) {
        return http.put("/plans/" + id + "/visibility", buildBody(
                "is_public", params.isIsPublic()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Attach a feature to a plan with limits, overage, and credits configuration.
     */
    public ApiResponse<PlanFeature> addFeature(String id, AddPlanFeatureParams params) {
        return http.post("/plans/" + id + "/features", buildBody(
                "feature_id", params.getFeatureId(),
                "enabled", params.getEnabled(),
                "included_amount", params.getIncludedAmount(),
                "unlimited", params.getUnlimited(),
                "overage", params.getOverage(),
                "credits_per_unit", params.getCreditsPerUnit(),
                "pricing_mode", params.getPricingMode(),
                "margin", params.getMargin()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Update limits, overage, or enabled status of a feature on a plan.
     */
    public ApiResponse<PlanFeature> updateFeature(String id, String featureId, UpdatePlanFeatureParams params) {
        return http.put("/plans/" + id + "/features/" + featureId, buildBody(
                "enabled", params.getEnabled(),
                "included_amount", params.getIncludedAmount(),
                "unlimited", params.getUnlimited(),
                "overage", params.getOverage(),
                "credits_per_unit", params.getCreditsPerUnit()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Detach a feature from a plan.
     */
    public ApiResponse<RemovedPlanFeature> removeFeature(String id, String featureId) {
        return http.delete("/plans/" + id + "/features/" + featureId, null, new TypeReference<>() {});
    }

    /**
     * Add a billing interval price to a plan with optional trial days and included balance/credits.
     */
    public ApiResponse<PlanPrice> addPrice(String id, AddPlanPriceParams params) {
        return http.post("/plans/" + id + "/prices", buildBody(
                "billing_interval", params.getBillingInterval(),
                "price", params.getPrice(),
                "trial_days", params.getTrialDays(),
                "is_default", params.getIsDefault(),
                "included_balance", params.getIncludedBalance(),
                "included_credits", params.getIncludedCredits(),
                "intro_offer", params.getIntroOffer()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Update an existing price on a plan.
     */
    public ApiResponse<PlanPrice> updatePrice(String id, String priceId, UpdatePlanPriceParams params) {
        return http.put("/plans/" + id + "/prices/" + priceId, buildBody(
                "price", params.getPrice(),
                "is_default", params.getIsDefault(),
                "trial_days", params.getTrialDays(),
                "included_balance", params.getIncludedBalance(),
                "included_credits", params.getIncludedCredits(),
                "intro_offer", params.getIntroOffer()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Remove a price from a plan.
     */
    public ApiResponse<DeletedObject> deletePrice(String id, String priceId) {
        return http.delete("/plans/" + id + "/prices/" + priceId, null, new TypeReference<>() {});
    }

    /**
     * Set a specific price as the default for its plan. Unsets previous default.
     */
    public ApiResponse<DefaultPlanPrice> setDefaultPrice(String id, String priceId, SetDefaultPlanPriceParams params) {
        return http.put("/plans/" + id + "/prices/" + priceId + "/default", Map.of(), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Create or update regional currency price overrides for a plan price.
     */
    public ApiResponse<PlanRegionalPricing> setRegionalPrices(String id, String priceId, UpsertRegionalPricesParams params) {
        return http.put("/plans/" + id + "/prices/" + priceId + "/regional", buildBody(
                "overrides", params.getOverrides()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Configure a plan's regional pricing for one currency. Sending only currency and exchangeRate derives every regional value (base price, included balance, feature overage, intro offer) from the USD value at that rate. Optional per-price and per-feature overrides are stored as manual values.
     */
    public ApiResponse<PlanRegionalPricingResult> setRegionalPricing(String id, SetPlanRegionalPricingParams params) {
        return http.put("/plans/" + id + "/regional", buildBody(
                "currency", params.getCurrency(),
                "exchange_rate", params.getExchangeRate(),
                "prices", params.getPrices(),
                "features", params.getFeatures(),
                "intro_offers", params.getIntroOffers()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Remove all regional currency overrides for a plan price.
     */
    public ApiResponse<DeletedPlanRegionalPricing> deleteRegionalPrices(String id, String priceId) {
        return http.delete("/plans/" + id + "/prices/" + priceId + "/regional", null, new TypeReference<>() {});
    }
}
