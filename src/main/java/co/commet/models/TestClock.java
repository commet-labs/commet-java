package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TestClock(
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("simulated_time") String simulatedTime,
        @JsonProperty("is_active") boolean isActive,
        @JsonProperty("now") String now,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("latest_run") TestClockLatestRun latestRun,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
