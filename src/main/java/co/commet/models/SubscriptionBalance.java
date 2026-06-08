package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionBalance(
        @JsonProperty("remaining") double remaining,
        @JsonProperty("included") double included,
        @JsonProperty("currency") String currency
) {}
