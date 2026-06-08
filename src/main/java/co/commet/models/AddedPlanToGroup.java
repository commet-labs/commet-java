package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AddedPlanToGroup(
        @JsonProperty("success") boolean success,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
