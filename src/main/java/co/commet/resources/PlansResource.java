package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.DeleteResult;
import co.commet.models.Plan;
import co.commet.models.PlanFeatureManage;
import co.commet.models.PlanManage;
import co.commet.models.PlanPriceManage;
import co.commet.models.RegionalPriceResult;
import co.commet.models.RemoveResult;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class PlansResource {

    private final CommetHttpClient http;

    public PlansResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<List<Plan>> list() {
        return list(null, null, null);
    }

    public ApiResponse<List<Plan>> list(Boolean includePrivate, Integer limit, String cursor) {
        return http.get("/plans", buildBody(
                "include_private", includePrivate,
                "limit", limit,
                "cursor", cursor
        ), new TypeReference<>() {});
    }

    public ApiResponse<Plan> get(String planId) {
        return http.get("/plans/" + planId, new TypeReference<>() {});
    }

    public ApiResponse<PlanManage> create(String name, String code) {
        return create(name, code, null, null, null, null, null, null, null);
    }

    public ApiResponse<PlanManage> create(String name, String code, String description,
                                          String consumptionModel, Boolean isPublic, Boolean isFree,
                                          Boolean blockOnExhaustion, String planGroupId,
                                          Map<String, Object> metadata) {
        return http.post("/plans/manage", buildBody(
                "name", name,
                "code", code,
                "description", description,
                "consumption_model", consumptionModel,
                "is_public", isPublic,
                "is_free", isFree,
                "block_on_exhaustion", blockOnExhaustion,
                "plan_group_id", planGroupId,
                "metadata", metadata
        ), new TypeReference<>() {});
    }

    public ApiResponse<PlanManage> update(String id, String name, String description,
                                          Map<String, Object> metadata, Boolean isPublic) {
        return http.put("/plans/" + id + "/manage", buildBody(
                "name", name,
                "description", description,
                "metadata", metadata,
                "is_public", isPublic
        ), new TypeReference<>() {});
    }

    public ApiResponse<DeleteResult> delete(String id) {
        return http.delete("/plans/" + id + "/manage", null, new TypeReference<>() {});
    }

    public ApiResponse<PlanManage> setVisibility(String id, boolean isPublic) {
        return http.put("/plans/" + id + "/visibility", buildBody(
                "is_public", isPublic
        ), new TypeReference<>() {});
    }

    public ApiResponse<PlanFeatureManage> addFeature(String planId, String featureId) {
        return addFeature(planId, featureId, null, null, null, null, null, null, null);
    }

    public ApiResponse<PlanFeatureManage> addFeature(String planId, String featureId,
                                                     Boolean enabled, Integer includedAmount,
                                                     Boolean unlimited, Boolean overageEnabled,
                                                     Integer creditsPerUnit, String pricingMode,
                                                     Object pricingValue) {
        Map<String, Object> body = buildBody(
                "feature_id", featureId,
                "enabled", enabled,
                "included_amount", includedAmount,
                "unlimited", unlimited,
                "overage_enabled", overageEnabled,
                "credits_per_unit", creditsPerUnit,
                "pricing_mode", pricingMode
        );
        if ("ai_model".equals(pricingMode) && pricingValue != null) {
            body.put("margin", pricingValue);
        } else if (pricingValue != null) {
            body.put("overage_unit_price", pricingValue);
        }
        return http.post("/plans/" + planId + "/features", body, new TypeReference<>() {});
    }

    public ApiResponse<PlanFeatureManage> updateFeature(String planId, String featureId,
                                                        Boolean enabled, Integer includedAmount,
                                                        Boolean unlimited, Boolean overageEnabled,
                                                        Integer creditsPerUnit, String pricingMode,
                                                        Object pricingValue) {
        Map<String, Object> body = buildBody(
                "enabled", enabled,
                "included_amount", includedAmount,
                "unlimited", unlimited,
                "overage_enabled", overageEnabled,
                "credits_per_unit", creditsPerUnit,
                "pricing_mode", pricingMode
        );
        if ("ai_model".equals(pricingMode) && pricingValue != null) {
            body.put("margin", pricingValue);
        } else if (pricingValue != null) {
            body.put("overage_unit_price", pricingValue);
        }
        return http.put("/plans/" + planId + "/features/" + featureId, body, new TypeReference<>() {});
    }

    public ApiResponse<RemoveResult> removeFeature(String planId, String featureId) {
        return http.delete("/plans/" + planId + "/features/" + featureId, null,
                new TypeReference<>() {});
    }

    public ApiResponse<PlanPriceManage> addPrice(String planId, String billingInterval, long price) {
        return addPrice(planId, billingInterval, price, null, null, null, null, null, null, null, null);
    }

    public ApiResponse<PlanPriceManage> addPrice(String planId, String billingInterval, long price,
                                                 Integer trialDays, Boolean isDefault,
                                                 Long includedBalance, Long includedCredits,
                                                 Boolean introOfferEnabled, String introOfferDiscountType,
                                                 Long introOfferDiscountValue,
                                                 Integer introOfferDurationCycles) {
        return http.post("/plans/" + planId + "/prices", buildBody(
                "billing_interval", billingInterval,
                "price", price,
                "trial_days", trialDays,
                "is_default", isDefault,
                "included_balance", includedBalance,
                "included_credits", includedCredits,
                "intro_offer_enabled", introOfferEnabled,
                "intro_offer_discount_type", introOfferDiscountType,
                "intro_offer_discount_value", introOfferDiscountValue,
                "intro_offer_duration_cycles", introOfferDurationCycles
        ), new TypeReference<>() {});
    }

    public ApiResponse<PlanPriceManage> updatePrice(String planId, String priceId, Long price,
                                                    Boolean isDefault, Integer trialDays,
                                                    Long includedBalance, Long includedCredits,
                                                    Boolean introOfferEnabled,
                                                    String introOfferDiscountType,
                                                    Long introOfferDiscountValue,
                                                    Integer introOfferDurationCycles) {
        return http.put("/plans/" + planId + "/prices/" + priceId, buildBody(
                "price", price,
                "is_default", isDefault,
                "trial_days", trialDays,
                "included_balance", includedBalance,
                "included_credits", includedCredits,
                "intro_offer_enabled", introOfferEnabled,
                "intro_offer_discount_type", introOfferDiscountType,
                "intro_offer_discount_value", introOfferDiscountValue,
                "intro_offer_duration_cycles", introOfferDurationCycles
        ), new TypeReference<>() {});
    }

    public ApiResponse<DeleteResult> deletePrice(String planId, String priceId) {
        return http.delete("/plans/" + planId + "/prices/" + priceId, null,
                new TypeReference<>() {});
    }

    public ApiResponse<PlanPriceManage> setDefaultPrice(String planId, String priceId) {
        return http.put("/plans/" + planId + "/prices/" + priceId + "/default",
                Map.of(), new TypeReference<>() {});
    }

    public ApiResponse<RegionalPriceResult> setRegionalPrices(String planId, String priceId,
                                                              List<Map<String, Object>> overrides) {
        return http.put("/plans/" + planId + "/prices/" + priceId + "/regional", buildBody(
                "overrides", overrides
        ), new TypeReference<>() {});
    }

    public ApiResponse<DeleteResult> deleteRegionalPrices(String planId, String priceId) {
        return http.delete("/plans/" + planId + "/prices/" + priceId + "/regional",
                null, new TypeReference<>() {});
    }
}
