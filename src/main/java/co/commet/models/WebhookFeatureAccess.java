package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookFeatureAccess(
        @JsonProperty("code") String code,
        @JsonProperty("name") String name,
        @JsonProperty("type") String type,
        @JsonProperty("allowed") boolean allowed,
        @JsonProperty("enabled") Boolean enabled,
        @JsonProperty("current") Double current,
        @JsonProperty("included") Double included,
        @JsonProperty("remaining") Double remaining,
        @JsonProperty("overageQuantity") Double overageQuantity,
        @JsonProperty("overageUnitPrice") Double overageUnitPrice,
        @JsonProperty("unlimited") Boolean unlimited,
        @JsonProperty("overageEnabled") Boolean overageEnabled,
        @JsonProperty("billedQuantity") Double billedQuantity
) {}
