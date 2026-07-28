package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatedSubscriptionCancellation(
        @JsonProperty("scheduled_at") String scheduledAt,
        @JsonProperty("reason") String reason,
        @JsonProperty("effective_at") String effectiveAt
) {}
