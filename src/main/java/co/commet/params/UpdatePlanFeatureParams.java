package co.commet.params;

import co.commet.models.UpdatePlanFeatureParamsOverage;

public final class UpdatePlanFeatureParams {

    private final Boolean enabled;
    private final Long includedAmount;
    private final Boolean unlimited;
    private final UpdatePlanFeatureParamsOverage overage;
    private final Long creditsPerUnit;
    private final String idempotencyKey;

    private UpdatePlanFeatureParams(Builder builder) {
        this.enabled = builder.enabled;
        this.includedAmount = builder.includedAmount;
        this.unlimited = builder.unlimited;
        this.overage = builder.overage;
        this.creditsPerUnit = builder.creditsPerUnit;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Boolean getEnabled() { return enabled; }
    public Long getIncludedAmount() { return includedAmount; }
    public Boolean getUnlimited() { return unlimited; }
    public UpdatePlanFeatureParamsOverage getOverage() { return overage; }
    public Long getCreditsPerUnit() { return creditsPerUnit; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private Boolean enabled;
        private Long includedAmount;
        private Boolean unlimited;
        private UpdatePlanFeatureParamsOverage overage;
        private Long creditsPerUnit;
        private String idempotencyKey;

        private Builder() {
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

        public Builder overage(UpdatePlanFeatureParamsOverage overage) {
            this.overage = overage;
            return this;
        }

        public Builder creditsPerUnit(Long creditsPerUnit) {
            this.creditsPerUnit = creditsPerUnit;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdatePlanFeatureParams build() {
            return new UpdatePlanFeatureParams(this);
        }
    }
}
