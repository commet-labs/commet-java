package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionDiscount(
        @JsonProperty("type") DiscountType type,
        @JsonProperty("value") double value,
        @JsonProperty("name") String name,
        @JsonProperty("ends_at") String endsAt
) {}
