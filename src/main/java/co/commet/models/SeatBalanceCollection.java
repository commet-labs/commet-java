package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeatBalanceCollection(
        @JsonProperty("balances") Map<String, SeatBalanceCollectionBalancesValue> balances,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
