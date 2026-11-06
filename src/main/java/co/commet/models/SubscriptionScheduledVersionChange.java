package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionScheduledVersionChange(
        @JsonProperty("plan_version_id") String planVersionId,
        @JsonProperty("label") String label,
        @JsonProperty("effective_at") String effectiveAt
) {}
