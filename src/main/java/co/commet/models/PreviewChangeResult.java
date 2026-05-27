package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PreviewChangeResult(
        @JsonProperty("current_plan_credit") Long currentPlanCredit,
        @JsonProperty("new_plan_charge") Long newPlanCharge,
        @JsonProperty("estimated_total") Long estimatedTotal,
        @JsonProperty("effective_date") String effectiveDate,
        @JsonProperty("days_remaining") Integer daysRemaining,
        @JsonProperty("total_days") Integer totalDays,
        @JsonProperty("is_upgrade") boolean isUpgrade
) {}
