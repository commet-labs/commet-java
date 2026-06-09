package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DeletedObject(
        @JsonProperty("id") String id,
        @JsonProperty("deleted") Object deleted,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
