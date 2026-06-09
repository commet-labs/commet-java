package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateSubscriptionParamsIntroOffer(
        @JsonProperty("discount_type") DiscountType discountType,
        @JsonProperty("discount_value") long discountValue,
        @JsonProperty("duration_cycles") long durationCycles
) {}
