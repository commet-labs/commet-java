package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.ActivateAddonResult;
import co.commet.models.AdjustBalanceResult;
import co.commet.models.ChangePlanResult;
import co.commet.models.DeactivateAddonResult;
import co.commet.models.PreviewChangeResult;
import co.commet.models.PurchaseCreditsResult;
import co.commet.models.Subscription;
import co.commet.models.SubscriptionListItem;
import co.commet.models.TopupBalanceResult;
import co.commet.params.CancelSubscriptionParams;
import co.commet.params.ChangePlanParams;
import co.commet.params.CreateSubscriptionParams;
import co.commet.params.CustomIntroOffer;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class SubscriptionsResource {

    private final CommetHttpClient http;

    public SubscriptionsResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<Subscription> create(String customerId, String planCode) {
        return create(CreateSubscriptionParams.builder(customerId, planCode).build());
    }

    public ApiResponse<Subscription> create(CreateSubscriptionParams params) {
        Map<String, Object> body = buildBody(
                "customer_id", params.getCustomerId(),
                "plan_code", params.getPlanCode(),
                "plan_id", params.getPlanId(),
                "billing_interval", params.getBillingInterval(),
                "initial_seats", params.getInitialSeats(),
                "skip_trial", params.getSkipTrial(),
                "name", params.getName(),
                "start_date", params.getStartDate(),
                "success_url", params.getSuccessUrl()
        );
        CustomIntroOffer offer = params.getCustomIntroOffer();
        if (offer != null) {
            body.put("custom_intro_offer", buildBody(
                    "discount_type", offer.getDiscountType(),
                    "discount_value", offer.getDiscountValue(),
                    "duration_cycles", offer.getDurationCycles()
            ));
        }
        return http.post("/subscriptions", body, params.getIdempotencyKey(), new TypeReference<>() {});
    }

    public ApiResponse<Subscription> getActive(String customerId) {
        return http.get("/subscriptions/active", Map.of("customer_id", customerId),
                new TypeReference<>() {});
    }

    public ApiResponse<Subscription> cancel(String subscriptionId) {
        return cancel(CancelSubscriptionParams.builder(subscriptionId).build());
    }

    public ApiResponse<Subscription> cancel(CancelSubscriptionParams params) {
        return http.post("/subscriptions/" + params.getSubscriptionId() + "/cancel", buildBody(
                "reason", params.getReason(),
                "immediate", params.getImmediate()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    public ApiResponse<Subscription> uncancel(String subscriptionId) {
        return http.post("/subscriptions/" + subscriptionId + "/uncancel",
                Map.of(), new TypeReference<>() {});
    }

    public ApiResponse<ChangePlanResult> changePlan(String subscriptionId, String newPlanId) {
        return changePlan(ChangePlanParams.builder(subscriptionId, newPlanId).build());
    }

    public ApiResponse<ChangePlanResult> changePlan(ChangePlanParams params) {
        return http.post("/subscriptions/" + params.getSubscriptionId() + "/change-plan", buildBody(
                "new_plan_id", params.getNewPlanId(),
                "new_billing_interval", params.getNewBillingInterval(),
                "success_url", params.getSuccessUrl()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    public ApiResponse<List<SubscriptionListItem>> list() {
        return list(null, null, null, null);
    }

    public ApiResponse<List<SubscriptionListItem>> list(String customerId, String status,
                                                        Integer limit, String cursor) {
        return http.get("/subscriptions", buildBody(
                "customer_id", customerId,
                "status", status,
                "limit", limit,
                "cursor", cursor
        ), new TypeReference<>() {});
    }

    public ApiResponse<PreviewChangeResult> previewChange(String subscriptionId, String planId,
                                                          String billingInterval) {
        return http.post("/subscriptions/" + subscriptionId + "/preview-change", buildBody(
                "plan_id", planId,
                "billing_interval", billingInterval
        ), new TypeReference<>() {});
    }

    public ApiResponse<ActivateAddonResult> activateAddon(String subscriptionId, String addonId) {
        return http.post("/subscriptions/" + subscriptionId + "/addons", buildBody(
                "addon_id", addonId
        ), new TypeReference<>() {});
    }

    public ApiResponse<DeactivateAddonResult> deactivateAddon(String subscriptionId, String addonId) {
        return http.delete("/subscriptions/" + subscriptionId + "/addons/" + addonId,
                null, new TypeReference<>() {});
    }

    public ApiResponse<AdjustBalanceResult> adjustBalance(String subscriptionId, long amount) {
        return adjustBalance(subscriptionId, amount, null, null);
    }

    public ApiResponse<AdjustBalanceResult> adjustBalance(String subscriptionId, long amount,
                                                          String reason, String type) {
        return http.post("/subscriptions/" + subscriptionId + "/balance/adjust", buildBody(
                "amount", amount,
                "reason", reason,
                "type", type
        ), new TypeReference<>() {});
    }

    public ApiResponse<TopupBalanceResult> topupBalance(String subscriptionId, long amount) {
        return http.post("/subscriptions/" + subscriptionId + "/balance/topup", buildBody(
                "amount", amount
        ), new TypeReference<>() {});
    }

    public ApiResponse<PurchaseCreditsResult> purchaseCredits(String subscriptionId, String creditPackId) {
        return http.post("/subscriptions/" + subscriptionId + "/credits", buildBody(
                "credit_pack_id", creditPackId
        ), new TypeReference<>() {});
    }
}
