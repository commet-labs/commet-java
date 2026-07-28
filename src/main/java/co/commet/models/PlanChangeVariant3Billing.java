package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanChangeVariant3Billing(
        @JsonProperty("credit") long credit,
        @JsonProperty("credits_applied") long creditsApplied,
        @JsonProperty("charge") long charge,
        @JsonProperty("tax_amount") long taxAmount,
        @JsonProperty("net_amount") long netAmount,
        @JsonProperty("total_charged") long totalCharged,
        @JsonProperty("remaining_credit_balance") long remainingCreditBalance
) {}
