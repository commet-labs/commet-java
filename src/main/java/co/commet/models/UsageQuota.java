package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UsageQuota(
        @JsonProperty("feature_code") String featureCode,
        @JsonProperty("current") double current,
        @JsonProperty("included") double included,
        @JsonProperty("remaining") Double remaining,
        @JsonProperty("billed_quantity") double billedQuantity,
        @JsonProperty("unlimited") boolean unlimited,
        @JsonProperty("overage_enabled") boolean overageEnabled,
        @JsonProperty("as_of") String asOf,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
