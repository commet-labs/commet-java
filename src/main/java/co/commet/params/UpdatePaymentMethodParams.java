package co.commet.params;

public final class UpdatePaymentMethodParams {

    private final String successUrl;
    private final String idempotencyKey;

    private UpdatePaymentMethodParams(Builder builder) {
        this.successUrl = builder.successUrl;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getSuccessUrl() { return successUrl; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String successUrl;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder successUrl(String successUrl) {
            this.successUrl = successUrl;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdatePaymentMethodParams build() {
            return new UpdatePaymentMethodParams(this);
        }
    }
}
