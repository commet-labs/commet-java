package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatePlanParamsPlanCreditLimit(
        @JsonProperty("credits") long credits,
        @JsonProperty("interval") String interval
) {}
