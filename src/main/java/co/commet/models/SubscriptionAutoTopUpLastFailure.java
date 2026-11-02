package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionAutoTopUpLastFailure(
        @JsonProperty("reason") String reason,
        @JsonProperty("at") String at
) {}
