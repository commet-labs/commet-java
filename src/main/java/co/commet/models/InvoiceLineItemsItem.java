package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InvoiceLineItemsItem(
        @JsonProperty("line_type") String lineType,
        @JsonProperty("feature_name") String featureName,
        @JsonProperty("description") String description,
        @JsonProperty("quantity") long quantity,
        @JsonProperty("unit_amount") long unitAmount,
        @JsonProperty("amount") long amount,
        @JsonProperty("included_amount") Long includedAmount,
        @JsonProperty("used_amount") Long usedAmount,
        @JsonProperty("overage_amount") Long overageAmount,
        @JsonProperty("discount_type") String discountType,
        @JsonProperty("discount_value") Long discountValue,
        @JsonProperty("discount_name") String discountName,
        @JsonProperty("charge_type") String chargeType
) {}
