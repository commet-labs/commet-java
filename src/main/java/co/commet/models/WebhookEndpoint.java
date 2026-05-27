package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookEndpoint(
        @JsonProperty("id") String id,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode,
        @JsonProperty("url") String url,
        @JsonProperty("events") List<String> events,
        @JsonProperty("description") String description,
        @JsonProperty("is_active") boolean isActive,
        @JsonProperty("secret_key") String secretKey,
        @JsonProperty("created_at") String createdAt
) {}
