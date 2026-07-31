package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionSummary(
        @JsonProperty("id") String id,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("plan") SubscriptionSummaryPlan plan,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("status") SubscriptionStatus status,
        @JsonProperty("billing_interval") BillingInterval billingInterval,
        @JsonProperty("trial_ends_at") String trialEndsAt,
        @JsonProperty("current_period") SubscriptionSummaryCurrentPeriod currentPeriod,
        @JsonProperty("cancellation") SubscriptionSummaryCancellation cancellation,
        @JsonProperty("cancel_at_period_end") boolean cancelAtPeriodEnd,
        @JsonProperty("scheduled_plan_change") SubscriptionSummaryScheduledPlanChange scheduledPlanChange,
        @JsonProperty("start_date") String startDate,
        @JsonProperty("end_date") String endDate,
        @JsonProperty("billing_day_of_month") Long billingDayOfMonth,
        @JsonProperty("next_billing_date") String nextBillingDate,
        @JsonProperty("checkout_url") String checkoutUrl,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("offer_applications") List<SubscriptionOfferApplication> offerApplications,
        @JsonProperty("price_id") String priceId,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
