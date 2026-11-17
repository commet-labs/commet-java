package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookBalance(
        @JsonProperty("unlimited") boolean unlimited,
        @JsonProperty("current_balance") Double currentBalance,
        @JsonProperty("plan_balance") Double planBalance,
        @JsonProperty("purchased_balance") double purchasedBalance,
        @JsonProperty("total_balance") Double totalBalance
) {}
