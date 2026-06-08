package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatedInvoice(
        @JsonProperty("id") String id,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("invoice_number") String invoiceNumber,
        @JsonProperty("status") String status,
        @JsonProperty("invoice_type") InvoiceType invoiceType,
        @JsonProperty("currency") String currency,
        @JsonProperty("subtotal") long subtotal,
        @JsonProperty("tax_amount") long taxAmount,
        @JsonProperty("total") long total,
        @JsonProperty("issue_date") String issueDate,
        @JsonProperty("due_date") String dueDate,
        @JsonProperty("memo") String memo,
        @JsonProperty("metadata") Map<String, Object> metadata,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
