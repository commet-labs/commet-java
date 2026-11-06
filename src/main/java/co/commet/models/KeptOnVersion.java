package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record KeptOnVersion(
        @JsonProperty("subscription_id") String subscriptionId,
        @JsonProperty("kept_on_version") Object keptOnVersion,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
