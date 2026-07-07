package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreditsLowData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("remainingCredits") double remainingCredits,
        @JsonProperty("thresholdCredits") double thresholdCredits,
        @JsonProperty("periodCredits") double periodCredits
) {}
