package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionFeaturesItemVariant3Usage(
        @JsonProperty("current") double current,
        @JsonProperty("included") double included,
        @JsonProperty("overage_quantity") double overageQuantity,
        @JsonProperty("overage_unit_price") Double overageUnitPrice
) {}
