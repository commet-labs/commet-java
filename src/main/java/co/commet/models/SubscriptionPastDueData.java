package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionPastDueData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("status") String status,
        @JsonProperty("invoiceId") String invoiceId,
        @JsonProperty("invoiceNumber") String invoiceNumber
) {}
