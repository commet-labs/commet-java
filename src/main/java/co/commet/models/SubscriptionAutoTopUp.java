package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionAutoTopUp(
        @JsonProperty("enabled") boolean enabled,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("threshold") Long threshold,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("quantity") Long quantity,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("max_per_period") Long maxPerPeriod,
        @JsonProperty("status") String status,
        @JsonProperty("top_ups_this_period") long topUpsThisPeriod,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("period_resets_at") String periodResetsAt,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("last_failure") SubscriptionAutoTopUpLastFailure lastFailure,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
