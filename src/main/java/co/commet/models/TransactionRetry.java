package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransactionRetry(
        @JsonProperty("id") String id,
        @JsonProperty("status") String status,
        @JsonProperty("retry_invoice_number") String retryInvoiceNumber,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
