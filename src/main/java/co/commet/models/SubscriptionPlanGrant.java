package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionPlanGrant(
        @JsonProperty("id") String id,
        @JsonProperty("plan") SubscriptionPlanGrantPlan plan,
        @JsonProperty("expires_at") String expiresAt
) {}
