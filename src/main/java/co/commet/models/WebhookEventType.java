package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum WebhookEventType {
    SUBSCRIPTION_CREATED("subscription.created"),
    SUBSCRIPTION_ACTIVATED("subscription.activated"),
    SUBSCRIPTION_CANCELED("subscription.canceled"),
    SUBSCRIPTION_UPDATED("subscription.updated"),
    SUBSCRIPTION_PLAN_CHANGED("subscription.plan_changed"),
    SUBSCRIPTION_CANCELLATION_SCHEDULED("subscription.cancellation_scheduled"),
    SUBSCRIPTION_CANCELLATION_REVOKED("subscription.cancellation_revoked"),
    SUBSCRIPTION_PLAN_CHANGE_SCHEDULED("subscription.plan_change_scheduled"),
    SUBSCRIPTION_PLAN_CHANGE_REVOKED("subscription.plan_change_revoked"),
    SUBSCRIPTION_PAST_DUE("subscription.past_due"),
    TRIAL_STARTED("trial.started"),
    TRIAL_CONVERTED("trial.converted"),
    TRIAL_EXPIRED("trial.expired"),
    TRIAL_WILL_END("trial.will_end"),
    TRIAL_CHECKOUT_READY("trial.checkout_ready"),
    CHECKOUT_READY("checkout.ready"),
    PAYMENT_RECEIVED("payment.received"),
    PAYMENT_FAILED("payment.failed"),
    PAYMENT_RECOVERED("payment.recovered"),
    PAYMENT_REFUNDED("payment.refunded"),
    PAYMENT_DISPUTED("payment.disputed"),
    PAYMENT_DISPUTE_RESOLVED("payment.dispute_resolved"),
    INVOICE_CREATED("invoice.created"),
    INVOICE_UPCOMING("invoice.upcoming"),
    INVOICE_OVERDUE("invoice.overdue"),
    INVOICE_VOIDED("invoice.voided"),
    PAYMENT_METHOD_ATTACHED("payment_method.attached"),
    PAYMENT_METHOD_UPDATED("payment_method.updated"),
    CUSTOMER_CREATED("customer.created"),
    CUSTOMER_UPDATED("customer.updated"),
    CUSTOMER_STATE_CHANGED("customer.state_changed"),
    CREDITS_GRANTED("credits.granted"),
    CREDITS_PURCHASED("credits.purchased"),
    CREDITS_LOW("credits.low"),
    CREDITS_DEPLETED("credits.depleted"),
    CREDITS_EXPIRED("credits.expired"),
    BALANCE_TOPPED_UP("balance.topped_up"),
    BALANCE_LOW("balance.low"),
    BALANCE_DEPLETED("balance.depleted"),
    QUOTA_THRESHOLD_REACHED("quota.threshold_reached"),
    QUOTA_EXCEEDED("quota.exceeded"),
    USAGE_RECORDED("usage.recorded"),
    SEATS_UPDATED("seats.updated"),
    SEATS_LIMIT_REACHED("seats.limit_reached"),
    ADDON_ACTIVATED("addon.activated"),
    ADDON_DEACTIVATED("addon.deactivated"),
    PAYOUT_AVAILABLE("payout.available"),
    PAYOUT_CREATED("payout.created"),
    PAYOUT_PAID("payout.paid"),
    PAYOUT_FAILED("payout.failed");

    private final String value;

    WebhookEventType(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static WebhookEventType fromValue(String value) {
        for (WebhookEventType type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown WebhookEventType: " + value);
    }
}
