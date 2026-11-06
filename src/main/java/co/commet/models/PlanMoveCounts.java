package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanMoveCounts(
        @JsonProperty("moving") long moving,
        @JsonProperty("moved") long moved,
        @JsonProperty("needs_a_change") long needsAChange,
        @JsonProperty("left_out") long leftOut,
        @JsonProperty("canceled") long canceled,
        @JsonProperty("kept_on_version") long keptOnVersion
) {}
