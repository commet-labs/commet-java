package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerBatchSuccessfulItem(
        @JsonProperty("id") String id,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("external_id") String externalId,
        @JsonProperty("email") String email
) {}
