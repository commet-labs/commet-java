package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PayoutBankAccount(
        @JsonProperty("id") String id,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("provider_external_account_id") String providerExternalAccountId,
        @JsonProperty("holder_name") String holderName,
        @JsonProperty("last4") String last4,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("bank_name") String bankName,
        @JsonProperty("country") String country,
        @JsonProperty("currency") String currency,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("account_type") String accountType,
        @JsonProperty("is_default") boolean isDefault,
        @JsonProperty("status") String status,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
