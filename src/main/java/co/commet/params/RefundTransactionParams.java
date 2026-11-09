package co.commet.params;

public final class RefundTransactionParams {

    private final Long amount;
    private final String idempotencyKey;

    private RefundTransactionParams(Builder builder) {
        this.amount = builder.amount;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getAmount() { return amount; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private Long amount;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder amount(Long amount) {
            this.amount = amount;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public RefundTransactionParams build() {
            return new RefundTransactionParams(this);
        }
    }
}
