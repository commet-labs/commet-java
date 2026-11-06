package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BusinessTaxId(
        @JsonProperty("country") String country,
        @JsonProperty("type") String type,
        @JsonProperty("value") String value
) {}
