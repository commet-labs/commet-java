package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionAddon(
        @JsonProperty("addon_id") String addonId,
        @JsonProperty("status") String status,
        @JsonProperty("prorated_charge") long proratedCharge,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
