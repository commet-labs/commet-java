package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FeatureAccessVariant2ConsumptionVariant3Period(
        @JsonProperty("start") String start,
        @JsonProperty("end") String end
) {}
