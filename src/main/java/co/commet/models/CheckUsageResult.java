package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CheckUsageResult(
        @JsonProperty("allowed") boolean allowed,
        @JsonProperty("remaining") Long remaining,
        @JsonProperty("limit") Long limit,
        @JsonProperty("current_usage") Long currentUsage
) {}
