package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookSeatSummary(
        @JsonProperty("code") String code,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("current") Double current,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("included") Double included,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("remaining") Double remaining,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("unlimited") Boolean unlimited
) {}
