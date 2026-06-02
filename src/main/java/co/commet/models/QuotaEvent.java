package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record QuotaEvent(
        @JsonProperty("id") String id,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("featureCode") String featureCode,
        @JsonProperty("previousBalance") int previousBalance,
        @JsonProperty("newBalance") int newBalance,
        @JsonProperty("ts") String ts,
        @JsonProperty("createdAt") String createdAt
) {}
