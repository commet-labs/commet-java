package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionPlanChangeScheduledData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("status") String status,
        @JsonProperty("currentPlan") WebhookPlanRef currentPlan,
        @JsonProperty("scheduledPlan") WebhookPlanRef scheduledPlan,
        @JsonProperty("billingInterval") String billingInterval,
        @JsonProperty("scheduledBillingInterval") String scheduledBillingInterval,
        @JsonProperty("effectiveAt") String effectiveAt
) {}
