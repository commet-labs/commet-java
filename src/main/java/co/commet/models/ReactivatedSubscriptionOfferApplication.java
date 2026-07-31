package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReactivatedSubscriptionOfferApplication(
        @JsonProperty("id") String id,
        @JsonProperty("offer_id") String offerId,
        @JsonProperty("name") String name,
        @JsonProperty("currency") String currency,
        @JsonProperty("subtotal") long subtotal,
        @JsonProperty("discount_amount") long discountAmount,
        @JsonProperty("total") long total,
        @JsonProperty("phases") List<ReactivatedSubscriptionOfferApplicationPhasesItem> phases,
        @JsonProperty("applies_to") ReactivatedSubscriptionOfferApplicationAppliesTo appliesTo
) {}
