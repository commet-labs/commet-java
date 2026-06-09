package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BatchCreateCustomersParamsCustomersItem(
        @JsonProperty("email") String email,
        @JsonProperty("id") String id,
        @JsonProperty("external_id") String externalId,
        @JsonProperty("full_name") String fullName,
        @JsonProperty("timezone") Timezone timezone,
        @JsonProperty("metadata") Map<String, Object> metadata,
        @JsonProperty("address") BatchCreateCustomersParamsCustomersItemAddress address
) {}
