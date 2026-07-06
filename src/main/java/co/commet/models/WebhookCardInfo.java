package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookCardInfo(
        @JsonProperty("brand") String brand,
        @JsonProperty("last4") String last4,
        @JsonProperty("exp_month") double expMonth,
        @JsonProperty("exp_year") double expYear
) {}
