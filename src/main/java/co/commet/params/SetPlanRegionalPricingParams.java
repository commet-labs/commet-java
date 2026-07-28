package co.commet.params;

import co.commet.models.SetPlanRegionalPricingParamsFeaturesItem;
import co.commet.models.SetPlanRegionalPricingParamsPricesItem;
import java.util.List;

public final class SetPlanRegionalPricingParams {

    private final String currency;
    private final double exchangeRate;
    private final List<SetPlanRegionalPricingParamsPricesItem> prices;
    private final List<SetPlanRegionalPricingParamsFeaturesItem> features;
    private final String idempotencyKey;

    private SetPlanRegionalPricingParams(Builder builder) {
        this.currency = builder.currency;
        this.exchangeRate = builder.exchangeRate;
        this.prices = builder.prices;
        this.features = builder.features;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String currency, double exchangeRate) {
        return new Builder(currency, exchangeRate);
    }

    public String getCurrency() { return currency; }
    public double getExchangeRate() { return exchangeRate; }
    public List<SetPlanRegionalPricingParamsPricesItem> getPrices() { return prices; }
    public List<SetPlanRegionalPricingParamsFeaturesItem> getFeatures() { return features; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String currency;
        private final double exchangeRate;
        private List<SetPlanRegionalPricingParamsPricesItem> prices;
        private List<SetPlanRegionalPricingParamsFeaturesItem> features;
        private String idempotencyKey;

        private Builder(String currency, double exchangeRate) {
            this.currency = currency;
            this.exchangeRate = exchangeRate;
        }

        public Builder prices(List<SetPlanRegionalPricingParamsPricesItem> prices) {
            this.prices = prices;
            return this;
        }

        public Builder features(List<SetPlanRegionalPricingParamsFeaturesItem> features) {
            this.features = features;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public SetPlanRegionalPricingParams build() {
            return new SetPlanRegionalPricingParams(this);
        }
    }
}
