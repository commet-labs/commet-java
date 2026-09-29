package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionSummaryPauseVariant1(
        @JsonProperty("status") String status,
        @JsonProperty("mode") String mode,
        @JsonProperty("requested_at") String requestedAt,
        @JsonProperty("effective_at") String effectiveAt,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("resume_at") String resumeAt
) implements SubscriptionSummaryPause {}
