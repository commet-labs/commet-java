package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CompletePayoutVerificationParamsCompany(
        @JsonProperty("name") String name,
        @JsonProperty("tax_id") String taxId,
        @JsonProperty("address") CompletePayoutVerificationParamsCompanyAddress address,
        @JsonProperty("representative") CompletePayoutVerificationParamsCompanyRepresentative representative
) {}
