package co.commet.params;

import co.commet.models.UpdatePlanPriceParamsIntroOffer;

public final class UpdatePlanPriceParams {

    private final Long price;
    private final Boolean isDefault;
    private final Long trialDays;
    private final Long includedBalance;
    private final Long includedCredits;
    private final UpdatePlanPriceParamsIntroOffer introOffer;
    private final String idempotencyKey;

    private UpdatePlanPriceParams(Builder builder) {
        this.price = builder.price;
        this.isDefault = builder.isDefault;
        this.trialDays = builder.trialDays;
        this.includedBalance = builder.includedBalance;
        this.includedCredits = builder.includedCredits;
        this.introOffer = builder.introOffer;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getPrice() { return price; }
    public Boolean getIsDefault() { return isDefault; }
    public Long getTrialDays() { return trialDays; }
    public Long getIncludedBalance() { return includedBalance; }
    public Long getIncludedCredits() { return includedCredits; }
    public UpdatePlanPriceParamsIntroOffer getIntroOffer() { return introOffer; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private Long price;
        private Boolean isDefault;
        private Long trialDays;
        private Long includedBalance;
        private Long includedCredits;
        private UpdatePlanPriceParamsIntroOffer introOffer;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder price(Long price) {
            this.price = price;
            return this;
        }

        public Builder isDefault(Boolean isDefault) {
            this.isDefault = isDefault;
            return this;
        }

        public Builder trialDays(Long trialDays) {
            this.trialDays = trialDays;
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

        public Builder introOffer(UpdatePlanPriceParamsIntroOffer introOffer) {
            this.introOffer = introOffer;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdatePlanPriceParams build() {
            return new UpdatePlanPriceParams(this);
        }
    }
}
