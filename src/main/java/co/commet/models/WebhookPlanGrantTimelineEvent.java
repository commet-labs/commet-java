package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookPlanGrantTimelineEvent(
        @JsonProperty("id") String id,
        @JsonProperty("type") String type,
        @JsonProperty("reason") String reason,
        @JsonProperty("source") String source,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("previous_expires_at") String previousExpiresAt,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("expires_at") String expiresAt,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("duration") String duration,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("duration_cycles") Long durationCycles,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("requested_expires_at") String requestedExpiresAt,
        @JsonProperty("created_at") String createdAt
) {}
