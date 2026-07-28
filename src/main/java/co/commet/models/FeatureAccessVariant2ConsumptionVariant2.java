package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record FeatureAccessVariant2ConsumptionVariant2(
        @JsonProperty("model") String model,
        @JsonProperty("period") FeatureAccessVariant2ConsumptionVariant2Period period,
        @JsonProperty("units_used") double unitsUsed,
        @JsonProperty("credits_per_unit") long creditsPerUnit,
        @JsonProperty("credits_consumed") double creditsConsumed,
        @JsonProperty("available_units") long availableUnits
) implements FeatureAccessVariant2Consumption {}
