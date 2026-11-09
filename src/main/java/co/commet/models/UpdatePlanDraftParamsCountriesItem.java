package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdatePlanDraftParamsCountriesItem(
        @JsonProperty("country") String country,
        @JsonProperty("currency") String currency,
        @JsonProperty("exchange_rate") Double exchangeRate,
        @JsonProperty("prices") List<UpdatePlanDraftParamsCountriesItemPricesItem> prices,
        @JsonProperty("top_up_minimum") Long topUpMinimum,
        @JsonProperty("max_plan_balance") Long maxPlanBalance,
        @JsonProperty("plan_balance_limit") Long planBalanceLimit,
        @JsonProperty("addon_prices") List<UpdatePlanDraftParamsCountriesItemAddonPricesItem> addonPrices,
        @JsonProperty("credit_pack_prices") List<UpdatePlanDraftParamsCountriesItemCreditPackPricesItem> creditPackPrices
) {}
