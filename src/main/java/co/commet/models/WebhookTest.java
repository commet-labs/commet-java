package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookTest(
        @JsonProperty("success") boolean success,
        @JsonProperty("delivery_id") String deliveryId,
        @JsonProperty("delivered_at") String deliveredAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
