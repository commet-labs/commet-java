package co.commet.params;

public final class CreateCustomerCreditParams {

    private final long amount;
    private final String currency;
    private final String reason;
    private final String expiresAt;
    private final String idempotencyKey;

    private CreateCustomerCreditParams(Builder builder) {
        this.amount = builder.amount;
        this.currency = builder.currency;
        this.reason = builder.reason;
        this.expiresAt = builder.expiresAt;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(long amount, String currency, String reason) {
        return new Builder(amount, currency, reason);
    }

    public long getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getReason() { return reason; }
    public String getExpiresAt() { return expiresAt; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final long amount;
        private final String currency;
        private final String reason;
        private String expiresAt;
        private String idempotencyKey;

        private Builder(long amount, String currency, String reason) {
            this.amount = amount;
            this.currency = currency;
            this.reason = reason;
        }

        public Builder expiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CreateCustomerCreditParams build() {
            return new CreateCustomerCreditParams(this);
        }
    }
}
