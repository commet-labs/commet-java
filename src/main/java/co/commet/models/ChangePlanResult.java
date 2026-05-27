package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChangePlanResult(
        @JsonProperty("id") String id,
        @JsonProperty("scheduled") boolean scheduled,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("previous_plan") PlanRef previousPlan,
        @JsonProperty("current_plan") CurrentPlanRef currentPlan,
        @JsonProperty("billing_interval") String billingInterval,
        @JsonProperty("billing") Billing billing,
        @JsonProperty("invoice_id") String invoiceId,
        @JsonProperty("scheduled_for") String scheduledFor,
        @JsonProperty("change_type") String changeType,
        @JsonProperty("requires_checkout") Boolean requiresCheckout,
        @JsonProperty("checkout_url") String checkoutUrl
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record PlanRef(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record CurrentPlanRef(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("price") Long price
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Billing(
            @JsonProperty("credit") Long credit,
            @JsonProperty("credits_applied") Long creditsApplied,
            @JsonProperty("charge") Long charge,
            @JsonProperty("tax_amount") Long taxAmount,
            @JsonProperty("net_amount") Long netAmount,
            @JsonProperty("total_charged") Long totalCharged,
            @JsonProperty("remaining_credit_balance") Long remainingCreditBalance
    ) {}
}
