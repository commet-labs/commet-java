package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionPlanGrant(
        @JsonProperty("id") String id,
        @JsonProperty("plan") SubscriptionPlanGrantPlan plan,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("expires_at") String expiresAt
) {}
