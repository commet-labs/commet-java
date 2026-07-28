package co.commet.params;

public final class ReactivateSubscriptionParams {

    private final String offerId;
    private final String idempotencyKey;

    private ReactivateSubscriptionParams(Builder builder) {
        this.offerId = builder.offerId;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getOfferId() { return offerId; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String offerId;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder offerId(String offerId) {
            this.offerId = offerId;
            return this;
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
