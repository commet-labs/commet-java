package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookCreditsBalance(
        @JsonProperty("planCredits") double planCredits,
        @JsonProperty("purchasedCredits") double purchasedCredits,
        @JsonProperty("totalCredits") double totalCredits
) {}
