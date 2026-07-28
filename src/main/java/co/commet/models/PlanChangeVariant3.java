package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanChangeVariant3(
        @JsonProperty("outcome") String outcome,
        @JsonProperty("id") String id,
        @JsonProperty("scheduled") Object scheduled,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("previous_plan") PlanChangeVariant3PreviousPlan previousPlan,
        @JsonProperty("current_plan") PlanChangeVariant3CurrentPlan currentPlan,
        @JsonProperty("billing_interval") String billingInterval,
        @JsonProperty("billing") PlanChangeVariant3Billing billing,
        @JsonProperty("invoice_id") String invoiceId,
        @JsonProperty("offer_application") PlanChangeVariant3OfferApplication offerApplication,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) implements PlanChange {}
