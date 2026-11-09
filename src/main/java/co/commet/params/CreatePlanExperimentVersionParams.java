package co.commet.params;

import co.commet.models.CreatePlanExperimentVersionParamsCurrenciesItem;
import co.commet.models.CreatePlanExperimentVersionParamsPricesItem;
import java.util.List;

public final class CreatePlanExperimentVersionParams {

    private final List<CreatePlanExperimentVersionParamsPricesItem> prices;
    private final List<CreatePlanExperimentVersionParamsCurrenciesItem> currencies;
    private final Long maxPlanCredits;
    private final Long maxPlanBalance;
    private final String idempotencyKey;

    private CreatePlanExperimentVersionParams(Builder builder) {
        this.prices = builder.prices;
        this.currencies = builder.currencies;
        this.maxPlanCredits = builder.maxPlanCredits;
        this.maxPlanBalance = builder.maxPlanBalance;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<CreatePlanExperimentVersionParamsPricesItem> getPrices() { return prices; }
    public List<CreatePlanExperimentVersionParamsCurrenciesItem> getCurrencies() { return currencies; }
    public Long getMaxPlanCredits() { return maxPlanCredits; }
    public Long getMaxPlanBalance() { return maxPlanBalance; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private List<CreatePlanExperimentVersionParamsPricesItem> prices;
        private List<CreatePlanExperimentVersionParamsCurrenciesItem> currencies;
        private Long maxPlanCredits;
        private Long maxPlanBalance;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder prices(List<CreatePlanExperimentVersionParamsPricesItem> prices) {
            this.prices = prices;
            return this;
        }

        public Builder currencies(List<CreatePlanExperimentVersionParamsCurrenciesItem> currencies) {
            this.currencies = currencies;
            return this;
        }

        public Builder maxPlanCredits(Long maxPlanCredits) {
            this.maxPlanCredits = maxPlanCredits;
            return this;
        }

        public Builder maxPlanBalance(Long maxPlanBalance) {
            this.maxPlanBalance = maxPlanBalance;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CreatePlanExperimentVersionParams build() {
            return new CreatePlanExperimentVersionParams(this);
        }
    }
}
