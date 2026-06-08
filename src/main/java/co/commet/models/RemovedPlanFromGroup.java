package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RemovedPlanFromGroup(
        @JsonProperty("id") String id,
        @JsonProperty("removed") boolean removed,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
