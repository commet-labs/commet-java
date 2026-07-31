package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record PreviewChangeOfferApplicationPhasesItemVariant1(
        @JsonProperty("type") String type,
        @JsonProperty("duration_days") long durationDays,
        @JsonProperty("starts_at") String startsAt,
        @JsonProperty("ends_at") String endsAt
) implements PreviewChangeOfferApplicationPhasesItem {}
