package co.commet.params;

import co.commet.models.AddPlanFeatureParamsOverage;

public final class AddPlanFeatureParams {

    private final String featureId;
    private final Boolean enabled;
    private final Long includedAmount;
    private final Boolean unlimited;
    private final AddPlanFeatureParamsOverage overage;
    private final Long creditsPerUnit;
    private final String pricingMode;
    private final Long margin;
    private final String idempotencyKey;

    private AddPlanFeatureParams(Builder builder) {
        this.featureId = builder.featureId;
        this.enabled = builder.enabled;
        this.includedAmount = builder.includedAmount;
        this.unlimited = builder.unlimited;
        this.overage = builder.overage;
        this.creditsPerUnit = builder.creditsPerUnit;
        this.pricingMode = builder.pricingMode;
        this.margin = builder.margin;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String featureId) {
        return new Builder(featureId);
    }

    public String getFeatureId() { return featureId; }
    public Boolean getEnabled() { return enabled; }
    public Long getIncludedAmount() { return includedAmount; }
    public Boolean getUnlimited() { return unlimited; }
    public AddPlanFeatureParamsOverage getOverage() { return overage; }
    public Long getCreditsPerUnit() { return creditsPerUnit; }
    public String getPricingMode() { return pricingMode; }
    public Long getMargin() { return margin; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String featureId;
        private Boolean enabled;
        private Long includedAmount;
        private Boolean unlimited;
        private AddPlanFeatureParamsOverage overage;
        private Long creditsPerUnit;
        private String pricingMode;
        private Long margin;
        private String idempotencyKey;

        private Builder(String featureId) {
            this.featureId = featureId;
        }

        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder includedAmount(Long includedAmount) {
            this.includedAmount = includedAmount;
            return this;
        }

        public Builder unlimited(Boolean unlimited) {
            this.unlimited = unlimited;
            return this;
        }

        public Builder overage(AddPlanFeatureParamsOverage overage) {
            this.overage = overage;
            return this;
        }

        public Builder creditsPerUnit(Long creditsPerUnit) {
            this.creditsPerUnit = creditsPerUnit;
            return this;
        }

        public Builder pricingMode(String pricingMode) {
            this.pricingMode = pricingMode;
            return this;
        }

        public Builder margin(Long margin) {
            this.margin = margin;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public AddPlanFeatureParams build() {
            return new AddPlanFeatureParams(this);
        }
    }
}
