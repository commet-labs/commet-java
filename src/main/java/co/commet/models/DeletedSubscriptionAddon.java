package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DeletedSubscriptionAddon(
        @JsonProperty("id") String id,
        @JsonProperty("status") String status,
        @JsonProperty("deactivated_at") String deactivatedAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
