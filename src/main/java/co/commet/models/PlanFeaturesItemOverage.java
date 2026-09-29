package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanFeaturesItemOverage(
        @JsonProperty("enabled") boolean enabled,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("model") String model,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("unit_price") Long unitPrice
) {}
