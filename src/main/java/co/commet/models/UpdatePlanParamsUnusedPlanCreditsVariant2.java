package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdatePlanParamsUnusedPlanCreditsVariant2(
        @JsonProperty("type") String type,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("max_plan_credits") Long maxPlanCredits
) implements UpdatePlanParamsUnusedPlanCredits {}
