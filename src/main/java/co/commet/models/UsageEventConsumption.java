package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UsageEventConsumption(
        @JsonProperty("model") String model,
        @JsonProperty("deducted") double deducted,
        @JsonProperty("unlimited") boolean unlimited,
        @JsonProperty("remaining") Double remaining,
        @JsonProperty("blocked") boolean blocked,
        @JsonProperty("plan_credit_limit") UsageEventConsumptionPlanCreditLimit planCreditLimit,
        @JsonProperty("plan_balance_limit") UsageEventConsumptionPlanBalanceLimit planBalanceLimit
) {}
