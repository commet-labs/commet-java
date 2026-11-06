package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdatePlanDraftParamsRules(
        @JsonProperty("free_included_credits") Long freeIncludedCredits,
        @JsonProperty("free_included_balance") Long freeIncludedBalance,
        @JsonProperty("unused_plan_credits") String unusedPlanCredits,
        @JsonProperty("max_plan_credits") Long maxPlanCredits,
        @JsonProperty("plan_credit_limit") Long planCreditLimit,
        @JsonProperty("plan_credit_limit_interval") String planCreditLimitInterval,
        @JsonProperty("unused_plan_balance") String unusedPlanBalance,
        @JsonProperty("max_plan_balance") Long maxPlanBalance,
        @JsonProperty("plan_balance_limit") Long planBalanceLimit,
        @JsonProperty("plan_balance_limit_interval") String planBalanceLimitInterval,
        @JsonProperty("block_on_exhaustion") Boolean blockOnExhaustion,
        @JsonProperty("purchases_enabled") Boolean purchasesEnabled,
        @JsonProperty("credit_purchase_unit_price") Long creditPurchaseUnitPrice,
        @JsonProperty("credit_purchase_minimum") Long creditPurchaseMinimum,
        @JsonProperty("top_up_minimum") Long topUpMinimum
) {}
