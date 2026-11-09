package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanCountriesItemPricesItem(
        @JsonProperty("billing_interval") String billingIntervalAsString,
        @JsonProperty("price") long price,
        @JsonProperty("manual") boolean manual
) {

    public BillingInterval billingInterval() {
        return BillingInterval.fromValue(billingIntervalAsString);
    }
}
