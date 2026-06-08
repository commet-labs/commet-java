package co.commet.params;

import co.commet.models.AddPlanPriceParamsIntroOffer;
import co.commet.models.BillingInterval;

public final class AddPlanPriceParams {

    private final BillingInterval billingInterval;
    private final long price;
    private final Long trialDays;
    private final Boolean isDefault;
    private final Long includedBalance;
    private final Long includedCredits;
    private final AddPlanPriceParamsIntroOffer introOffer;
    private final String idempotencyKey;

    private AddPlanPriceParams(Builder builder) {
        this.billingInterval = builder.billingInterval;
        this.price = builder.price;
        this.trialDays = builder.trialDays;
        this.isDefault = builder.isDefault;
        this.includedBalance = builder.includedBalance;
        this.includedCredits = builder.includedCredits;
        this.introOffer = builder.introOffer;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(BillingInterval billingInterval, long price) {
        return new Builder(billingInterval, price);
    }

    public BillingInterval getBillingInterval() { return billingInterval; }
    public long getPrice() { return price; }
    public Long getTrialDays() { return trialDays; }
    public Boolean getIsDefault() { return isDefault; }
    public Long getIncludedBalance() { return includedBalance; }
    public Long getIncludedCredits() { return includedCredits; }
    public AddPlanPriceParamsIntroOffer getIntroOffer() { return introOffer; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final BillingInterval billingInterval;
        private final long price;
        private Long trialDays;
        private Boolean isDefault;
        private Long includedBalance;
        private Long includedCredits;
        private AddPlanPriceParamsIntroOffer introOffer;
        private String idempotencyKey;

        private Builder(BillingInterval billingInterval, long price) {
            this.billingInterval = billingInterval;
            this.price = price;
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

        public Builder introOffer(AddPlanPriceParamsIntroOffer introOffer) {
            this.introOffer = introOffer;
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
