package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Addon(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("slug") String slug,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("description") String description,
        @JsonProperty("base_price") long basePrice,
        @JsonProperty("feature_code") String featureCode,
        @JsonProperty("feature_name") String featureName,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("consumption_model") String consumptionModel,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("included_units") Long includedUnits,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("overage_rate") Long overageRate,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("credit_cost") Long creditCost,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
