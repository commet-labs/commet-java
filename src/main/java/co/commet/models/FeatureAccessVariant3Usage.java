package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FeatureAccessVariant3Usage(
        @JsonProperty("period") FeatureAccessVariant3UsagePeriod period,
        @JsonProperty("units_used") double unitsUsed,
        @JsonProperty("included_units") double includedUnits,
        @JsonProperty("remaining_units") Double remainingUnits,
        @JsonProperty("unlimited") boolean unlimited,
        @JsonProperty("overage") FeatureAccessVariant3UsageOverage overage
) {}
