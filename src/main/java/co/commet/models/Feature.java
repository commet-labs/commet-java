package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Feature(
        @JsonProperty("code") String code,
        @JsonProperty("name") String name,
        @JsonProperty("type") String type,
        @JsonProperty("allowed") boolean allowed,
        @JsonProperty("enabled") Boolean enabled,
        @JsonProperty("current") Integer current,
        @JsonProperty("included") Integer included,
        @JsonProperty("remaining") Integer remaining,
        @JsonProperty("overage") Integer overage,
        @JsonProperty("overage_unit_price") Long overageUnitPrice,
        @JsonProperty("unlimited") Boolean unlimited,
        @JsonProperty("overage_enabled") Boolean overageEnabled
) {}
