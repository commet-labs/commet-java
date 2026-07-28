package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FeatureAccessVariant4Usage(
        @JsonProperty("period") FeatureAccessVariant4UsagePeriod period,
        @JsonProperty("units_used") double unitsUsed,
        @JsonProperty("included_units") double includedUnits,
        @JsonProperty("remaining_units") Double remainingUnits,
        @JsonProperty("unlimited") boolean unlimited,
        @JsonProperty("overage") FeatureAccessVariant4UsageOverage overage,
        @JsonProperty("billed_units") double billedUnits
) {}
