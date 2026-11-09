package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PreviewChangeDeactivatedAddonsItem(
        @JsonProperty("addon_id") String addonId,
        @JsonProperty("name") String name
) {}
