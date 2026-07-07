package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionActivatedData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("status") String status,
        @JsonProperty("currentPeriodStart") String currentPeriodStart,
        @JsonProperty("currentPeriodEnd") String currentPeriodEnd,
        @JsonProperty("name") String name,
        @JsonProperty("invoiceId") String invoiceId,
        @JsonProperty("invoiceNumber") String invoiceNumber,
        @JsonProperty("invoiceTotal") double invoiceTotal,
        @JsonProperty("invoiceCurrency") String invoiceCurrency
) {}
