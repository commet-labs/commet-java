package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionOfferApplication(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("applies_to") SubscriptionOfferApplicationAppliesTo appliesTo,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("offer_id") String offerId,
        @JsonProperty("source") String source,
        @JsonProperty("status") String status,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("currency") String currency,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("subtotal") Long subtotal,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("discount_amount") Long discountAmount,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("total") Long total,
        @JsonProperty("phases") List<SubscriptionOfferApplicationPhase> phases,
        @JsonProperty("quoted_at") String quotedAt,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("expires_at") String expiresAt,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("applied_at") String appliedAt
) {}
