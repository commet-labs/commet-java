package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AdjustBalanceResult(
        @JsonProperty("amount") Long amount,
        @JsonProperty("new_balance") Long newBalance,
        @JsonProperty("reason") String reason
) {}
