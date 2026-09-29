package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Payment(
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("payment_context") PaymentPaymentContext paymentContext,
        @JsonProperty("id") String id,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("kind") String kind,
        @JsonProperty("status") String status,
        @JsonProperty("provider") String provider,
        @JsonProperty("amount_subtotal") long amountSubtotal,
        @JsonProperty("tax_amount") long taxAmount,
        @JsonProperty("amount_total") long amountTotal,
        @JsonProperty("currency") String currency,
        @JsonProperty("description") String description,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("metadata") Map<String, Object> metadata,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("url") String url,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("expires_at") String expiresAt,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
