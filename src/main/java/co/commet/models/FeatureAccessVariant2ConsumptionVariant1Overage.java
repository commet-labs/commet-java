package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FeatureAccessVariant2ConsumptionVariant1Overage(
        @JsonProperty("enabled") boolean enabled,
        @JsonProperty("units") double units,
        @JsonProperty("unit_price") FeatureAccessVariant2ConsumptionVariant1OverageUnitPrice unitPrice
) {}
