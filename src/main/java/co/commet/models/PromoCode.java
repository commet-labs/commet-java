package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PromoCode(
        @JsonProperty("id") String id,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode,
        @JsonProperty("code") String code,
        @JsonProperty("discount_type") DiscountType discountType,
        @JsonProperty("discount_value") Long discountValue,
        @JsonProperty("duration_cycles") Integer durationCycles,
        @JsonProperty("max_redemptions") Integer maxRedemptions,
        @JsonProperty("expires_at") String expiresAt,
        @JsonProperty("active") boolean active,
        @JsonProperty("redemption_count") int redemptionCount,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt
) {}
