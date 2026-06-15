package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerStateChangedData(
        @JsonProperty("customerId") String customerId,
        @JsonProperty("trigger") String trigger,
        @JsonProperty("status") String status,
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("plan") WebhookPlanRef plan,
        @JsonProperty("billingInterval") String billingInterval,
        @JsonProperty("consumptionModel") String consumptionModel,
        @JsonProperty("features") List<WebhookFeatureAccess> features,
        @JsonProperty("seats") List<WebhookSeatSummary> seats,
        @JsonProperty("credits") WebhookCreditsBalance credits,
        @JsonProperty("balance") WebhookBalance balance
) {}
