package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AddonActivatedData(
        @JsonProperty("subscriptionId") String subscriptionId,
        @JsonProperty("customerId") String customerId,
        @JsonProperty("addon") WebhookAddonRef addon,
        @JsonProperty("featureCode") String featureCode,
        @JsonProperty("proratedPrice") double proratedPrice,
        @JsonProperty("currency") String currency
) {}
