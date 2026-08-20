package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionFeaturesItemVariant2(
        @JsonProperty("code") String code,
        @JsonProperty("name") String name,
        @JsonProperty("type") String type,
        @JsonProperty("usage") SubscriptionFeaturesItemVariant2Usage usage,
        @JsonProperty("base_access") SubscriptionFeaturesItemVariant2BaseAccess baseAccess
) implements SubscriptionFeaturesItem {}
