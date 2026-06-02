package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record QuotaEvent(
        @JsonProperty("id") String id,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("feature_code") String featureCode,
        @JsonProperty("previous_balance") int previousBalance,
        @JsonProperty("new_balance") int newBalance,
        @JsonProperty("ts") String ts,
        @JsonProperty("created_at") String createdAt
) {}
