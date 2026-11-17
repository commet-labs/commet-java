package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionBalance(
        @JsonProperty("unlimited") boolean unlimited,
        @JsonProperty("remaining") Double remaining,
        @JsonProperty("included") double included,
        @JsonProperty("currency") String currency,
        @JsonProperty("plan") Double plan,
        @JsonProperty("purchased") double purchased,
        @JsonProperty("total") Double total
) {}
