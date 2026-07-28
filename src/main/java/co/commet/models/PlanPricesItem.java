package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanPricesItem(
        @JsonProperty("id") String id,
        @JsonProperty("billing_interval") BillingInterval billingInterval,
        @JsonProperty("price") long price,
        @JsonProperty("is_default") boolean isDefault,
        @JsonProperty("trial_days") long trialDays,
        @JsonProperty("included_balance") Long includedBalance,
        @JsonProperty("included_credits") Long includedCredits,
        @JsonProperty("offer_id") String offerId,
        @JsonProperty("inherits_from_price_id") String inheritsFromPriceId,
        @JsonProperty("metadata") Map<String, Object> metadata,
        @JsonProperty("market_prices") List<PlanPricesItemMarketPricesItem> marketPrices,
        @JsonProperty("regional_prices") List<PlanPricesItemRegionalPricesItem> regionalPrices
) {}
