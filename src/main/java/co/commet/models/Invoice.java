package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Invoice(
        @JsonProperty("id") String id,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("subscription_id") String subscriptionId,
        @JsonProperty("invoice_number") String invoiceNumber,
        @JsonProperty("status") String status,
        @JsonProperty("invoice_type") String invoiceType,
        @JsonProperty("currency") String currency,
        @JsonProperty("subtotal") Long subtotal,
        @JsonProperty("discount_amount") Long discountAmount,
        @JsonProperty("tax_amount") Long taxAmount,
        @JsonProperty("total") Long total,
        @JsonProperty("credit_applied") Long creditApplied,
        @JsonProperty("plan_name") String planName,
        @JsonProperty("po_number") String poNumber,
        @JsonProperty("reference") String reference,
        @JsonProperty("period_start") String periodStart,
        @JsonProperty("period_end") String periodEnd,
        @JsonProperty("issue_date") String issueDate,
        @JsonProperty("due_date") String dueDate,
        @JsonProperty("memo") String memo,
        @JsonProperty("metadata") Map<String, Object> metadata,
        @JsonProperty("line_items") List<LineItem> lineItems,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record LineItem(
            @JsonProperty("line_type") String lineType,
            @JsonProperty("feature_name") String featureName,
            @JsonProperty("description") String description,
            @JsonProperty("quantity") int quantity,
            @JsonProperty("unit_amount") Long unitAmount,
            @JsonProperty("amount") Long amount,
            @JsonProperty("included_amount") Integer includedAmount,
            @JsonProperty("used_amount") Integer usedAmount,
            @JsonProperty("overage_amount") Integer overageAmount,
            @JsonProperty("discount_type") String discountType,
            @JsonProperty("discount_value") Long discountValue,
            @JsonProperty("discount_name") String discountName,
            @JsonProperty("charge_type") String chargeType
    ) {}
}
