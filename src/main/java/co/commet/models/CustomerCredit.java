package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerCredit(
        @JsonProperty("id") String id,
        @JsonProperty("amount") long amount,
        @JsonProperty("applied_amount") long appliedAmount,
        @JsonProperty("reversed_amount") long reversedAmount,
        @JsonProperty("revoked_amount") long revokedAmount,
        @JsonProperty("remaining_amount") long remainingAmount,
        @JsonProperty("currency") String currency,
        @JsonProperty("reason") String reason,
        @JsonProperty("source") String source,
        @JsonProperty("expires_at") String expiresAt,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
