package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Addon(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("price") Long price,
        @JsonProperty("currency") Currency currency,
        @JsonProperty("billing_interval") BillingInterval billingInterval,
        @JsonProperty("status") String status,
        @JsonProperty("created_at") String createdAt
) {}
