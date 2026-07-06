package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookBankRef(
        @JsonProperty("bank_name") String bankName,
        @JsonProperty("last4") String last4
) {}
