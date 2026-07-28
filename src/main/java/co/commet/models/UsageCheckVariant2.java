package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record UsageCheckVariant2(
        @JsonProperty("allowed") boolean allowed,
        @JsonProperty("subscription_status") String subscriptionStatus,
        @JsonProperty("feature_code") String featureCode,
        @JsonProperty("quantity") long quantity,
        @JsonProperty("reason") String reason,
        @JsonProperty("message") String message,
        @JsonProperty("consumption_model") String consumptionModel,
        @JsonProperty("credits_per_unit") long creditsPerUnit,
        @JsonProperty("estimated_credits") long estimatedCredits,
        @JsonProperty("plan_credits") long planCredits,
        @JsonProperty("purchased_credits") long purchasedCredits,
        @JsonProperty("total_credits") long totalCredits,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) implements UsageCheck {}
