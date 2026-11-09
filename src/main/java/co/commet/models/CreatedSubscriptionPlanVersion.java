package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatedSubscriptionPlanVersion(
        @JsonProperty("id") String id,
        @JsonProperty("label") String label
) {}
