package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransactionRetryResult(
        @JsonProperty("id") String id,
        // Synthetic literal "processing" returned by the retry endpoint; not a
        // TransactionStatus value, so kept as String.
        @JsonProperty("status") String status,
        @JsonProperty("retry_invoice_number") String retryInvoiceNumber
) {}
