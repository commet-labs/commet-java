package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateApiKeyParamsPermissions(
        @JsonProperty("customer") List<String> customer,
        @JsonProperty("subscription") List<String> subscription,
        @JsonProperty("invoice") List<String> invoice,
        @JsonProperty("usage") List<String> usage,
        @JsonProperty("seat") List<String> seat,
        @JsonProperty("plan") List<String> plan,
        @JsonProperty("plan_group") List<String> planGroup,
        @JsonProperty("feature") List<String> feature,
        @JsonProperty("addon") List<String> addon,
        @JsonProperty("credit_pack") List<String> creditPack,
        @JsonProperty("offer") List<String> offer,
        @JsonProperty("promo_code") List<String> promoCode,
        @JsonProperty("market_group") List<String> marketGroup,
        @JsonProperty("payment") List<String> payment,
        @JsonProperty("transaction") List<String> transaction,
        @JsonProperty("payout") List<String> payout,
        @JsonProperty("test_clock") List<String> testClock,
        @JsonProperty("organization") List<String> organization,
        @JsonProperty("api_key") List<String> apiKey
) {}
