package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Refund(
        @JsonProperty("id") String id,
        @JsonProperty("transaction_id") String transactionId,
        @JsonProperty("amount") long amount,
        @JsonProperty("currency") String currency,
        @JsonProperty("charge_id") String chargeId,
        @JsonProperty("status") String status,
        @JsonProperty("reason") String reason,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
