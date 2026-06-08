package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanFeatureOverage(
        @JsonProperty("enabled") boolean enabled,
        @JsonProperty("unit_price") long unitPrice
) {}
