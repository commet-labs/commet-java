package co.commet.params;

import co.commet.models.AddPlanPriceParamsMarketPricesItem;
import java.util.List;
import java.util.Map;

public final class AddPlanPriceParams {

    private final String billingInterval;
    private final Map<String, Object> metadata;
    private final Long price;
    private final Long trialDays;
    private final Boolean isDefault;
    private final Long includedBalance;
    private final Long includedCredits;
    private final List<AddPlanPriceParamsMarketPricesItem> marketPrices;
    private final String inheritsFromPriceId;
    private final String idempotencyKey;

    private AddPlanPriceParams(Builder builder) {
        this.billingInterval = builder.billingInterval;
        this.metadata = builder.metadata;
        this.price = builder.price;
        this.trialDays = builder.trialDays;
        this.isDefault = builder.isDefault;
        this.includedBalance = builder.includedBalance;
        this.includedCredits = builder.includedCredits;
        this.marketPrices = builder.marketPrices;
        this.inheritsFromPriceId = builder.inheritsFromPriceId;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String billingInterval) {
        return new Builder(billingInterval);
    }

    public String getBillingInterval() { return billingInterval; }
    public Map<String, Object> getMetadata() { return metadata; }
    public Long getPrice() { return price; }
    public Long getTrialDays() { return trialDays; }
    public Boolean getIsDefault() { return isDefault; }
    public Long getIncludedBalance() { return includedBalance; }
    public Long getIncludedCredits() { return includedCredits; }
    public List<AddPlanPriceParamsMarketPricesItem> getMarketPrices() { return marketPrices; }
    public String getInheritsFromPriceId() { return inheritsFromPriceId; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String billingInterval;
        private Map<String, Object> metadata;
        private Long price;
        private Long trialDays;
        private Boolean isDefault;
        private Long includedBalance;
        private Long includedCredits;
        private List<AddPlanPriceParamsMarketPricesItem> marketPrices;
        private String inheritsFromPriceId;
        private String idempotencyKey;

        private Builder(String billingInterval) {
            this.billingInterval = billingInterval;
        }

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder price(Long price) {
            this.price = price;
            return this;
        }

        public Builder trialDays(Long trialDays) {
            this.trialDays = trialDays;
            return this;
        }

        public Builder isDefault(Boolean isDefault) {
            this.isDefault = isDefault;
            return this;
        }

        public Builder includedBalance(Long includedBalance) {
            this.includedBalance = includedBalance;
            return this;
        }

        public Builder includedCredits(Long includedCredits) {
            this.includedCredits = includedCredits;
            return this;
        }

        public Builder marketPrices(List<AddPlanPriceParamsMarketPricesItem> marketPrices) {
            this.marketPrices = marketPrices;
            return this;
        }

        public Builder inheritsFromPriceId(String inheritsFromPriceId) {
            this.inheritsFromPriceId = inheritsFromPriceId;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public AddPlanPriceParams build() {
            return new AddPlanPriceParams(this);
        }
    }
}
