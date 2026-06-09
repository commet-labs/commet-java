package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanFeaturesItemOverage(
        @JsonProperty("enabled") boolean enabled,
        @JsonProperty("model") String model,
        @JsonProperty("unit_price") Long unitPrice
) {}
