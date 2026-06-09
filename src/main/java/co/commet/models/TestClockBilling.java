package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TestClockBilling(
        @JsonProperty("customers_found") long customersFound,
        @JsonProperty("enqueued") long enqueued,
        @JsonProperty("failed") long failed,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
