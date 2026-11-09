package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatePlanExperimentParamsCurrenciesItem(
        @JsonProperty("currency") String currency,
        @JsonProperty("exchange_rate") double exchangeRate
) {}
