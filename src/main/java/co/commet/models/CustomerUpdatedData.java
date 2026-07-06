package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerUpdatedData(
        @JsonProperty("id") String id,
        @JsonProperty("externalId") String externalId,
        @JsonProperty("fullName") String fullName,
        @JsonProperty("email") String email,
        @JsonProperty("taxDocument") String taxDocument,
        @JsonProperty("documentType") String documentType,
        @JsonProperty("timezone") String timezone,
        @JsonProperty("metadata") Map<String, Object> metadata,
        @JsonProperty("createdAt") String createdAt,
        @JsonProperty("updatedAt") String updatedAt
) {}
