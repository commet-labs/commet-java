package co.commet.params;

public final class PreviewChangePlanParams {

    private final String planId;
    private final String billingInterval;
    private final String offerId;
    private final String idempotencyKey;

    private PreviewChangePlanParams(Builder builder) {
        this.planId = builder.planId;
        this.billingInterval = builder.billingInterval;
        this.offerId = builder.offerId;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String planId) {
        return new Builder(planId);
    }

    public String getPlanId() { return planId; }
    public String getBillingInterval() { return billingInterval; }
    public String getOfferId() { return offerId; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String planId;
        private String billingInterval;
        private String offerId;
        private String idempotencyKey;

        private Builder(String planId) {
            this.planId = planId;
        }

        public Builder billingInterval(String billingInterval) {
            this.billingInterval = billingInterval;
            return this;
        }

        public Builder offerId(String offerId) {
            this.offerId = offerId;
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
