package co.commet.params;

import co.commet.models.BillingInterval;

public final class PreviewChangePlanParams {

    private final String planId;
    private final BillingInterval billingInterval;
    private final String idempotencyKey;

    private PreviewChangePlanParams(Builder builder) {
        this.planId = builder.planId;
        this.billingInterval = builder.billingInterval;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String planId) {
        return new Builder(planId);
    }

    public String getPlanId() { return planId; }
    public BillingInterval getBillingInterval() { return billingInterval; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String planId;
        private BillingInterval billingInterval;
        private String idempotencyKey;

        private Builder(String planId) {
            this.planId = planId;
        }

        public Builder billingInterval(BillingInterval billingInterval) {
            this.billingInterval = billingInterval;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public PreviewChangePlanParams build() {
            return new PreviewChangePlanParams(this);
        }
    }
}
