package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UsageEvent(
        @JsonProperty("id") String id,
        @JsonProperty("organization_id") String organizationId,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("feature") String feature,
        @JsonProperty("idempotency_key") String idempotencyKey,
        @JsonProperty("ts") String ts,
        @JsonProperty("properties") List<UsageEventProperty> properties,
        @JsonProperty("created_at") String createdAt
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record UsageEventProperty(
            @JsonProperty("id") String id,
            @JsonProperty("usage_event_id") String usageEventId,
            @JsonProperty("property") String property,
            @JsonProperty("value") String value,
            @JsonProperty("created_at") String createdAt
    ) {}
}
