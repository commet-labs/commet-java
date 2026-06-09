package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerBatchFailedItemData(
        @JsonProperty("id") String id,
        @JsonProperty("external_id") String externalId,
        @JsonProperty("email") String email,
        @JsonProperty("full_name") String fullName,
        @JsonProperty("timezone") String timezone,
        @JsonProperty("metadata") Map<String, Object> metadata,
        @JsonProperty("address") CustomerBatchFailedItemDataAddress address
) {}
