package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionPlanChangeRevokedData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("status") String status,
        @JsonProperty("currentPlan") WebhookPlanRef currentPlan,
        @JsonProperty("revokedPlan") WebhookPlanRef revokedPlan,
        @JsonProperty("billingInterval") String billingInterval,
        @JsonProperty("revokedBillingInterval") String revokedBillingInterval
) {}
