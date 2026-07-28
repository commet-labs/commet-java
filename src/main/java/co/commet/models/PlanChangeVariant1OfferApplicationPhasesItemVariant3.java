package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanChangeVariant1OfferApplicationPhasesItemVariant3(
        @JsonProperty("type") String type,
        @JsonProperty("duration_cycles") long durationCycles,
        @JsonProperty("starts_at") String startsAt,
        @JsonProperty("ends_at") String endsAt,
        @JsonProperty("price") long price
) implements PlanChangeVariant1OfferApplicationPhasesItem {}
