package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.DeletedObject;
import co.commet.models.DeletedPlanRegionalPricing;
import co.commet.models.Plan;
import co.commet.models.PlanFeature;
import co.commet.models.PlanPrice;
import co.commet.models.PlanRegionalPricing;
import co.commet.models.PlanRegionalPricingResult;
import co.commet.models.PlansListResult;
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
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class PlansResource {

    private final CommetHttpClient http;

    public PlansResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Update limits, overage, or enabled status of a feature on a plan.
     */
    public PlanFeature updateFeature(String id, String featureId, UpdatePlanFeatureParams params) {
        return http.patch("/plans/" + id + "/features/" + featureId, buildBody(
                "enabled", params.getEnabled(),
                "included_amount", params.getIncludedAmount(),
                "unlimited", params.getUnlimited(),
                "overage", params.getOverage(),
                "credits_per_unit", params.getCreditsPerUnit()
        ), params.getIdempotencyKey(), new TypeReference<PlanFeature>() {}).getData();
    }

    /**
     * Detach a feature from a plan.
     */
    public RemovedPlanFeature removeFeature(String id, String featureId) {
        return http.delete("/plans/" + id + "/features/" + featureId, null, new TypeReference<RemovedPlanFeature>() {}).getData();
    }

    /**
     * Attach a feature to a plan with limits, overage, and credits configuration.
     */
    public PlanFeature addFeature(String id, AddPlanFeatureParams params) {
        return http.post("/plans/" + id + "/features", buildBody(
                "feature_id", params.getFeatureId(),
                "enabled", params.getEnabled(),
                "included_amount", params.getIncludedAmount(),
                "unlimited", params.getUnlimited(),
                "overage", params.getOverage(),
                "credits_per_unit", params.getCreditsPerUnit(),
                "pricing_mode", params.getPricingMode(),
                "margin", params.getMargin()
        ), params.getIdempotencyKey(), new TypeReference<PlanFeature>() {}).getData();
    }

    /**
     * Set a specific price as the default and return the updated plan price.
     */
    public PlanPrice setDefaultPrice(String id, String priceId, SetDefaultPlanPriceParams params) {
        return http.put("/plans/" + id + "/prices/" + priceId + "/default", Map.of(), params.getIdempotencyKey(), new TypeReference<PlanPrice>() {}).getData();
    }

    /**
     * Create or update regional currency price overrides for a plan price.
     */
    public PlanRegionalPricing setRegionalPrices(String id, String priceId, UpsertRegionalPricesParams params) {
        return http.put("/plans/" + id + "/prices/" + priceId + "/regional", buildBody(
                "overrides", params.getOverrides()
        ), params.getIdempotencyKey(), new TypeReference<PlanRegionalPricing>() {}).getData();
    }

    /**
     * Remove all regional currency overrides for a plan price. The request is rejected while billable subscriptions depend on an override.
     */
    public DeletedPlanRegionalPricing deleteRegionalPrices(String id, String priceId) {
        return http.delete("/plans/" + id + "/prices/" + priceId + "/regional", null, new TypeReference<DeletedPlanRegionalPricing>() {}).getData();
    }

    /**
     * Update a base price or market price variant. Removing a base market override is rejected while a variant depends on it. Offer terms are managed through Offers.
     */
    public PlanPrice updatePrice(String id, String priceId, UpdatePlanPriceParams params) {
        return http.patch("/plans/" + id + "/prices/" + priceId, buildBody(
                "price", params.getPrice(),
                "is_default", params.getIsDefault(),
                "trial_days", params.getTrialDays(),
                "included_balance", params.getIncludedBalance(),
                "included_credits", params.getIncludedCredits(),
                "metadata", params.getMetadata(),
                "market_prices", params.getMarketPrices()
        ), params.getIdempotencyKey(), new TypeReference<PlanPrice>() {}).getData();
    }

    /**
     * Archive a price for new subscriptions. Existing subscriptions that selected it continue using its current catalog value.
     */
    public DeletedObject deletePrice(String id, String priceId) {
        return http.delete("/plans/" + id + "/prices/" + priceId, null, new TypeReference<DeletedObject>() {}).getData();
    }

    /**
     * Add a base price or a selectable market price variant. Variants inherit their base price outside the markets they override. Configure introductory and promotional benefits through Offers.
     */
    public PlanPrice addPrice(String id, AddPlanPriceParams params) {
        return http.post("/plans/" + id + "/prices", buildBody(
                "billing_interval", params.getBillingInterval(),
                "metadata", params.getMetadata(),
                "price", params.getPrice(),
                "trial_days", params.getTrialDays(),
                "is_default", params.getIsDefault(),
                "included_balance", params.getIncludedBalance(),
                "included_credits", params.getIncludedCredits(),
                "market_prices", params.getMarketPrices(),
                "inherits_from_price_id", params.getInheritsFromPriceId()
        ), params.getIdempotencyKey(), new TypeReference<PlanPrice>() {}).getData();
    }

    /**
     * Configure regional prices and feature overage values for one currency. Currency-specific offer terms are managed through Offers.
     */
    public PlanRegionalPricingResult setRegionalPricing(String id, SetPlanRegionalPricingParams params) {
        return http.put("/plans/" + id + "/regional", buildBody(
                "currency", params.getCurrency(),
                "exchange_rate", params.getExchangeRate(),
                "prices", params.getPrices(),
                "features", params.getFeatures()
        ), params.getIdempotencyKey(), new TypeReference<PlanRegionalPricingResult>() {}).getData();
    }

    /**
     * Get a plan with public price IDs and their automatic introductory offer IDs.
     */
    public Plan get(String id) {
        return http.get("/plans/" + id, new TypeReference<Plan>() {}).getData();
    }

    /**
     * Update a plan's name, description, visibility, or metadata.
     */
    public Plan update(String id, UpdatePlanParams params) {
        return http.patch("/plans/" + id, buildBody(
                "name", params.getName(),
                "description", params.getDescription(),
                "metadata", params.getMetadata(),
                "is_public", params.getIsPublic()
        ), params.getIdempotencyKey(), new TypeReference<Plan>() {}).getData();
    }

    /**
     * Soft-delete a plan.
     */
    public DeletedObject delete(String id) {
        return http.delete("/plans/" + id, null, new TypeReference<DeletedObject>() {}).getData();
    }

    /**
     * Set a plan's public visibility and return the updated plan.
     */
    public Plan setVisibility(String id, SetPlanVisibilityParams params) {
        return http.put("/plans/" + id + "/visibility", buildBody(
                "is_public", params.isIsPublic()
        ), params.getIdempotencyKey(), new TypeReference<Plan>() {}).getData();
    }

    /**
     * List plans with public price IDs and their automatic introductory offer IDs.
     */
    public PlansListResult list(ListPlansParams params) {
        return http.get("/plans", buildBody(
                "include_private", params.getIncludePrivate()
        ), new TypeReference<PlansListResult>() {}).getData();
    }

    /**
     * Create a new plan with optional consumption model, visibility, and plan group assignment.
     */
    public Plan create(CreatePlanParams params) {
        return http.post("/plans", buildBody(
                "name", params.getName(),
                "code", params.getCode(),
                "description", params.getDescription(),
                "consumption_model", params.getConsumptionModel(),
                "is_public", params.getIsPublic(),
                "is_free", params.getIsFree(),
                "block_on_exhaustion", params.getBlockOnExhaustion(),
                "plan_group_id", params.getPlanGroupId(),
                "metadata", params.getMetadata()
        ), params.getIdempotencyKey(), new TypeReference<Plan>() {}).getData();
    }
}
