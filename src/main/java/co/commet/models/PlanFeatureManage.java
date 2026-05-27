package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanFeatureManage(
        @JsonProperty("plan_id") String planId,
        @JsonProperty("feature_id") String featureId,
        @JsonProperty("enabled") boolean enabled,
        @JsonProperty("included_amount") Integer includedAmount,
        @JsonProperty("unlimited") boolean unlimited,
        @JsonProperty("overage_enabled") boolean overageEnabled,
        @JsonProperty("credits_per_unit") Integer creditsPerUnit,
        @JsonProperty("pricing_mode") String pricingMode,
        @JsonProperty("overage_unit_price") Long overageUnitPrice,
        @JsonProperty("margin") Integer margin
) {}
