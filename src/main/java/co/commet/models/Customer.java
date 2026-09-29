package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Customer(
        @JsonProperty("id") String id,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("external_id") String externalId,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("full_name") String fullName,
        @JsonProperty("email") String email,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("tax_document") String taxDocument,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("document_type") String documentType,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("timezone") String timezone,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("metadata") Map<String, Object> metadata,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
