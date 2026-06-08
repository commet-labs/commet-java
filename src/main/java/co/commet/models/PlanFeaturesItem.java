package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanFeaturesItem(
        @JsonProperty("code") String code,
        @JsonProperty("name") String name,
        @JsonProperty("type") FeatureType type,
        @JsonProperty("unit_name") String unitName,
        @JsonProperty("enabled") boolean enabled,
        @JsonProperty("included_amount") Long includedAmount,
        @JsonProperty("unlimited") boolean unlimited,
        @JsonProperty("overage") PlanFeaturesItemOverage overage,
        @JsonProperty("regional_prices") List<PlanFeaturesItemRegionalPricesItem> regionalPrices
) {}
