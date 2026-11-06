package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdatePlanDraftParamsCountriesItemPricesItemVariant2(
        @JsonProperty("billing_interval") String billingInterval,
        @JsonProperty("follow_base") Object followBase
) implements UpdatePlanDraftParamsCountriesItemPricesItem {}
