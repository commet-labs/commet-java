package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InvoiceCreatedData(
        @JsonProperty("invoiceId") String invoiceId,
        @JsonProperty("invoiceNumber") String invoiceNumber,
        @JsonProperty("invoiceStatus") String invoiceStatus,
        @JsonProperty("periodStart") String periodStart,
        @JsonProperty("periodEnd") String periodEnd,
        @JsonProperty("issueDate") String issueDate,
        @JsonProperty("dueDate") String dueDate,
        @JsonProperty("currency") String currency,
        @JsonProperty("subtotal") double subtotal,
        @JsonProperty("total") double total,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("subscriptionId") String subscriptionId
) {}
