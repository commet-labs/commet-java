package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionPlanChangedData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("previousPlan") WebhookPlanRef previousPlan,
        @JsonProperty("currentPlan") WebhookPlanRef currentPlan,
        @JsonProperty("billingInterval") String billingInterval,
        @JsonProperty("credit") Double credit,
        @JsonProperty("charge") Double charge,
        @JsonProperty("totalCharged") Double totalCharged
) {}
