package co.commet.params;

import co.commet.models.CreatePlanVersionParamsCurrenciesItem;
import co.commet.models.CreatePlanVersionParamsPricesItem;
import java.util.List;

public final class CreatePlanVersionParams {

    private final List<CreatePlanVersionParamsPricesItem> prices;
    private final List<CreatePlanVersionParamsCurrenciesItem> currencies;
    private final Long maxPlanCredits;
    private final Long maxPlanBalance;
    private final String idempotencyKey;

    private CreatePlanVersionParams(Builder builder) {
        this.prices = builder.prices;
        this.currencies = builder.currencies;
        this.maxPlanCredits = builder.maxPlanCredits;
        this.maxPlanBalance = builder.maxPlanBalance;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<CreatePlanVersionParamsPricesItem> getPrices() { return prices; }
    public List<CreatePlanVersionParamsCurrenciesItem> getCurrencies() { return currencies; }
    public Long getMaxPlanCredits() { return maxPlanCredits; }
    public Long getMaxPlanBalance() { return maxPlanBalance; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private List<CreatePlanVersionParamsPricesItem> prices;
        private List<CreatePlanVersionParamsCurrenciesItem> currencies;
        private Long maxPlanCredits;
        private Long maxPlanBalance;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder prices(List<CreatePlanVersionParamsPricesItem> prices) {
            this.prices = prices;
            return this;
        }

        public Builder currencies(List<CreatePlanVersionParamsCurrenciesItem> currencies) {
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

        public CreatePlanVersionParams build() {
            return new CreatePlanVersionParams(this);
        }
    }
}
