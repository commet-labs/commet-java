package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionFeaturesItem(
        @JsonProperty("code") String code,
        @JsonProperty("name") String name,
        @JsonProperty("type") FeatureType type,
        @JsonProperty("enabled") Boolean enabled,
        @JsonProperty("usage") SubscriptionFeaturesItemUsage usage
) {}
