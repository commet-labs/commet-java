package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateCustomerParamsAddress(
        @JsonProperty("line1") String line1,
        @JsonProperty("line2") String line2,
        @JsonProperty("city") String city,
        @JsonProperty("state") String state,
        @JsonProperty("postal_code") String postalCode,
        @JsonProperty("country") String country,
        @JsonProperty("region") String region
) {}
