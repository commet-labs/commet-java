package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ActiveAddon(
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode,
        @JsonProperty("slug") String slug,
        @JsonProperty("name") String name,
        @JsonProperty("base_price") Long basePrice,
        @JsonProperty("feature_code") String featureCode,
        @JsonProperty("feature_name") String featureName,
        @JsonProperty("feature_type") FeatureType featureType,
        @JsonProperty("consumption_model") AddonConsumptionModel consumptionModel,
        @JsonProperty("activated_at") String activatedAt
) {}
