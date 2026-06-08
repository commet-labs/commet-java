package co.commet.params;

public final class TopupBalanceParams {

    private final long amount;
    private final String idempotencyKey;

    private TopupBalanceParams(Builder builder) {
        this.amount = builder.amount;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(long amount) {
        return new Builder(amount);
    }

    public long getAmount() { return amount; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final long amount;
        private String idempotencyKey;

        private Builder(long amount) {
            this.amount = amount;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public TopupBalanceParams build() {
            return new TopupBalanceParams(this);
        }
    }
}
