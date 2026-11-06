package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatePlanExperimentVersionParamsPricesItem(
        @JsonProperty("billing_interval") String billingInterval,
        @JsonProperty("price") long price,
        @JsonProperty("included_credits") Long includedCredits,
        @JsonProperty("included_balance") Long includedBalance,
        @JsonProperty("regional_prices") List<CreatePlanExperimentVersionParamsPricesItemRegionalPricesItem> regionalPrices
) {}
