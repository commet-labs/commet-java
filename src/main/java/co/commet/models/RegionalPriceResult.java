package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RegionalPriceResult(
        @JsonProperty("price_id") String priceId,
        @JsonProperty("overrides") List<Override> overrides
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Override(
            @JsonProperty("currency") String currency,
            @JsonProperty("price") Long price
    ) {}
}
