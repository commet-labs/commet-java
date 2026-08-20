package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanGrant(
        @JsonProperty("id") String id,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("subscription_id") String subscriptionId,
        @JsonProperty("base_plan_id") String basePlanId,
        @JsonProperty("plan_id") String planId,
        @JsonProperty("plan_release_id") String planReleaseId,
        @JsonProperty("status") String status,
        @JsonProperty("duration") String duration,
        @JsonProperty("duration_cycles") Long durationCycles,
        @JsonProperty("starts_at") String startsAt,
        @JsonProperty("expires_at") String expiresAt,
        @JsonProperty("reason") String reason,
        @JsonProperty("source") String source,
        @JsonProperty("revoked_at") String revokedAt,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("events") List<PlanGrantEventsItem> events,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
