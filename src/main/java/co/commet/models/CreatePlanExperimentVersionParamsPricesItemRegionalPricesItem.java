package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatePlanExperimentVersionParamsPricesItemRegionalPricesItem(
        @JsonProperty("currency") String currency,
        @JsonProperty("price") long price,
        @JsonProperty("included_balance") Long includedBalance
) {}
