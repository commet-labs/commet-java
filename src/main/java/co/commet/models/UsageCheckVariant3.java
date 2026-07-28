package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record UsageCheckVariant3(
        @JsonProperty("allowed") boolean allowed,
        @JsonProperty("subscription_status") String subscriptionStatus,
        @JsonProperty("feature_code") String featureCode,
        @JsonProperty("quantity") long quantity,
        @JsonProperty("reason") String reason,
        @JsonProperty("message") String message,
        @JsonProperty("consumption_model") String consumptionModel,
        @JsonProperty("unit_price") double unitPrice,
        @JsonProperty("estimated_amount") double estimatedAmount,
        @JsonProperty("current_balance") double currentBalance,
        @JsonProperty("block_on_exhaustion") boolean blockOnExhaustion,
        @JsonProperty("currency") String currency,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) implements UsageCheck {}
