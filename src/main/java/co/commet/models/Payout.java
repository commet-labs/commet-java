package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Payout(
        @JsonProperty("id") String id,
        @JsonProperty("status") String status,
        @JsonProperty("amount") long amount,
        @JsonProperty("fee") long fee,
        @JsonProperty("net_amount") long netAmount,
        @JsonProperty("currency") String currency,
        @JsonProperty("description") String description,
        @JsonProperty("provider_transfer_id") String providerTransferId,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
