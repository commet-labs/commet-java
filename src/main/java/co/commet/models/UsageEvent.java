package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UsageEvent(
        @JsonProperty("id") String id,
        @JsonProperty("feature_code") String featureCode,
        @JsonProperty("value") double value,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("event_id") String eventId,
        @JsonProperty("ts") String ts,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("properties") List<UsageEventPropertiesItem> properties,
        @JsonProperty("consumption") UsageEventConsumption consumption,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
