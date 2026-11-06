package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanPlanBalanceLimit(
        @JsonProperty("amount") long amount,
        @JsonProperty("interval") String interval
) {}
