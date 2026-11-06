package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdatePlanDraftParamsCountriesItemPricesItemVariant1(
        @JsonProperty("billing_interval") String billingInterval,
        @JsonProperty("price") long price,
        @JsonProperty("included_balance") Long includedBalance
) implements UpdatePlanDraftParamsCountriesItemPricesItem {}
