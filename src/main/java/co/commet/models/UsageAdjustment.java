package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UsageAdjustment(
        @JsonProperty("id") String id,
        @JsonProperty("value") long value,
        @JsonProperty("previous_value") long previousValue,
        @JsonProperty("adjustment") long adjustment,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("reason") String reason,
        @JsonProperty("ts") String ts,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("feature_code") String featureCode,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
