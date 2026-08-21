package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TestClockRunItemsItem(
        @JsonProperty("kind") String kind,
        @JsonProperty("status") String status,
        @JsonProperty("due_at") String dueAt,
        @JsonProperty("subscription_id") String subscriptionId,
        @JsonProperty("customer_name") String customerName,
        @JsonProperty("invoice_number") String invoiceNumber,
        @JsonProperty("invoice_id") String invoiceId,
        @JsonProperty("outcome") String outcome,
        @JsonProperty("detail") String detail,
        @JsonProperty("error") String error
) {}
