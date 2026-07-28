package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeatBalanceCollectionBalancesValue(
        @JsonProperty("current") long current,
        @JsonProperty("as_of") String asOf
) {}
