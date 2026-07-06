package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TrialStartedData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("status") String status,
        @JsonProperty("planId") String planId,
        @JsonProperty("planName") String planName,
        @JsonProperty("trialEndsAt") String trialEndsAt
) {}
