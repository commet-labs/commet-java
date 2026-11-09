package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanMove(
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("id") String id,
        @JsonProperty("to_version_id") String toVersionId,
        @JsonProperty("from_version_ids") List<String> fromVersionIds,
        @JsonProperty("effective") String effective,
        @JsonProperty("preview") boolean preview,
        @JsonProperty("status") String status,
        @JsonProperty("counts") PlanMoveCounts counts,
        @JsonProperty("subscriptions") List<PlanMoveSubscriptionsItem> subscriptions,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("created_at") String createdAt,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("completed_at") String completedAt,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("canceled_at") String canceledAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
