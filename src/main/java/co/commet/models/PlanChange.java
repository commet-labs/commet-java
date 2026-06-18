package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanChange(
        @JsonProperty("requires_checkout") Boolean requiresCheckout,
        @JsonProperty("checkout_url") String checkoutUrl,
        @JsonProperty("id") String id,
        @JsonProperty("scheduled") Boolean scheduled,
        @JsonProperty("scheduled_for") String scheduledFor,
        @JsonProperty("change_type") String changeType,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("new_plan_id") String newPlanId,
        @JsonProperty("new_plan_name") String newPlanName,
        @JsonProperty("new_billing_interval") String newBillingInterval,
        @JsonProperty("previous_plan") PlanChangePreviousPlan previousPlan,
        @JsonProperty("current_plan") PlanChangeCurrentPlan currentPlan,
        @JsonProperty("billing_interval") String billingInterval,
        @JsonProperty("billing") PlanChangeBilling billing,
        @JsonProperty("invoice_id") String invoiceId,
        @JsonProperty("seat_limit_warning") PlanChangeSeatLimitWarning seatLimitWarning,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
