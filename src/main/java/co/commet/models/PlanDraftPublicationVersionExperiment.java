package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanDraftPublicationVersionExperiment(
        @JsonProperty("code") String code,
        @JsonProperty("version") long version
) {}
