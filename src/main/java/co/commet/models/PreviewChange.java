package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PreviewChange(
        @JsonProperty("currency") String currency,
        @JsonProperty("current_plan_credit") long currentPlanCredit,
        @JsonProperty("new_plan_charge") long newPlanCharge,
        @JsonProperty("estimated_total") long estimatedTotal,
        @JsonProperty("effective_date") String effectiveDate,
        @JsonProperty("days_remaining") long daysRemaining,
        @JsonProperty("total_days") long totalDays,
        @JsonProperty("is_upgrade") boolean isUpgrade,
        @JsonProperty("offer_application") PreviewChangeOfferApplication offerApplication,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
