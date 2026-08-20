package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FeatureAccessVariant4BaseAccess(
        @JsonProperty("included_units") double includedUnits,
        @JsonProperty("unlimited") boolean unlimited
) {}
