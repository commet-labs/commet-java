package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatedSubscriptionScheduledPlanChange(
        @JsonProperty("change_type") String changeType,
        @JsonProperty("new_plan_id") String newPlanId,
        @JsonProperty("new_plan_name") String newPlanName,
        @JsonProperty("new_billing_interval") String newBillingInterval,
        @JsonProperty("scheduled_for") String scheduledFor
) {}
