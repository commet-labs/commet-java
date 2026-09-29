package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanFeaturesItem(
        @JsonProperty("code") String code,
        @JsonProperty("name") String name,
        @JsonProperty("type") FeatureType type,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("unit_name") String unitName,
        @JsonProperty("enabled") boolean enabled,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("included_amount") Long includedAmount,
        @JsonProperty("unlimited") boolean unlimited,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("overage") PlanFeaturesItemOverage overage,
        @JsonProperty("regional_prices") List<PlanFeaturesItemRegionalPricesItem> regionalPrices
) {}
