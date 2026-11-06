package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdatePlanDraftParamsPricesItem(
        @JsonProperty("billing_interval") String billingInterval,
        @JsonProperty("price") long price,
        @JsonProperty("included_credits") Long includedCredits,
        @JsonProperty("included_balance") Long includedBalance,
        @JsonProperty("trial_days") Long trialDays,
        @JsonProperty("trial_requires_payment_method") Boolean trialRequiresPaymentMethod,
        @JsonProperty("is_default") Boolean isDefault
) {}
