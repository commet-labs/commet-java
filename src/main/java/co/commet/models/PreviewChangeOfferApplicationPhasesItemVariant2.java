package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record PreviewChangeOfferApplicationPhasesItemVariant2(
        @JsonProperty("type") String type,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("duration_cycles") Long durationCycles,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("duration_interval") String durationInterval,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("starts_at") String startsAt,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("ends_at") String endsAt,
        @JsonProperty("percentage") long percentage
) implements PreviewChangeOfferApplicationPhasesItem {}
