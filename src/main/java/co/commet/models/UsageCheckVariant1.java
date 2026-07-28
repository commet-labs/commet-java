package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record UsageCheckVariant1(
        @JsonProperty("allowed") boolean allowed,
        @JsonProperty("subscription_status") String subscriptionStatus,
        @JsonProperty("feature_code") String featureCode,
        @JsonProperty("quantity") long quantity,
        @JsonProperty("reason") String reason,
        @JsonProperty("message") String message,
        @JsonProperty("consumption_model") String consumptionModel,
        @JsonProperty("current") double current,
        @JsonProperty("remaining") double remaining,
        @JsonProperty("unlimited") boolean unlimited,
        @JsonProperty("included") double included,
        @JsonProperty("overage_enabled") boolean overageEnabled,
        @JsonProperty("overage_unit_price") Double overageUnitPrice,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) implements UsageCheck {}
