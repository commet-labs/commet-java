package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookSeatSummary(
        @JsonProperty("code") String code,
        @JsonProperty("current") Double current,
        @JsonProperty("included") Double included,
        @JsonProperty("remaining") Double remaining,
        @JsonProperty("unlimited") Boolean unlimited
) {}
