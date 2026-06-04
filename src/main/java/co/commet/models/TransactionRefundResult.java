package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransactionRefundResult(
        @JsonProperty("id") String id,
        // Always TransactionStatus.REFUNDED for this endpoint (full refund only).
        @JsonProperty("status") TransactionStatus status
) {}
