package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UsageRecordedData(
        @JsonProperty("usageEventId") String usageEventId,
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("featureCode") String featureCode,
        @JsonProperty("value") double value,
        @JsonProperty("ts") String ts
) {}
