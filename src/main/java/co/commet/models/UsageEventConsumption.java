package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UsageEventConsumption(
        @JsonProperty("model") String model,
        @JsonProperty("deducted") double deducted,
        @JsonProperty("remaining") double remaining,
        @JsonProperty("blocked") boolean blocked
) {}
