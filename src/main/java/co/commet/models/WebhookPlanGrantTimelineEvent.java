package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookPlanGrantTimelineEvent(
        @JsonProperty("id") String id,
        @JsonProperty("type") String type,
        @JsonProperty("reason") String reason,
        @JsonProperty("source") String source,
        @JsonProperty("previous_expires_at") String previousExpiresAt,
        @JsonProperty("expires_at") String expiresAt,
        @JsonProperty("duration") String duration,
        @JsonProperty("duration_cycles") Long durationCycles,
        @JsonProperty("requested_expires_at") String requestedExpiresAt,
        @JsonProperty("created_at") String createdAt
) {}
