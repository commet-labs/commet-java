package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RemovedPlanFeature(
        @JsonProperty("id") String id,
        @JsonProperty("removed") Object removed,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
