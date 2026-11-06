package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanDraftPublicationSubscribersLeftOutItem(
        @JsonProperty("subscription_id") String subscriptionId,
        @JsonProperty("code") String code,
        @JsonProperty("message") String message
) {}
