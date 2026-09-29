package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanChangeVariant1OfferApplicationPhasesItemVariant1(
        @JsonProperty("type") String type,
        @JsonProperty("duration_days") long durationDays,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("starts_at") String startsAt,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("ends_at") String endsAt
) implements PlanChangeVariant1OfferApplicationPhasesItem {}
