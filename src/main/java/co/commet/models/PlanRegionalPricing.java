package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanRegionalPricing(
        @JsonProperty("price_id") String priceId,
        @JsonProperty("overrides") List<PlanRegionalPricingOverridesItem> overrides,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
