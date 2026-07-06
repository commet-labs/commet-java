package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaymentRefundedData(
        @JsonProperty("paymentTransactionId") String paymentTransactionId,
        @JsonProperty("paymentLinkId") String paymentLinkId,
        @JsonProperty("invoiceId") String invoiceId,
        @JsonProperty("invoiceNumber") String invoiceNumber,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("refundAmount") double refundAmount,
        @JsonProperty("currency") String currency
) {}
