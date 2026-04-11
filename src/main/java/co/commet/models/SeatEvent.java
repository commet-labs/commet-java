package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeatEvent(
        @JsonProperty("id") String id,
        @JsonProperty("organization_id") String organizationId,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("seat_type") String seatType,
        @JsonProperty("event_type") String eventType,
        @JsonProperty("quantity") int quantity,
        @JsonProperty("previous_balance") Integer previousBalance,
        @JsonProperty("new_balance") int newBalance,
        @JsonProperty("ts") String ts,
        @JsonProperty("created_at") String createdAt
) {}
