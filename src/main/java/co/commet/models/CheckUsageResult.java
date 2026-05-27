package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CheckUsageResult(
        @JsonProperty("allowed") boolean allowed,
        @JsonProperty("consumption_model") String consumptionModel,
        @JsonProperty("feature") String feature,
        @JsonProperty("quantity") int quantity,
        @JsonProperty("current") Integer current,
        @JsonProperty("remaining") Integer remaining,
        @JsonProperty("unlimited") Boolean unlimited,
        @JsonProperty("included") Integer included,
        @JsonProperty("overage_enabled") Boolean overageEnabled,
        @JsonProperty("overage_unit_price") Long overageUnitPrice,
        @JsonProperty("credits_per_unit") Integer creditsPerUnit,
        @JsonProperty("estimated_credits") Integer estimatedCredits,
        @JsonProperty("plan_credits") Integer planCredits,
        @JsonProperty("purchased_credits") Integer purchasedCredits,
        @JsonProperty("total_credits") Integer totalCredits,
        @JsonProperty("unit_price") Long unitPrice,
        @JsonProperty("estimated_amount") Long estimatedAmount,
        @JsonProperty("current_balance") Long currentBalance,
        @JsonProperty("block_on_exhaustion") Boolean blockOnExhaustion,
        @JsonProperty("currency") String currency,
        @JsonProperty("reason") String reason,
        @JsonProperty("message") String message
) {}
