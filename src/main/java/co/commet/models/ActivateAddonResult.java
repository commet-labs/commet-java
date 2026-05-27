package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ActivateAddonResult(
        @JsonProperty("addon_id") String addonId,
        @JsonProperty("status") String status,
        @JsonProperty("prorated_charge") Long proratedCharge
) {}
