package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CompletePayoutVerificationParamsIndividual(
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("phone") String phone,
        @JsonProperty("date_of_birth") String dateOfBirth,
        @JsonProperty("ssn_last4") String ssnLast4,
        @JsonProperty("id_number") String idNumber,
        @JsonProperty("address") CompletePayoutVerificationParamsIndividualAddress address
) {}
