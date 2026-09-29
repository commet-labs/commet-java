package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookBankRef(
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("bank_name") String bankName,
        @JsonProperty("last4") String last4
) {}
