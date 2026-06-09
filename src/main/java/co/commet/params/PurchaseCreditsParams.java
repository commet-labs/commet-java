package co.commet.params;

public final class PurchaseCreditsParams {

    private final String creditPackId;
    private final String idempotencyKey;

    private PurchaseCreditsParams(Builder builder) {
        this.creditPackId = builder.creditPackId;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String creditPackId) {
        return new Builder(creditPackId);
    }

    public String getCreditPackId() { return creditPackId; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String creditPackId;
        private String idempotencyKey;

        private Builder(String creditPackId) {
            this.creditPackId = creditPackId;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public PurchaseCreditsParams build() {
            return new PurchaseCreditsParams(this);
        }
    }
}
