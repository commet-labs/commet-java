package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionResume(
        @JsonProperty("subscription_id") String subscriptionId,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("invoice_id") String invoiceId,
        @JsonProperty("status") String status,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
