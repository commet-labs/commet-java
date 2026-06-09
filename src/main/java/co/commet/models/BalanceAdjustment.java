package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BalanceAdjustment(
        @JsonProperty("amount") long amount,
        @JsonProperty("new_balance") long newBalance,
        @JsonProperty("reason") String reason,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
