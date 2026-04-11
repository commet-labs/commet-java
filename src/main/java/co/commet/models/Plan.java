package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Plan(
        @JsonProperty("id") String id,
        @JsonProperty("code") String code,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("is_public") boolean isPublic,
        @JsonProperty("is_free") Boolean isFree,
        @JsonProperty("is_default") boolean isDefault,
        @JsonProperty("sort_order") int sortOrder,
        @JsonProperty("prices") List<PlanPrice> prices,
        @JsonProperty("features") List<PlanFeature> features,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record PlanPrice(
            @JsonProperty("billing_interval") String billingInterval,
            @JsonProperty("price") Long price,
            @JsonProperty("is_default") boolean isDefault,
            @JsonProperty("trial_days") int trialDays,
            @JsonProperty("intro_offer") IntroOffer introOffer
    ) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record IntroOffer(
                @JsonProperty("enabled") boolean enabled,
                @JsonProperty("discount_type") String discountType,
                @JsonProperty("discount_value") Long discountValue,
                @JsonProperty("duration_cycles") Integer durationCycles
        ) {}
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record PlanFeature(
            @JsonProperty("code") String code,
            @JsonProperty("name") String name,
            @JsonProperty("type") String type,
            @JsonProperty("unit_name") String unitName,
            @JsonProperty("enabled") Boolean enabled,
            @JsonProperty("included_amount") Integer includedAmount,
            @JsonProperty("unlimited") Boolean unlimited,
            @JsonProperty("overage_enabled") Boolean overageEnabled,
            @JsonProperty("overage_unit_price") Long overageUnitPrice,
            @JsonProperty("overage") Overage overage
    ) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Overage(
                @JsonProperty("enabled") boolean enabled,
                @JsonProperty("model") String model,
                @JsonProperty("unit_price") Long unitPrice
        ) {}
    }
}
