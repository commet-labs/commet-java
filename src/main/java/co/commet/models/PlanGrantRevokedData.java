package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanGrantRevokedData(
        @JsonProperty("id") String id,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("basePlanId") String basePlanId,
        @JsonProperty("targetPlanId") String targetPlanId,
        @JsonProperty("targetPlanReleaseId") String targetPlanReleaseId,
        @JsonProperty("status") String status,
        @JsonProperty("duration") String duration,
        @JsonProperty("durationCycles") Long durationCycles,
        @JsonProperty("startsAt") String startsAt,
        @JsonProperty("expiresAt") String expiresAt,
        @JsonProperty("reason") String reason,
        @JsonProperty("source") String source,
        @JsonProperty("revokedAt") String revokedAt,
        @JsonProperty("createdAt") String createdAt,
        @JsonProperty("updatedAt") String updatedAt,
        @JsonProperty("events") List<WebhookPlanGrantTimelineEvent> events
) {}
