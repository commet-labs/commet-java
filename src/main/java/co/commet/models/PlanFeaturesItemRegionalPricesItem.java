package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanFeaturesItemRegionalPricesItem(
        @JsonProperty("currency") String currency,
        @JsonProperty("overage_unit_price") Long overageUnitPrice,
        @JsonProperty("auto_synced") boolean autoSynced
) {}
