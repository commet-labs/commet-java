package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransactionRetry(
        @JsonProperty("original_transaction_id") String originalTransactionId,
        @JsonProperty("invoice_id") String invoiceId,
        @JsonProperty("status") String status,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
