package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Market(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("country_codes") List<String> countryCodes,
        @JsonProperty("metadata") Map<String, Object> metadata,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
