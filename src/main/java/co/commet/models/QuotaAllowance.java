package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record QuotaAllowance(
        @JsonProperty("featureCode") String featureCode,
        @JsonProperty("current") int current,
        @JsonProperty("included") int included,
        @JsonProperty("remaining") Integer remaining,
        @JsonProperty("billedQuantity") Integer billedQuantity,
        @JsonProperty("unlimited") boolean unlimited,
        @JsonProperty("overageEnabled") boolean overageEnabled,
        @JsonProperty("asOf") String asOf
) {}
