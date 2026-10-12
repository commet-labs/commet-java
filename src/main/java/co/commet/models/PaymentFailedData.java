package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaymentFailedData(
        @JsonProperty("paymentContext") Object paymentContext,
        @JsonProperty("invoiceId") String invoiceId,
        @JsonProperty("invoiceNumber") String invoiceNumber,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("provider") String provider,
        @JsonProperty("paymentMethod") String paymentMethodAsString,
        @JsonProperty("subPaymentMethod") String subPaymentMethodAsString,
        @JsonProperty("failureCode") String failureCode,
        @JsonProperty("failureMessage") String failureMessage,
        @JsonProperty("recoveryUrl") String recoveryUrl
) {

    public PaymentMethod paymentMethod() {
        return PaymentMethod.fromValue(paymentMethodAsString);
    }

    public SubPaymentMethod subPaymentMethod() {
        return SubPaymentMethod.fromValue(subPaymentMethodAsString);
    }
}
