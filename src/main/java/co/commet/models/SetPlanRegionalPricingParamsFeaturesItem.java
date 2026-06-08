package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SetPlanRegionalPricingParamsFeaturesItem(
        @JsonProperty("feature_id") String featureId,
        @JsonProperty("overage_unit_price") long overageUnitPrice
) {}
