package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UsageEventConsumptionPlanCreditLimit(
        @JsonProperty("credits") long credits,
        @JsonProperty("interval") String interval,
        @JsonProperty("spent") long spent,
        @JsonProperty("remaining") long remaining,
        @JsonProperty("resets_at") String resetsAt
) {}
