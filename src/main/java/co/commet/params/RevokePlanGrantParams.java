package co.commet.params;

public final class RevokePlanGrantParams {

    private final String reason;
    private final String idempotencyKey;

    private RevokePlanGrantParams(Builder builder) {
        this.reason = builder.reason;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String reason) {
        return new Builder(reason);
    }

    public String getReason() { return reason; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String reason;
        private String idempotencyKey;

        private Builder(String reason) {
            this.reason = reason;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public RevokePlanGrantParams build() {
            return new RevokePlanGrantParams(this);
        }
    }
}
