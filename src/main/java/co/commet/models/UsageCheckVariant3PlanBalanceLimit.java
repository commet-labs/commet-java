package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UsageCheckVariant3PlanBalanceLimit(
        @JsonProperty("amount") long amount,
        @JsonProperty("interval") String interval,
        @JsonProperty("spent") long spent,
        @JsonProperty("remaining") long remaining,
        @JsonProperty("resets_at") String resetsAt
) {}
