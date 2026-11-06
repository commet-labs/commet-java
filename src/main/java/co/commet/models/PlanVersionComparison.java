package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanVersionComparison(
        @JsonProperty("version_id") String versionId,
        @JsonProperty("against_version_id") String againstVersionId,
        @JsonProperty("changes") List<PlanVersionComparisonChangesItem> changes,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
