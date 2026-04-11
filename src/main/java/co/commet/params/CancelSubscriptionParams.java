package co.commet.params;

public final class CancelSubscriptionParams {

    private final String subscriptionId;
    private final String reason;
    private final Boolean immediate;
    private final String idempotencyKey;

    private CancelSubscriptionParams(Builder builder) {
        this.subscriptionId = builder.subscriptionId;
        this.reason = builder.reason;
        this.immediate = builder.immediate;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String subscriptionId) {
        return new Builder(subscriptionId);
    }

    public String getSubscriptionId() { return subscriptionId; }
    public String getReason() { return reason; }
    public Boolean getImmediate() { return immediate; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String subscriptionId;
        private String reason;
        private Boolean immediate;
        private String idempotencyKey;

        private Builder(String subscriptionId) {
            this.subscriptionId = subscriptionId;
        }

        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder immediate(boolean immediate) {
            this.immediate = immediate;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CancelSubscriptionParams build() {
            return new CancelSubscriptionParams(this);
        }
    }
}
