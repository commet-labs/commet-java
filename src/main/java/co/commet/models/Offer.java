package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Offer(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("purpose") String purpose,
        @JsonProperty("plan_price_ids") List<String> planPriceIds,
        @JsonProperty("phases") List<OfferPhasesItem> phases,
        @JsonProperty("metadata") Map<String, Object> metadata,
        @JsonProperty("starts_at") String startsAt,
        @JsonProperty("ends_at") String endsAt,
        @JsonProperty("active") boolean active,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
