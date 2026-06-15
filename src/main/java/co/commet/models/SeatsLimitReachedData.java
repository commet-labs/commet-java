package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeatsLimitReachedData(
        @JsonProperty("customerId") String customerId,
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("featureCode") String featureCode,
        @JsonProperty("currentSeats") double currentSeats,
        @JsonProperty("includedSeats") double includedSeats
) {}
