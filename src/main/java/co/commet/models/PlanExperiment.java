package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanExperiment(
        @JsonProperty("id") String id,
        @JsonProperty("code") String code,
        @JsonProperty("status") String status,
        @JsonProperty("started_from_version_id") String startedFromVersionId,
        @JsonProperty("latest_version_id") String latestVersionId,
        @JsonProperty("sells_version_id") String sellsVersionId,
        @JsonProperty("subscription_count") long subscriptionCount,
        @JsonProperty("created_at") String createdAt,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("closed_at") String closedAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
