package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Subscription(
        @JsonProperty("id") String id,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("plan_id") String planId,
        @JsonProperty("plan_name") String planName,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("status") String status,
        @JsonProperty("billing_interval") String billingInterval,
        @JsonProperty("trial_ends_at") String trialEndsAt,
        @JsonProperty("start_date") String startDate,
        @JsonProperty("end_date") String endDate,
        @JsonProperty("current_period_start") String currentPeriodStart,
        @JsonProperty("current_period_end") String currentPeriodEnd,
        @JsonProperty("billing_day_of_month") Integer billingDayOfMonth,
        @JsonProperty("checkout_url") String checkoutUrl,
        @JsonProperty("plan") SubscriptionPlan plan,
        @JsonProperty("current_period") CurrentPeriod currentPeriod,
        @JsonProperty("features") List<FeatureSummary> features,
        @JsonProperty("next_billing_date") String nextBillingDate,
        @JsonProperty("intro_offer_ends_at") String introOfferEndsAt,
        @JsonProperty("intro_offer_discount_type") String introOfferDiscountType,
        @JsonProperty("intro_offer_discount_value") Long introOfferDiscountValue,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record SubscriptionPlan(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("base_price") Long basePrice,
            @JsonProperty("billing_interval") String billingInterval
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record CurrentPeriod(
            @JsonProperty("start") String start,
            @JsonProperty("end") String end,
            @JsonProperty("days_remaining") Integer daysRemaining
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record FeatureSummary(
            @JsonProperty("code") String code,
            @JsonProperty("name") String name,
            @JsonProperty("type") String type,
            @JsonProperty("enabled") Boolean enabled,
            @JsonProperty("usage") FeatureUsage usage
    ) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record FeatureUsage(
                @JsonProperty("current") Integer current,
                @JsonProperty("included") Integer included,
                @JsonProperty("overage") Integer overage,
                @JsonProperty("overage_unit_price") Long overageUnitPrice
        ) {}
    }
}
