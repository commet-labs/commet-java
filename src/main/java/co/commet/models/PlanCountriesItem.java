package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanCountriesItem(
        @JsonProperty("country") String country,
        @JsonProperty("currency") String currency,
        @JsonProperty("prices") List<PlanCountriesItemPricesItem> prices,
        @JsonProperty("addons") List<PlanCountriesItemAddonsItem> addons,
        @JsonProperty("credit_packs") List<PlanCountriesItemCreditPacksItem> creditPacks
) {}
