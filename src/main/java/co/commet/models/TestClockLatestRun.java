package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TestClockLatestRun(
        @JsonProperty("id") String id,
        @JsonProperty("status") String status,
        @JsonProperty("started_at_time") String startedAtTime,
        @JsonProperty("target_time") String targetTime,
        @JsonProperty("estimated_deadline_count") long estimatedDeadlineCount,
        @JsonProperty("completed_deadline_count") long completedDeadlineCount,
        @JsonProperty("failed_deadline_count") long failedDeadlineCount,
        @JsonProperty("error") String error,
        @JsonProperty("items") List<TestClockLatestRunItemsItem> items
) {}
