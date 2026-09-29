package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Transaction(
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("payment_context") TransactionPaymentContext paymentContext,
        @JsonProperty("id") String id,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("invoice_id") String invoiceId,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("gross_amount") Long grossAmount,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("subtotal") Long subtotal,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("tax_amount") Long taxAmount,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("presentment_amount") Long presentmentAmount,
        @JsonProperty("currency") String currency,
        @JsonProperty("provider") PaymentProvider provider,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("payment_method") PaymentMethod paymentMethod,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("sub_payment_method") SubPaymentMethod subPaymentMethod,
        @JsonProperty("status") TransactionStatus status,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("customer_email") String customerEmail,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("customer_name") String customerName,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("paid_at") String paidAt,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("available_at") String availableAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
