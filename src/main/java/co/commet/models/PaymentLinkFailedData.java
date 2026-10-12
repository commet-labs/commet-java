package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaymentLinkFailedData(
        @JsonProperty("paymentContext") Object paymentContext,
        @JsonProperty("paymentId") String paymentId,
        @JsonProperty("status") String status,
        @JsonProperty("amount") double amount,
        @JsonProperty("currency") String currency,
        @JsonProperty("description") String description,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("failureCode") String failureCode,
        @JsonProperty("failureMessage") String failureMessage,
        @JsonProperty("paymentMethod") String paymentMethodAsString,
        @JsonProperty("subPaymentMethod") String subPaymentMethodAsString
) {

    public PaymentMethod paymentMethod() {
        return PaymentMethod.fromValue(paymentMethodAsString);
    }

    public SubPaymentMethod subPaymentMethod() {
        return SubPaymentMethod.fromValue(subPaymentMethodAsString);
    }
}
