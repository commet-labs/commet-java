package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PromoCode(
        @JsonProperty("id") String id,
        @JsonProperty("code") String code,
        @JsonProperty("offer_id") String offerId,
        @JsonProperty("billing_interval") BillingInterval billingInterval,
        @JsonProperty("max_redemptions") Long maxRedemptions,
        @JsonProperty("expires_at") String expiresAt,
        @JsonProperty("is_active") boolean isActive,
        @JsonProperty("redemption_count") long redemptionCount,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
