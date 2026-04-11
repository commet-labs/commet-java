package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FeatureAccess(
        @JsonProperty("allowed") boolean allowed,
        @JsonProperty("will_be_charged") Boolean willBeCharged,
        @JsonProperty("reason") String reason
) {}
