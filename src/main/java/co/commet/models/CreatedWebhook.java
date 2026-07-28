package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreatedWebhook(
        @JsonProperty("id") String id,
        @JsonProperty("url") String url,
        @JsonProperty("events") List<String> events,
        @JsonProperty("description") String description,
        @JsonProperty("is_active") boolean isActive,
        @JsonProperty("api_version") String apiVersion,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("secret_key") String secretKey,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
