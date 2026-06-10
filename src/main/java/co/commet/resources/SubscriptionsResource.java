package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.BalanceAdjustment;
import co.commet.models.BalanceTopup;
import co.commet.models.CanceledSubscription;
import co.commet.models.CreditGrant;
import co.commet.models.DeletedSubscriptionAddon;
import co.commet.models.PlanChange;
import co.commet.models.PreviewChange;
import co.commet.models.Subscription;
import co.commet.models.SubscriptionAddon;
import co.commet.models.UncanceledSubscription;
import co.commet.params.ActivateAddonParams;
import co.commet.params.AdjustBalanceParams;
import co.commet.params.CancelSubscriptionParams;
import co.commet.params.ChangePlanParams;
import co.commet.params.CreateSubscriptionParams;
import co.commet.params.GetActiveSubscriptionParams;
import co.commet.params.ListSubscriptionsParams;
import co.commet.params.PreviewChangePlanParams;
import co.commet.params.PurchaseCreditsParams;
import co.commet.params.TopupBalanceParams;
import co.commet.params.UncancelSubscriptionParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class SubscriptionsResource {

    private final CommetHttpClient http;

    public SubscriptionsResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * List all subscriptions. Filter by customer ID or status.
     */
    public ApiResponse<List<Subscription>> list(ListSubscriptionsParams params) {
        return http.get("/subscriptions", buildBody(
                "customer_id", params.getCustomerId(),
                "status", params.getStatus()
        ), new TypeReference<>() {});
    }

    /**
     * Create a subscription for a customer. Requires planId or planCode plus customerId.
     */
    public ApiResponse<Subscription> create(CreateSubscriptionParams params) {
        return http.post("/subscriptions", buildBody(
                "plan_id", params.getPlanId(),
                "plan_code", params.getPlanCode(),
                "customer_id", params.getCustomerId(),
                "billing_interval", params.getBillingInterval(),
                "initial_seats", params.getInitialSeats(),
                "skip_trial", params.getSkipTrial(),
                "intro_offer", params.getIntroOffer(),
                "name", params.getName(),
                "start_date", params.getStartDate(),
                "success_url", params.getSuccessUrl()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Get a subscription by its public ID, regardless of status (including pending_payment and past_due).
     */
    public ApiResponse<Subscription> get(String id) {
        return http.get("/subscriptions/" + id, new TypeReference<>() {});
    }

    /**
     * Get the active subscription for a customer. Returns null if none.
     */
    public ApiResponse<Subscription> getActive(GetActiveSubscriptionParams params) {
        return http.get("/subscriptions/active", buildBody(
                "customer_id", params.getCustomerId()
        ), new TypeReference<>() {});
    }

    /**
     * Cancel immediately or at period end.
     */
    public ApiResponse<CanceledSubscription> cancel(String id, CancelSubscriptionParams params) {
        return http.post("/subscriptions/" + id + "/cancel", buildBody(
                "reason", params.getReason(),
                "immediate", params.getImmediate()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Revert a scheduled cancellation. Only works when canceledAt is set but status is not yet 'canceled'.
     */
    public ApiResponse<UncanceledSubscription> uncancel(String id, UncancelSubscriptionParams params) {
        return http.post("/subscriptions/" + id + "/uncancel", Map.of(), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Upgrade, downgrade, or change billing interval.
     */
    public ApiResponse<PlanChange> changePlan(String id, ChangePlanParams params) {
        return http.post("/subscriptions/" + id + "/change-plan", buildBody(
                "new_plan_id", params.getNewPlanId(),
                "new_billing_interval", params.getNewBillingInterval(),
                "success_url", params.getSuccessUrl()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Preview proration details for an immediate plan change (an upgrade or a longer interval) without applying it. Returns credit, charge, and net amount. Downgrades — a cheaper plan in the same group, or a shorter interval — are scheduled for the end of the current period instead of being prorated, so they return a 400 with code `plan_change_scheduled`; apply those via the change-plan endpoint.
     */
    public ApiResponse<PreviewChange> previewChange(String id, PreviewChangePlanParams params) {
        return http.post("/subscriptions/" + id + "/preview-change", buildBody(
                "plan_id", params.getPlanId(),
                "billing_interval", params.getBillingInterval()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Activate an add-on on a subscription. Charges a prorated amount for the current billing period.
     */
    public ApiResponse<SubscriptionAddon> activateAddon(String id, ActivateAddonParams params) {
        return http.post("/subscriptions/" + id + "/addons", buildBody(
                "addon_id", params.getAddonId()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Deactivate an add-on from a subscription.
     */
    public ApiResponse<DeletedSubscriptionAddon> deactivateAddon(String id, String addonId) {
        return http.delete("/subscriptions/" + id + "/addons/" + addonId, null, new TypeReference<>() {});
    }

    /**
     * Adjust a subscription's balance or credits by a signed amount. Positive adds, negative subtracts.
     */
    public ApiResponse<BalanceAdjustment> adjustBalance(String id, AdjustBalanceParams params) {
        return http.post("/subscriptions/" + id + "/balance/adjust", buildBody(
                "amount", params.getAmount(),
                "reason", params.getReason(),
                "type", params.getType()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Top up a subscription's balance. Charges the customer's payment method for the specified amount.
     */
    public ApiResponse<BalanceTopup> topupBalance(String id, TopupBalanceParams params) {
        return http.post("/subscriptions/" + id + "/balance/topup", buildBody(
                "amount", params.getAmount()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Purchase a credit pack for a subscription. Charges the customer and adds credits to their balance.
     */
    public ApiResponse<CreditGrant> purchaseCredits(String id, PurchaseCreditsParams params) {
        return http.post("/subscriptions/" + id + "/credits", buildBody(
                "credit_pack_id", params.getCreditPackId()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }
}
