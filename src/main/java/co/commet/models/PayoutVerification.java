package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PayoutVerification(
        @JsonProperty("provider_account_id") String providerAccountId,
        @JsonProperty("status") String status,
        @JsonProperty("transfers_enabled") boolean transfersEnabled,
        @JsonProperty("already_exists") Boolean alreadyExists,
        @JsonProperty("business_type") String businessType,
        @JsonProperty("country") String country,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
