package co.commet.params;

public final class RequestPortalAccessParams {

    private final String email;
    private final String customerId;
    private final String idempotencyKey;

    private RequestPortalAccessParams(Builder builder) {
        this.email = builder.email;
        this.customerId = builder.customerId;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getEmail() { return email; }
    public String getCustomerId() { return customerId; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String email;
        private String customerId;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public RequestPortalAccessParams build() {
            return new RequestPortalAccessParams(this);
        }
    }
}
