package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateOfferParamsPhasesItemVariant2(
        @JsonProperty("type") String type,
        @JsonProperty("duration_cycles") long durationCycles,
        @JsonProperty("percentage") long percentage
) implements UpdateOfferParamsPhasesItem {}
