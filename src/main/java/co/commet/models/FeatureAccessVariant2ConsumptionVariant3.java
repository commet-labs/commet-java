package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record FeatureAccessVariant2ConsumptionVariant3(
        @JsonProperty("model") String model,
        @JsonProperty("period") FeatureAccessVariant2ConsumptionVariant3Period period,
        @JsonProperty("units_used") double unitsUsed,
        @JsonProperty("spent") FeatureAccessVariant2ConsumptionVariant3Spent spent,
        @JsonProperty("available_units") Long availableUnits,
        @JsonProperty("unit_price") FeatureAccessVariant2ConsumptionVariant3UnitPrice unitPrice
) implements FeatureAccessVariant2Consumption {}
