package co.commet.params;

public final class ChangePlanParams {

    private final String subscriptionId;
    private final String newPlanId;
    private final String newBillingInterval;
    private final String idempotencyKey;

    private ChangePlanParams(Builder builder) {
        this.subscriptionId = builder.subscriptionId;
        this.newPlanId = builder.newPlanId;
        this.newBillingInterval = builder.newBillingInterval;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String subscriptionId, String newPlanId) {
        return new Builder(subscriptionId, newPlanId);
    }

    public String getSubscriptionId() { return subscriptionId; }
    public String getNewPlanId() { return newPlanId; }
    public String getNewBillingInterval() { return newBillingInterval; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String subscriptionId;
        private final String newPlanId;
        private String newBillingInterval;
        private String idempotencyKey;

        private Builder(String subscriptionId, String newPlanId) {
            this.subscriptionId = subscriptionId;
            this.newPlanId = newPlanId;
        }

        public Builder newBillingInterval(String newBillingInterval) {
            this.newBillingInterval = newBillingInterval;
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
