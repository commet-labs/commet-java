package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanVersionPricesItem(
        @JsonProperty("id") String id,
        @JsonProperty("billing_interval") String billingInterval,
        @JsonProperty("price") long price,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("included_credits") Long includedCredits,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("included_balance") Long includedBalance,
        @JsonProperty("regional_prices") List<PlanVersionPricesItemRegionalPricesItem> regionalPrices
) {}
