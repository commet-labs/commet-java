package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Invoice(
        @JsonProperty("id") String id,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("subscription_id") String subscriptionId,
        @JsonProperty("invoice_number") String invoiceNumber,
        @JsonProperty("status") String status,
        @JsonProperty("invoice_type") InvoiceType invoiceType,
        @JsonProperty("currency") String currency,
        @JsonProperty("subtotal") long subtotal,
        @JsonProperty("discount_amount") long discountAmount,
        @JsonProperty("credit_applied") Long creditApplied,
        @JsonProperty("tax_amount") long taxAmount,
        @JsonProperty("total") long total,
        @JsonProperty("period_start") String periodStart,
        @JsonProperty("period_end") String periodEnd,
        @JsonProperty("issue_date") String issueDate,
        @JsonProperty("due_date") String dueDate,
        @JsonProperty("plan_name") String planName,
        @JsonProperty("memo") String memo,
        @JsonProperty("po_number") String poNumber,
        @JsonProperty("reference") String reference,
        @JsonProperty("metadata") Map<String, Object> metadata,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("line_items") List<InvoiceLineItemsItem> lineItems,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
