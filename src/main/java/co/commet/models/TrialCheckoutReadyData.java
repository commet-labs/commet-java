package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TrialCheckoutReadyData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("planName") String planName,
        @JsonProperty("trialDays") double trialDays,
        @JsonProperty("checkoutUrl") String checkoutUrl
) {}
