package co.commet.params;

public final class PurchaseCreditsParams {

    private final String creditPackId;
    private final Long quantity;
    private final String idempotencyKey;

    private PurchaseCreditsParams(Builder builder) {
        this.creditPackId = builder.creditPackId;
        this.quantity = builder.quantity;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCreditPackId() { return creditPackId; }
    public Long getQuantity() { return quantity; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String creditPackId;
        private Long quantity;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder creditPackId(String creditPackId) {
            this.creditPackId = creditPackId;
            return this;
        }

        public Builder quantity(Long quantity) {
            this.quantity = quantity;
            return this;
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
