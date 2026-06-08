package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PortalAccess(
        @JsonProperty("portal_url") String portalUrl,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
