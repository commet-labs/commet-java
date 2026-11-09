package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanDraftPublication(
        @JsonProperty("preview") boolean preview,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("version") PlanDraftPublicationVersion version,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("move_id") String moveId,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("subscribers") PlanDraftPublicationSubscribers subscribers,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
