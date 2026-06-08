package co.commet.params;

public final class AdjustBalanceParams {

    private final long amount;
    private final String reason;
    private final String type;
    private final String idempotencyKey;

    private AdjustBalanceParams(Builder builder) {
        this.amount = builder.amount;
        this.reason = builder.reason;
        this.type = builder.type;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(long amount) {
        return new Builder(amount);
    }

    public long getAmount() { return amount; }
    public String getReason() { return reason; }
    public String getType() { return type; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final long amount;
        private String reason;
        private String type;
        private String idempotencyKey;

        private Builder(long amount) {
            this.amount = amount;
        }

        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public AdjustBalanceParams build() {
            return new AdjustBalanceParams(this);
        }
    }
}
