package co.commet.params;

public final class ApplySubscriptionOfferParams {

    private final String offerId;
    private final String expiresAt;
    private final String idempotencyKey;

    private ApplySubscriptionOfferParams(Builder builder) {
        this.offerId = builder.offerId;
        this.expiresAt = builder.expiresAt;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String offerId) {
        return new Builder(offerId);
    }

    public String getOfferId() { return offerId; }
    public String getExpiresAt() { return expiresAt; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String offerId;
        private String expiresAt;
        private String idempotencyKey;

        private Builder(String offerId) {
            this.offerId = offerId;
        }

        public Builder expiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public ApplySubscriptionOfferParams build() {
            return new ApplySubscriptionOfferParams(this);
        }
    }
}
