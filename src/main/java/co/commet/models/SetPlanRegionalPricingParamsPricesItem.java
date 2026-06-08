package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SetPlanRegionalPricingParamsPricesItem(
        @JsonProperty("price_id") String priceId,
        @JsonProperty("price") long price,
        @JsonProperty("included_balance") Long includedBalance
) {}
