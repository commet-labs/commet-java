package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FeatureAccess(
        @JsonProperty("code") String code,
        @JsonProperty("name") String name,
        @JsonProperty("type") FeatureType type,
        @JsonProperty("allowed") boolean allowed,
        @JsonProperty("enabled") Boolean enabled,
        @JsonProperty("current") Double current,
        @JsonProperty("included") Double included,
        @JsonProperty("remaining") Double remaining,
        @JsonProperty("overage_quantity") Double overageQuantity,
        @JsonProperty("overage_unit_price") Double overageUnitPrice,
        @JsonProperty("unlimited") Boolean unlimited,
        @JsonProperty("overage_enabled") Boolean overageEnabled,
        @JsonProperty("billed_quantity") Double billedQuantity,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
