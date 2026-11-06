package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdatePlanDraftParamsCountriesItemAddonPricesItemVariant2(
        @JsonProperty("addon_id") String addonId,
        @JsonProperty("follow_base") Object followBase
) implements UpdatePlanDraftParamsCountriesItemAddonPricesItem {}
