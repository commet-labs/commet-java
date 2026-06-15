package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InvoiceUpcomingData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("status") String status,
        @JsonProperty("planId") String planId,
        @JsonProperty("planName") String planName,
        @JsonProperty("billingInterval") String billingInterval,
        @JsonProperty("currentPeriodEnd") String currentPeriodEnd
) {}
