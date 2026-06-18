package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaymentMethodUpdateCheckout(
        @JsonProperty("checkout_url") String checkoutUrl,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
