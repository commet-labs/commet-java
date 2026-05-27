package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FeatureDefinition(
        @JsonProperty("id") String id,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode,
        @JsonProperty("name") String name,
        @JsonProperty("code") String code,
        @JsonProperty("type") FeatureType type,
        @JsonProperty("description") String description,
        @JsonProperty("unit_name") String unitName,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt
) {}
