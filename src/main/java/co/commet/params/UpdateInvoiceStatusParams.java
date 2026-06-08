package co.commet.params;

public final class UpdateInvoiceStatusParams {

    private final String status;
    private final String idempotencyKey;

    private UpdateInvoiceStatusParams(Builder builder) {
        this.status = builder.status;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String status) {
        return new Builder(status);
    }

    public String getStatus() { return status; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String status;
        private String idempotencyKey;

        private Builder(String status) {
            this.status = status;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdateInvoiceStatusParams build() {
            return new UpdateInvoiceStatusParams(this);
        }
    }
}
