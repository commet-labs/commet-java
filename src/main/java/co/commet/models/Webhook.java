package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Webhook(
        @JsonProperty("id") String id,
        @JsonProperty("url") String url,
        @JsonProperty("events") List<String> events,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("description") String description,
        @JsonProperty("is_active") boolean isActive,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("api_version") String apiVersion,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
