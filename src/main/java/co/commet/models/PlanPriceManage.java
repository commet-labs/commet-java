package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanPriceManage(
        @JsonProperty("id") String id,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode,
        @JsonProperty("plan_id") String planId,
        @JsonProperty("billing_interval") BillingInterval billingInterval,
        @JsonProperty("price") Long price,
        @JsonProperty("is_default") boolean isDefault,
        @JsonProperty("trial_days") int trialDays,
        @JsonProperty("included_balance") Long includedBalance,
        @JsonProperty("included_credits") Long includedCredits,
        @JsonProperty("intro_offer_enabled") boolean introOfferEnabled,
        @JsonProperty("intro_offer_discount_type") DiscountType introOfferDiscountType,
        @JsonProperty("intro_offer_discount_value") Long introOfferDiscountValue,
        @JsonProperty("intro_offer_duration_cycles") Integer introOfferDurationCycles,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt
) {}
