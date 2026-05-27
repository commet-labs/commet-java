package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DeactivateAddonResult(
        @JsonProperty("id") String id,
        @JsonProperty("status") String status,
        @JsonProperty("deactivated_at") String deactivatedAt
) {}
