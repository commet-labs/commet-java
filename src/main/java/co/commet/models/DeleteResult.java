package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DeleteResult(
        @JsonProperty("id") String id,
        @JsonProperty("deleted") boolean deleted
) {}
