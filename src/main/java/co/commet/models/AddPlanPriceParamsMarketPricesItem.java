package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AddPlanPriceParamsMarketPricesItem(
        @JsonProperty("market_group_id") String marketGroupId,
        @JsonProperty("currency") String currency,
        @JsonProperty("price") long price
) {}
