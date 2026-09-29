package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionSummaryScheduledPlanChange(
        @JsonProperty("change_type") String changeType,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("new_plan_id") String newPlanId,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("new_plan_name") String newPlanName,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("new_billing_interval") String newBillingInterval,
        @JsonProperty("scheduled_for") String scheduledFor
) {}
