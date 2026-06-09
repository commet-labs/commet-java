package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CanceledSubscription(
        @JsonProperty("id") String id,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("status") SubscriptionStatus status,
        @JsonProperty("canceled_at") String canceledAt,
        @JsonProperty("cancel_reason") String cancelReason,
        @JsonProperty("scheduled_cancellation_date") String scheduledCancellationDate,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
