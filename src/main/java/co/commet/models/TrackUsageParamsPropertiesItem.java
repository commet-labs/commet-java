package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TrackUsageParamsPropertiesItem(
        @JsonProperty("property") String property,
        @JsonProperty("value") String value
) {}
