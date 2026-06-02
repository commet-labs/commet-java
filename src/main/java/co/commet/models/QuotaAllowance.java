package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record QuotaAllowance(
        @JsonProperty("feature_code") String featureCode,
        @JsonProperty("current") int current,
        @JsonProperty("included") int included,
        @JsonProperty("remaining") Integer remaining,
        @JsonProperty("billed_quantity") Integer billedQuantity,
        @JsonProperty("unlimited") boolean unlimited,
        @JsonProperty("overage_enabled") boolean overageEnabled,
        @JsonProperty("as_of") String asOf
) {}
