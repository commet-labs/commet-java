package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FeatureAccessVariant3UsageOverage(
        @JsonProperty("enabled") boolean enabled,
        @JsonProperty("units") double units,
        @JsonProperty("unit_price") FeatureAccessVariant3UsageOverageUnitPrice unitPrice
) {}
