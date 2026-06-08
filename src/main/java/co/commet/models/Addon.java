package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Addon(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("slug") String slug,
        @JsonProperty("description") String description,
        @JsonProperty("base_price") long basePrice,
        @JsonProperty("consumption_model") String consumptionModel,
        @JsonProperty("feature_code") String featureCode,
        @JsonProperty("feature_name") String featureName,
        @JsonProperty("included_units") Long includedUnits,
        @JsonProperty("overage_rate") Long overageRate,
        @JsonProperty("credit_cost") Long creditCost,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
