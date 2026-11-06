package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanVersionComparisonChangesItem(
        @JsonProperty("key") String key,
        @JsonProperty("section") String section,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("country") String country,
        @JsonProperty("label") String label,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("before") String before,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("after") String after
) {}
