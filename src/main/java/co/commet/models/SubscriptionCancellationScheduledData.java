package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionCancellationScheduledData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("status") String status,
        @JsonProperty("canceledAt") String canceledAt,
        @JsonProperty("cancelReason") String cancelReason,
        @JsonProperty("effectiveAt") String effectiveAt
) {}
