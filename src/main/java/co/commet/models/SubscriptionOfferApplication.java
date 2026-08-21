package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionOfferApplication(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("applies_to") SubscriptionOfferApplicationAppliesTo appliesTo,
        @JsonProperty("offer_id") String offerId,
        @JsonProperty("source") String source,
        @JsonProperty("status") String status,
        @JsonProperty("currency") String currency,
        @JsonProperty("subtotal") Long subtotal,
        @JsonProperty("discount_amount") Long discountAmount,
        @JsonProperty("total") Long total,
        @JsonProperty("phases") List<SubscriptionOfferApplicationPhase> phases,
        @JsonProperty("quoted_at") String quotedAt,
        @JsonProperty("expires_at") String expiresAt,
        @JsonProperty("applied_at") String appliedAt
) {}
