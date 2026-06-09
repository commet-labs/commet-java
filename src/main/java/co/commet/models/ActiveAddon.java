package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ActiveAddon(
        @JsonProperty("slug") String slug,
        @JsonProperty("name") String name,
        @JsonProperty("base_price") long basePrice,
        @JsonProperty("feature_code") String featureCode,
        @JsonProperty("feature_name") String featureName,
        @JsonProperty("feature_type") FeatureType featureType,
        @JsonProperty("consumption_model") String consumptionModel,
        @JsonProperty("activated_at") String activatedAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
