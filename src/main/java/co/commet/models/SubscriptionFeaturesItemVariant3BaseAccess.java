package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionFeaturesItemVariant3BaseAccess(
        @JsonProperty("included") double included,
        @JsonProperty("unlimited") boolean unlimited
) {}
