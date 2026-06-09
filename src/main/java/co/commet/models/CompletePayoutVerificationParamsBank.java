package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CompletePayoutVerificationParamsBank(
        @JsonProperty("account_number") String accountNumber,
        @JsonProperty("account_holder_name") String accountHolderName,
        @JsonProperty("routing_number") String routingNumber,
        @JsonProperty("account_type") String accountType
) {}
