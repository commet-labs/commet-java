package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanMoveSubscriptionsItem(
        @JsonProperty("subscription_id") String subscriptionId,
        @JsonProperty("status") String status,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("code") String code,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("message") String message
) {}
