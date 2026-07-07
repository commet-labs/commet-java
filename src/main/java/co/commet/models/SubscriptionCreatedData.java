package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionCreatedData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("planId") String planId,
        @JsonProperty("planName") String planName,
        @JsonProperty("status") String status,
        @JsonProperty("startDate") String startDate,
        @JsonProperty("name") String name
) {}
