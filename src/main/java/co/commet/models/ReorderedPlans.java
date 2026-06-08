package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReorderedPlans(
        @JsonProperty("reordered") boolean reordered,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
