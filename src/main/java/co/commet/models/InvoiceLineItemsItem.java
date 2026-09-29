package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InvoiceLineItemsItem(
        @JsonProperty("line_type") String lineType,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("feature_name") String featureName,
        @JsonProperty("description") String description,
        @JsonProperty("quantity") long quantity,
        @JsonProperty("unit_amount") long unitAmount,
        @JsonProperty("amount") long amount,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("included_amount") Long includedAmount,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("used_amount") Long usedAmount,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("overage_amount") Long overageAmount,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("discount_type") String discountType,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("discount_value") Long discountValue,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("discount_name") String discountName,
        @JsonProperty("charge_type") String chargeType
) {}
