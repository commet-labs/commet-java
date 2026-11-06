package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanDraftPublicationSubscribers(
        @JsonProperty("moving") long moving,
        @JsonProperty("kept_on_version") long keptOnVersion,
        @JsonProperty("needs_a_change") long needsAChange,
        @JsonProperty("left_out") List<PlanDraftPublicationSubscribersLeftOutItem> leftOut
) {}
