package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Payment(
        @JsonProperty("id") String id,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("kind") String kind,
        @JsonProperty("status") String status,
        @JsonProperty("provider") PaymentProvider provider,
        @JsonProperty("amount_subtotal") long amountSubtotal,
        @JsonProperty("tax_amount") long taxAmount,
        @JsonProperty("amount_total") long amountTotal,
        @JsonProperty("currency") String currency,
        @JsonProperty("description") String description,
        @JsonProperty("metadata") Map<String, Object> metadata,
        @JsonProperty("url") String url,
        @JsonProperty("expires_at") String expiresAt,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
