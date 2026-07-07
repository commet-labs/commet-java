package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PayoutAvailableData(
        @JsonProperty("availableAmount") double availableAmount,
        @JsonProperty("currency") String currency
) {}
