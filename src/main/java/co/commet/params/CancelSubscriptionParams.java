package co.commet.params;

public final class CancelSubscriptionParams {

    private final String reason;
    private final Boolean immediate;
    private final String idempotencyKey;

    private CancelSubscriptionParams(Builder builder) {
        this.reason = builder.reason;
        this.immediate = builder.immediate;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getReason() { return reason; }
    public Boolean getImmediate() { return immediate; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String reason;
        private Boolean immediate;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder immediate(Boolean immediate) {
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
