package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InvoiceDownloadResult(
        @JsonProperty("url") String url,
        @JsonProperty("expires_at") String expiresAt
) {}
