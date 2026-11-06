package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanCountriesItemAddonsItem(
        @JsonProperty("addon_id") String addonId,
        @JsonProperty("price") long price,
        @JsonProperty("manual") boolean manual
) {}
