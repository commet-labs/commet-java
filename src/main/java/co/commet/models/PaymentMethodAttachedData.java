package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaymentMethodAttachedData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("paymentMethod") String paymentMethodAsString,
        @JsonProperty("card") WebhookCardInfo card
) {

    public PaymentMethod paymentMethod() {
        return PaymentMethod.fromValue(paymentMethodAsString);
    }
}
