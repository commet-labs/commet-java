package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookTestResult(
        @JsonProperty("success") boolean success,
        @JsonProperty("delivery_id") String deliveryId,
        @JsonProperty("delivered_at") String deliveredAt
) {}
