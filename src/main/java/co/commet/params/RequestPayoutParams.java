package co.commet.params;

public final class RequestPayoutParams {

    private final long amount;
    private final String description;
    private final String idempotencyKey;

    private RequestPayoutParams(Builder builder) {
        this.amount = builder.amount;
        this.description = builder.description;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(long amount) {
        return new Builder(amount);
    }

    public long getAmount() { return amount; }
    public String getDescription() { return description; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final long amount;
        private String description;
        private String idempotencyKey;

        private Builder(long amount) {
            this.amount = amount;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public RequestPayoutParams build() {
            return new RequestPayoutParams(this);
        }
    }
}
