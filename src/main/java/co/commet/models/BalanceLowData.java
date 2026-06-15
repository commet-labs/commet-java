package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BalanceLowData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("currentBalance") double currentBalance,
        @JsonProperty("thresholdBalance") double thresholdBalance,
        @JsonProperty("currency") String currency
) {}
