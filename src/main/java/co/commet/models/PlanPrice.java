package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanPrice(
        @JsonProperty("id") String id,
        @JsonProperty("plan_id") String planId,
        @JsonProperty("billing_interval") BillingInterval billingInterval,
        @JsonProperty("price") long price,
        @JsonProperty("is_default") boolean isDefault,
        @JsonProperty("trial_days") long trialDays,
        @JsonProperty("included_balance") Long includedBalance,
        @JsonProperty("included_credits") Long includedCredits,
        @JsonProperty("intro_offer") PlanPriceIntroOffer introOffer,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
