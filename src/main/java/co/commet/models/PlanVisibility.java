package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanVisibility(
        @JsonProperty("id") String id,
        @JsonProperty("is_public") boolean isPublic,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
