package co.commet.params;

public final class CreatePrepaidPeriodsCheckoutParams {

    private final long periods;
    private final String offerId;
    private final String successUrl;
    private final String idempotencyKey;

    private CreatePrepaidPeriodsCheckoutParams(Builder builder) {
        this.periods = builder.periods;
        this.offerId = builder.offerId;
        this.successUrl = builder.successUrl;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(long periods) {
        return new Builder(periods);
    }

    public long getPeriods() { return periods; }
    public String getOfferId() { return offerId; }
    public String getSuccessUrl() { return successUrl; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final long periods;
        private String offerId;
        private String successUrl;
        private String idempotencyKey;

        private Builder(long periods) {
            this.periods = periods;
        }

        public Builder offerId(String offerId) {
            this.offerId = offerId;
            return this;
        }

        public Builder successUrl(String successUrl) {
            this.successUrl = successUrl;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CreatePrepaidPeriodsCheckoutParams build() {
            return new CreatePrepaidPeriodsCheckoutParams(this);
        }
    }
}
