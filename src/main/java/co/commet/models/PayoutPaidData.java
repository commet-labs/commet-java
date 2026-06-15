package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PayoutPaidData(
        @JsonProperty("payoutId") String payoutId,
        @JsonProperty("amount") double amount,
        @JsonProperty("fee") double fee,
        @JsonProperty("netAmount") double netAmount,
        @JsonProperty("currency") String currency,
        @JsonProperty("status") String status,
        @JsonProperty("destinationBank") WebhookBankRef destinationBank,
        @JsonProperty("paidAt") String paidAt
) {}
