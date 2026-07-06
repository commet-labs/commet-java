package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaymentLinkCompletedData(
        @JsonProperty("paymentId") String paymentId,
        @JsonProperty("status") String status,
        @JsonProperty("amount") double amount,
        @JsonProperty("currency") String currency,
        @JsonProperty("description") String description,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("invoiceId") String invoiceId,
        @JsonProperty("invoiceNumber") String invoiceNumber,
        @JsonProperty("paymentTransactionId") String paymentTransactionId
) {}
