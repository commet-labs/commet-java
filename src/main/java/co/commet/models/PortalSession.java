package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PortalSession(
        @JsonProperty("success") boolean success,
        @JsonProperty("message") String message,
        @JsonProperty("portal_url") String portalUrl
) {}
