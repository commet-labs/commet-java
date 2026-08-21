package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerCreditRevocation(
        @JsonProperty("id") String id,
        @JsonProperty("remaining_amount") long remainingAmount,
        @JsonProperty("revoked_amount") long revokedAmount,
        @JsonProperty("currency") String currency,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
