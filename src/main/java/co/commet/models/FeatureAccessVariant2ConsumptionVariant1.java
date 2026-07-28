package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record FeatureAccessVariant2ConsumptionVariant1(
        @JsonProperty("model") String model,
        @JsonProperty("period") FeatureAccessVariant2ConsumptionVariant1Period period,
        @JsonProperty("units_used") double unitsUsed,
        @JsonProperty("included_units") double includedUnits,
        @JsonProperty("remaining_units") Double remainingUnits,
        @JsonProperty("unlimited") boolean unlimited,
        @JsonProperty("overage") FeatureAccessVariant2ConsumptionVariant1Overage overage
) implements FeatureAccessVariant2Consumption {}
