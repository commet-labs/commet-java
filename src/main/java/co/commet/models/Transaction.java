package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Transaction(
        @JsonProperty("id") String id,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode,
        @JsonProperty("invoice_id") String invoiceId,
        @JsonProperty("gross_amount") Long grossAmount,
        @JsonProperty("subtotal") Long subtotal,
        @JsonProperty("tax_amount") Long taxAmount,
        @JsonProperty("currency") String currency,
        @JsonProperty("status") String status,
        @JsonProperty("customer_email") String customerEmail,
        @JsonProperty("customer_name") String customerName,
        @JsonProperty("available_at") String availableAt,
        @JsonProperty("paid_at") String paidAt,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt
) {}
