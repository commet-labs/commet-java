package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaymentLinkCanceledData(
        @JsonProperty("paymentId") String paymentId,
        @JsonProperty("status") String status,
        @JsonProperty("amount") double amount,
        @JsonProperty("currency") String currency,
        @JsonProperty("description") String description,
        @JsonProperty("customerId") String customerId
) {}
