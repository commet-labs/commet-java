package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreditPackDetail(
        @JsonProperty("id") String id,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("credits") int credits,
        @JsonProperty("price") Long price,
        @JsonProperty("is_active") boolean isActive,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt
) {}
