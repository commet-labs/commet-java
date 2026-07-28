package co.commet.params;

public final class SetUsageParams {

    private final String customerId;
    private final String featureCode;
    private final long value;
    private final String reason;
    private final String idempotencyKey;

    private SetUsageParams(Builder builder) {
        this.customerId = builder.customerId;
        this.featureCode = builder.featureCode;
        this.value = builder.value;
        this.reason = builder.reason;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String customerId, String featureCode, long value) {
        return new Builder(customerId, featureCode, value);
    }

    public String getCustomerId() { return customerId; }
    public String getFeatureCode() { return featureCode; }
    public long getValue() { return value; }
    public String getReason() { return reason; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String customerId;
        private final String featureCode;
        private final long value;
        private String reason;
        private String idempotencyKey;

        private Builder(String customerId, String featureCode, long value) {
            this.customerId = customerId;
            this.featureCode = featureCode;
            this.value = value;
        }

        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public SetUsageParams build() {
            return new SetUsageParams(this);
        }
    }
}
