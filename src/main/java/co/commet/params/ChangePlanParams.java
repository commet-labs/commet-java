package co.commet.params;

public final class ChangePlanParams {

    private final String newPlanId;
    private final String newBillingInterval;
    private final String successUrl;
    private final String idempotencyKey;

    private ChangePlanParams(Builder builder) {
        this.newPlanId = builder.newPlanId;
        this.newBillingInterval = builder.newBillingInterval;
        this.successUrl = builder.successUrl;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getNewPlanId() { return newPlanId; }
    public String getNewBillingInterval() { return newBillingInterval; }
    public String getSuccessUrl() { return successUrl; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String newPlanId;
        private String newBillingInterval;
        private String successUrl;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder newPlanId(String newPlanId) {
            this.newPlanId = newPlanId;
            return this;
        }

        public Builder newBillingInterval(String newBillingInterval) {
            this.newBillingInterval = newBillingInterval;
            return this;
        }

        public Builder successUrl(String successUrl) {
            this.successUrl = successUrl;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public ChangePlanParams build() {
            return new ChangePlanParams(this);
        }
    }
}
