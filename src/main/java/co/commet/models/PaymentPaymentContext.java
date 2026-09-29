package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaymentPaymentContext(
        @JsonProperty("reason") String reason,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("payment_link_id") String paymentLinkId,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("recovery") PaymentPaymentContextRecovery recovery
) {}
