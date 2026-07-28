package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReactivatedSubscription(
        @JsonProperty("subscription_id") String subscriptionId,
        @JsonProperty("invoice_id") String invoiceId,
        @JsonProperty("status") String status,
        @JsonProperty("offer_application") ReactivatedSubscriptionOfferApplication offerApplication,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
