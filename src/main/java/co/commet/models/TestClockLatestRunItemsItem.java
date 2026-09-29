package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TestClockLatestRunItemsItem(
        @JsonProperty("kind") String kind,
        @JsonProperty("status") String status,
        @JsonProperty("due_at") String dueAt,
        @JsonProperty("subscription_id") String subscriptionId,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("customer_name") String customerName,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("invoice_number") String invoiceNumber,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("invoice_id") String invoiceId,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("outcome") String outcome,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("detail") String detail,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("error") String error
) {}
