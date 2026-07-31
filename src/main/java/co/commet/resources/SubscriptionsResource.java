package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.BalanceAdjustment;
import co.commet.models.BalanceTopup;
import co.commet.models.CreatedSubscription;
import co.commet.models.CreditGrant;
import co.commet.models.DeletedSubscriptionAddon;
import co.commet.models.PaymentMethodUpdateCheckout;
import co.commet.models.PlanChange;
import co.commet.models.PreviewChange;
import co.commet.models.ReactivatedSubscription;
import co.commet.models.RecoveryLink;
import co.commet.models.Subscription;
import co.commet.models.SubscriptionAddon;
import co.commet.models.SubscriptionsListResult;
import co.commet.params.ActivateAddonParams;
import co.commet.params.AdjustBalanceParams;
import co.commet.params.CancelSubscriptionParams;
import co.commet.params.ChangePlanParams;
import co.commet.params.CreateSubscriptionParams;
import co.commet.params.CreateSubscriptionRecoveryLinkParams;
import co.commet.params.GetActiveSubscriptionParams;
import co.commet.params.ListSubscriptionsParams;
import co.commet.params.PreviewChangePlanParams;
import co.commet.params.PurchaseCreditsParams;
import co.commet.params.ReactivateSubscriptionParams;
import co.commet.params.TopupBalanceParams;
import co.commet.params.UncancelSubscriptionParams;
import co.commet.params.UpdatePaymentMethodParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class SubscriptionsResource {

    private final CommetHttpClient http;

    public SubscriptionsResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Deactivate an add-on from a subscription.
     */
    public DeletedSubscriptionAddon deactivateAddon(String id, String addonId) {
        return http.delete("/subscriptions/" + id + "/addons/" + addonId, null, new TypeReference<DeletedSubscriptionAddon>() {}).getData();
    }

    /**
     * Activate an add-on on a subscription. Charges a prorated amount for the current billing period.
     */
    public SubscriptionAddon activateAddon(String id, ActivateAddonParams params) {
        return http.post("/subscriptions/" + id + "/addons", buildBody(
                "addon_id", params.getAddonId()
        ), params.getIdempotencyKey(), new TypeReference<SubscriptionAddon>() {}).getData();
    }

    /**
     * Adjust a subscription's balance or credits by a signed amount. Positive adds, negative subtracts.
     */
    public BalanceAdjustment adjustBalance(String id, AdjustBalanceParams params) {
        return http.post("/subscriptions/" + id + "/balance/adjust", buildBody(
                "amount", params.getAmount(),
                "reason", params.getReason(),
                "type", params.getType()
        ), params.getIdempotencyKey(), new TypeReference<BalanceAdjustment>() {}).getData();
    }

    /**
     * Top up a subscription's balance. Charges the customer's payment method for the specified amount.
     */
    public BalanceTopup topupBalance(String id, TopupBalanceParams params) {
        return http.post("/subscriptions/" + id + "/balance/topup", buildBody(
                "amount", params.getAmount()
        ), params.getIdempotencyKey(), new TypeReference<BalanceTopup>() {}).getData();
    }

    /**
     * Cancel immediately or at period end and return the updated subscription.
     */
    public Subscription cancel(String id, CancelSubscriptionParams params) {
        return http.post("/subscriptions/" + id + "/cancel", buildBody(
                "reason", params.getReason(),
                "immediate", params.getImmediate()
        ), params.getIdempotencyKey(), new TypeReference<Subscription>() {}).getData();
    }

    /**
     * Upgrade or change billing interval immediately, optionally applying an Offer. Scheduled changes do not accept offers.
     */
    public PlanChange changePlan(String id, ChangePlanParams params) {
        return http.post("/subscriptions/" + id + "/change-plan", buildBody(
                "new_plan_id", params.getNewPlanId(),
                "new_billing_interval", params.getNewBillingInterval(),
                "success_url", params.getSuccessUrl(),
                "offer_id", params.getOfferId()
        ), params.getIdempotencyKey(), new TypeReference<PlanChange>() {}).getData();
    }

    /**
     * Purchase a credit pack for a subscription. Charges the customer and adds credits to their balance.
     */
    public CreditGrant purchaseCredits(String id, PurchaseCreditsParams params) {
        return http.post("/subscriptions/" + id + "/credits", buildBody(
                "credit_pack_id", params.getCreditPackId()
        ), params.getIdempotencyKey(), new TypeReference<CreditGrant>() {}).getData();
    }

    /**
     * Creates a hosted checkout session for the customer to update the subscription's default payment method.
     */
    public PaymentMethodUpdateCheckout updatePaymentMethod(String id, UpdatePaymentMethodParams params) {
        return http.post("/subscriptions/" + id + "/payment-method/update", buildBody(
                "success_url", params.getSuccessUrl()
        ), params.getIdempotencyKey(), new TypeReference<PaymentMethodUpdateCheckout>() {}).getData();
    }

    /**
     * Preview proration details for an immediate plan change without applying it. Interval direction takes precedence: a longer interval is immediate and a shorter interval is scheduled. When the interval is unchanged, a higher-sort-order plan is immediate and a lower-sort-order plan is scheduled. A paid-to-free change is always scheduled. Returns credit, charge, and net amount. The target plan must belong to the same plan group as the current plan, otherwise a 400 with code `plans_not_in_same_group` is returned. A change between two free plans has nothing to prorate and returns a zero-amount estimate. Scheduled changes return a 400 with code `plan_change_scheduled`; apply those via the change-plan endpoint. Pass offerId to quote the destination plan with an Offer.
     */
    public PreviewChange previewChange(String id, PreviewChangePlanParams params) {
        return http.post("/subscriptions/" + id + "/preview-change", buildBody(
                "plan_id", params.getPlanId(),
                "billing_interval", params.getBillingInterval(),
                "offer_id", params.getOfferId()
        ), params.getIdempotencyKey(), new TypeReference<PreviewChange>() {}).getData();
    }

    /**
     * Reactivates a subscription. A past_due subscription retries its outstanding renewal charge (recovering to active on success). A canceled subscription generates a fresh invoice, charges the saved card, and resets the billing period. On a successful charge the subscription becomes active; a declined charge returns an error with a recoveryUrl in the error details that can be sent to the customer to update their card. A canceled subscription may apply an Offer by offerId; past-due recovery cannot.
     */
    public ReactivatedSubscription reactivate(String id, ReactivateSubscriptionParams params) {
        return http.post("/subscriptions/" + id + "/reactivate", buildBody(
                "offer_id", params.getOfferId()
        ), params.getIdempotencyKey(), new TypeReference<ReactivatedSubscription>() {}).getData();
    }

    /**
     * Generates a hosted, signed recovery link that lets the customer pay the outstanding renewal charge for a past_due subscription. Unlike reactivate, which charges server-to-server, this returns a link the merchant can deliver through their own email, SMS, or dashboard. The link carries a self-contained signed token and stays valid until the charge is paid or the subscription is no longer past due.
     */
    public RecoveryLink createRecoveryLink(String id, CreateSubscriptionRecoveryLinkParams params) {
        return http.post("/subscriptions/" + id + "/recovery-links", Map.of(), params.getIdempotencyKey(), new TypeReference<RecoveryLink>() {}).getData();
    }

    /**
     * Get a subscription by its public ID, regardless of status (including pending_payment and past_due).
     */
    public Subscription get(String id) {
        return http.get("/subscriptions/" + id, new TypeReference<Subscription>() {}).getData();
    }

    /**
     * Revert a scheduled cancellation and return the updated subscription. Only works before cancellation takes effect.
     */
    public Subscription uncancel(String id, UncancelSubscriptionParams params) {
        return http.post("/subscriptions/" + id + "/uncancel", Map.of(), params.getIdempotencyKey(), new TypeReference<Subscription>() {}).getData();
    }

    /**
     * Get the active subscription for a customer. Returns null if none.
     */
    public Subscription getActive(GetActiveSubscriptionParams params) {
        return http.get("/subscriptions/active", buildBody(
                "customer_id", params.getCustomerId()
        ), new TypeReference<Subscription>() {}).getData();
    }

    /**
     * List all subscriptions. Filter by customer ID or status.
     */
    public SubscriptionsListResult list(ListSubscriptionsParams params) {
        return http.get("/subscriptions", buildBody(
                "customer_id", params.getCustomerId(),
                "status", params.getStatus()
        ), new TypeReference<SubscriptionsListResult>() {}).getData();
    }

    /**
     * Create a subscription for a customer. Commet selects the default price when priceId is omitted and resolves its market from the customer's billing country. Without an offer override, Commet applies the price's automatic introductory Offer. Pass offerId to apply any active compatible Offer directly; the Offer does not need a prior plan-price association.
     */
    public CreatedSubscription create(CreateSubscriptionParams params) {
        return http.post("/subscriptions", buildBody(
                "customer_id", params.getCustomerId(),
                "billing_interval", params.getBillingInterval(),
                "price_id", params.getPriceId(),
                "initial_seats", params.getInitialSeats(),
                "provider", params.getProvider(),
                "name", params.getName(),
                "start_date", params.getStartDate(),
                "success_url", params.getSuccessUrl(),
                "offer_id", params.getOfferId(),
                "promo_code", params.getPromoCode(),
                "custom_trial_days", params.getCustomTrialDays(),
                "skip_trial", params.getSkipTrial(),
                "plan_id", params.getPlanId(),
                "plan_code", params.getPlanCode()
        ), params.getIdempotencyKey(), new TypeReference<CreatedSubscription>() {}).getData();
    }
}
