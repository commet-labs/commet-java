package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriberNeedingAChange(
        @JsonProperty("subscription_id") String subscriptionId,
        @JsonProperty("move_id") String moveId,
        @JsonProperty("from_version_id") String fromVersionId,
        @JsonProperty("to_version_id") String toVersionId,
        @JsonProperty("code") String code,
        @JsonProperty("message") String message,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
