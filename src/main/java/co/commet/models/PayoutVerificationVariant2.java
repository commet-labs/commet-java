package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record PayoutVerificationVariant2(
        @JsonProperty("provider_account_id") String providerAccountId,
        @JsonProperty("status") String status,
        @JsonProperty("transfers_enabled") boolean transfersEnabled,
        @JsonProperty("outcome") String outcome,
        @JsonProperty("business_type") String businessType,
        @JsonProperty("country") String country,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) implements PayoutVerification {}
