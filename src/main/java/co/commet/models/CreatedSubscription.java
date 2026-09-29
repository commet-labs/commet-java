package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatedSubscription(
        @JsonProperty("id") String id,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("plan") CreatedSubscriptionPlan plan,
        @JsonProperty("name") String name,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("description") String description,
        @JsonProperty("status") SubscriptionStatus status,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("billing_interval") BillingInterval billingInterval,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("trial_ends_at") String trialEndsAt,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("current_period") CreatedSubscriptionCurrentPeriod currentPeriod,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("cancellation") CreatedSubscriptionCancellation cancellation,
        @JsonProperty("cancel_at_period_end") boolean cancelAtPeriodEnd,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("scheduled_plan_change") CreatedSubscriptionScheduledPlanChange scheduledPlanChange,
        @JsonProperty("start_date") String startDate,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("end_date") String endDate,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("billing_day_of_month") Long billingDayOfMonth,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("next_billing_date") String nextBillingDate,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("checkout_url") String checkoutUrl,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("offer_applications") List<SubscriptionOfferApplication> offerApplications,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("pause") CreatedSubscriptionPause pause,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("checkout_provider") PaymentProvider checkoutProvider,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("price_id") String priceId,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
