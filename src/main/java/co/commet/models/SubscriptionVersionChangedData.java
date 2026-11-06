package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionVersionChangedData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("fromVersionId") String fromVersionId,
        @JsonProperty("toVersionId") String toVersionId,
        @JsonProperty("currency") String currency,
        @JsonProperty("billingInterval") String billingInterval
) {}
