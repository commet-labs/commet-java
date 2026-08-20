package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateOfferParamsPhasesItemVariant2(
        @JsonProperty("type") String type,
        @JsonProperty("duration_cycles") Long durationCycles,
        @JsonProperty("duration_interval") String durationInterval,
        @JsonProperty("percentage") long percentage
) implements CreateOfferParamsPhasesItem {}
