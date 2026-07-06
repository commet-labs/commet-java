package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookCreditsBalance(
        @JsonProperty("plan_credits") double planCredits,
        @JsonProperty("purchased_credits") double purchasedCredits,
        @JsonProperty("total_credits") double totalCredits
) {}
