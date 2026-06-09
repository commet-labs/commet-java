package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionCurrentPeriod(
        @JsonProperty("start") String start,
        @JsonProperty("end") String end,
        @JsonProperty("days_remaining") double daysRemaining
) {}
