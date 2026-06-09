package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanPricesItem(
        @JsonProperty("billing_interval") BillingInterval billingInterval,
        @JsonProperty("price") long price,
        @JsonProperty("is_default") boolean isDefault,
        @JsonProperty("trial_days") long trialDays,
        @JsonProperty("included_balance") Long includedBalance,
        @JsonProperty("included_credits") Long includedCredits,
        @JsonProperty("intro_offer") PlanPricesItemIntroOffer introOffer,
        @JsonProperty("regional_prices") List<PlanPricesItemRegionalPricesItem> regionalPrices
) {}
