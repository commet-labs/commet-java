package co.commet.params;

public final class ReactivateSubscriptionParams {

    private final String idempotencyKey;

    private ReactivateSubscriptionParams(Builder builder) {
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String idempotencyKey;

        private Builder() {
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public ReactivateSubscriptionParams build() {
            return new ReactivateSubscriptionParams(this);
        }
    }
}
