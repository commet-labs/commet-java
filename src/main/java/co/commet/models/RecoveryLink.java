package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RecoveryLink(
        @JsonProperty("url") String url,
        @JsonProperty("token") String token,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
