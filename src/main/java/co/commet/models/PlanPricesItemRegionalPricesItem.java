package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanPricesItemRegionalPricesItem(
        @JsonProperty("currency") String currency,
        @JsonProperty("price") long price,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("included_balance") Long includedBalance,
        @JsonProperty("auto_synced") boolean autoSynced
) {}
