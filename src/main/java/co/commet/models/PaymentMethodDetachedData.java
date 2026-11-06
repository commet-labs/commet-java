package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaymentMethodDetachedData(
        @JsonProperty("customerId") String customerId,
        @JsonProperty("paymentMethod") String paymentMethodAsString,
        @JsonProperty("card") WebhookCardInfo card,
        @JsonProperty("reason") String reason
) {

    public PaymentMethod paymentMethod() {
        return PaymentMethod.fromValue(paymentMethodAsString);
    }
}
