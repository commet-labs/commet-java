package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatedSubscriptionPlan(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name
) {}
