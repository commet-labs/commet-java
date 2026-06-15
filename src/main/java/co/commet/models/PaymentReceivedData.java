package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaymentReceivedData(
        @JsonProperty("invoiceId") String invoiceId,
        @JsonProperty("invoiceNumber") String invoiceNumber,
        @JsonProperty("invoiceTotal") double invoiceTotal,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("paymentTransactionId") String paymentTransactionId,
        @JsonProperty("grossAmount") double grossAmount,
        @JsonProperty("currency") String currency,
        @JsonProperty("orgNetAmount") double orgNetAmount,
        @JsonProperty("customerEmail") String customerEmail,
        @JsonProperty("paidAt") String paidAt
) {}
