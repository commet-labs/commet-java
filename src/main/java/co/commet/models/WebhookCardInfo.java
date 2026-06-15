package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookCardInfo(
        @JsonProperty("brand") String brand,
        @JsonProperty("last4") String last4,
        @JsonProperty("expMonth") long expMonth,
        @JsonProperty("expYear") long expYear
) {}
