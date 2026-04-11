package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Customer(
        @JsonProperty("id") String id,
        @JsonProperty("organization_id") String organizationId,
        @JsonProperty("external_id") String externalId,
        @JsonProperty("full_name") String fullName,
        @JsonProperty("domain") String domain,
        @JsonProperty("website") String website,
        @JsonProperty("billing_email") String billingEmail,
        @JsonProperty("timezone") String timezone,
        @JsonProperty("language") String language,
        @JsonProperty("industry") String industry,
        @JsonProperty("employee_count") String employeeCount,
        @JsonProperty("metadata") Map<String, Object> metadata,
        @JsonProperty("is_active") boolean isActive,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt
) {}
