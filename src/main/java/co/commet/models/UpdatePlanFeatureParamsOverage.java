package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdatePlanFeatureParamsOverage(
        @JsonProperty("enabled") Boolean enabled,
        @JsonProperty("unit_price") Long unitPrice
) {}
