package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InvoiceStatusResult(
        @JsonProperty("id") String id,
        // Restricted to InvoiceStatus.PAID or InvoiceStatus.VOID for this endpoint.
        @JsonProperty("status") InvoiceStatus status,
        @JsonProperty("updated_at") String updatedAt
) {}
