package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookBalance(
        @JsonProperty("current_balance") double currentBalance,
        @JsonProperty("plan_balance") double planBalance,
        @JsonProperty("purchased_balance") double purchasedBalance,
        @JsonProperty("total_balance") double totalBalance
) {}
