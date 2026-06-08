package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanFeature(
        @JsonProperty("plan_id") String planId,
        @JsonProperty("feature_id") String featureId,
        @JsonProperty("enabled") boolean enabled,
        @JsonProperty("included_amount") long includedAmount,
        @JsonProperty("unlimited") boolean unlimited,
        @JsonProperty("overage") PlanFeatureOverage overage,
        @JsonProperty("credits_per_unit") Long creditsPerUnit,
        @JsonProperty("pricing_mode") String pricingMode,
        @JsonProperty("margin") Long margin,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
