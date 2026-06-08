package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanRegionalPricingResult(
        @JsonProperty("plan_id") String planId,
        @JsonProperty("currency") String currency,
        @JsonProperty("exchange_rate") double exchangeRate,
        @JsonProperty("prices_configured") long pricesConfigured,
        @JsonProperty("features_configured") long featuresConfigured,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
