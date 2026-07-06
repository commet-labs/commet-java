package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record QuotaExceededData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("featureCode") String featureCode,
        @JsonProperty("currentUsage") double currentUsage,
        @JsonProperty("includedAmount") double includedAmount,
        @JsonProperty("overageEnabled") boolean overageEnabled,
        @JsonProperty("periodStart") String periodStart
) {}
