package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DefaultPlanPrice(
        @JsonProperty("id") String id,
        @JsonProperty("is_default") Object isDefault,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
