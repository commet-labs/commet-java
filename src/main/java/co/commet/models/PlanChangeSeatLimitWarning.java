package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanChangeSeatLimitWarning(
        @JsonProperty("feature_code") String featureCode,
        @JsonProperty("feature_name") String featureName,
        @JsonProperty("current_seats") long currentSeats,
        @JsonProperty("included") long included,
        @JsonProperty("new_plan_name") String newPlanName,
        @JsonProperty("effective_date") String effectiveDate
) {}
