package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionFeaturesItemVariant1(
        @JsonProperty("code") String code,
        @JsonProperty("name") String name,
        @JsonProperty("type") String type,
        @JsonProperty("enabled") boolean enabled,
        @JsonProperty("base_access") SubscriptionFeaturesItemVariant1BaseAccess baseAccess
) implements SubscriptionFeaturesItem {}
