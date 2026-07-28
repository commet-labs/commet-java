package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanChangeVariant2(
        @JsonProperty("outcome") String outcome,
        @JsonProperty("id") String id,
        @JsonProperty("scheduled") Object scheduled,
        @JsonProperty("scheduled_for") String scheduledFor,
        @JsonProperty("change_type") String changeType,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("new_plan_id") String newPlanId,
        @JsonProperty("new_plan_name") String newPlanName,
        @JsonProperty("new_billing_interval") String newBillingInterval,
        @JsonProperty("seat_limit_warning") PlanChangeVariant2SeatLimitWarning seatLimitWarning,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) implements PlanChange {}
