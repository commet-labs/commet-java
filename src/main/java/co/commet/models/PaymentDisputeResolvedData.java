package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaymentDisputeResolvedData(
        @JsonProperty("paymentTransactionId") String paymentTransactionId,
        @JsonProperty("paymentLinkId") String paymentLinkId,
        @JsonProperty("invoiceId") String invoiceId,
        @JsonProperty("invoiceNumber") String invoiceNumber,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("disputeAmount") double disputeAmount,
        @JsonProperty("currency") String currency,
        @JsonProperty("disputeReason") String disputeReason,
        @JsonProperty("outcome") String outcome
) {}
