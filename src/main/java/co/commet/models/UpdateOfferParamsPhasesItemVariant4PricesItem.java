package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateOfferParamsPhasesItemVariant4PricesItem(
        @JsonProperty("currency") String currency,
        @JsonProperty("amount") long amount
) {}
