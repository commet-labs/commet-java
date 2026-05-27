package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookTestResult(
        @JsonProperty("success") boolean success,
        @JsonProperty("delivered_at") String deliveredAt
) {}
