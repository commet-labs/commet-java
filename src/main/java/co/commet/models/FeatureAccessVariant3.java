package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record FeatureAccessVariant3(
        @JsonProperty("code") String code,
        @JsonProperty("name") String name,
        @JsonProperty("unit_name") String unitName,
        @JsonProperty("allowed") boolean allowed,
        @JsonProperty("type") String type,
        @JsonProperty("usage") FeatureAccessVariant3Usage usage,
        @JsonProperty("base_access") FeatureAccessVariant3BaseAccess baseAccess,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) implements FeatureAccess {}
