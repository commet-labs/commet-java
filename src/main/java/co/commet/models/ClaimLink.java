package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ClaimLink(
        @JsonProperty("url") String url,
        @JsonProperty("expires_at") String expiresAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
