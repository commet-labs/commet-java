package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanCountriesItemCreditPacksItem(
        @JsonProperty("credit_pack_id") String creditPackId,
        @JsonProperty("price") long price,
        @JsonProperty("manual") boolean manual
) {}
