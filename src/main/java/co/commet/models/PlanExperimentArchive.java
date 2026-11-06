package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanExperimentArchive(
        @JsonProperty("experiment") PlanExperimentArchiveExperiment experiment,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("move_id") String moveId,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
