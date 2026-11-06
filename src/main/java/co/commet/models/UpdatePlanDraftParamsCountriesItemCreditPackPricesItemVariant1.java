package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdatePlanDraftParamsCountriesItemCreditPackPricesItemVariant1(
        @JsonProperty("credit_pack_id") String creditPackId,
        @JsonProperty("price") long price
) implements UpdatePlanDraftParamsCountriesItemCreditPackPricesItem {}
