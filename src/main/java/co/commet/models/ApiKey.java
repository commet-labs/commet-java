package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiKey(
        @JsonProperty("id") String id,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode,
        @JsonProperty("name") String name,
        @JsonProperty("prefix") String prefix,
        @JsonProperty("api_key") String apiKey,
        @JsonProperty("expires_at") String expiresAt,
        @JsonProperty("last_used_at") String lastUsedAt,
        @JsonProperty("created_at") String createdAt
) {}
