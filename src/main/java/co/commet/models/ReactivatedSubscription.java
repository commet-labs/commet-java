package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReactivatedSubscription(
        @JsonProperty("id") String id,
        @JsonProperty("retry_initiated") boolean retryInitiated,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
