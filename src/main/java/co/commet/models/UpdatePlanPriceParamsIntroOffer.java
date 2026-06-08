package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdatePlanPriceParamsIntroOffer(
        @JsonProperty("enabled") Boolean enabled,
        @JsonProperty("discount_type") DiscountType discountType,
        @JsonProperty("discount_value") Long discountValue,
        @JsonProperty("duration_cycles") Long durationCycles
) {}
