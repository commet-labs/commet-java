package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookCreditsBalance(
        @JsonProperty("unlimited") boolean unlimited,
        @JsonProperty("plan_credits") Double planCredits,
        @JsonProperty("purchased_credits") double purchasedCredits,
        @JsonProperty("total_credits") Double totalCredits
) {}
