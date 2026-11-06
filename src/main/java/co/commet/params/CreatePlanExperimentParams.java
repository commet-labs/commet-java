package co.commet.params;

import co.commet.models.CreatePlanExperimentParamsCurrenciesItem;
import co.commet.models.CreatePlanExperimentParamsPricesItem;
import java.util.List;

public final class CreatePlanExperimentParams {

    private final String code;
    private final List<CreatePlanExperimentParamsPricesItem> prices;
    private final List<CreatePlanExperimentParamsCurrenciesItem> currencies;
    private final Long maxPlanCredits;
    private final Long maxPlanBalance;
    private final String idempotencyKey;

    private CreatePlanExperimentParams(Builder builder) {
        this.code = builder.code;
        this.prices = builder.prices;
        this.currencies = builder.currencies;
        this.maxPlanCredits = builder.maxPlanCredits;
        this.maxPlanBalance = builder.maxPlanBalance;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String code) {
        return new Builder(code);
    }

    public String getCode() { return code; }
    public List<CreatePlanExperimentParamsPricesItem> getPrices() { return prices; }
    public List<CreatePlanExperimentParamsCurrenciesItem> getCurrencies() { return currencies; }
    public Long getMaxPlanCredits() { return maxPlanCredits; }
    public Long getMaxPlanBalance() { return maxPlanBalance; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String code;
        private List<CreatePlanExperimentParamsPricesItem> prices;
        private List<CreatePlanExperimentParamsCurrenciesItem> currencies;
        private Long maxPlanCredits;
        private Long maxPlanBalance;
        private String idempotencyKey;

        private Builder(String code) {
            this.code = code;
        }

        public Builder prices(List<CreatePlanExperimentParamsPricesItem> prices) {
            this.prices = prices;
            return this;
        }

        public Builder currencies(List<CreatePlanExperimentParamsCurrenciesItem> currencies) {
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

        public CreatePlanExperimentParams build() {
            return new CreatePlanExperimentParams(this);
        }
    }
}
