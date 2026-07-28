package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanChangeVariant1(
        @JsonProperty("outcome") String outcome,
        @JsonProperty("requires_checkout") Object requiresCheckout,
        @JsonProperty("checkout_url") String checkoutUrl,
        @JsonProperty("offer_application") PlanChangeVariant1OfferApplication offerApplication,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) implements PlanChange {}
