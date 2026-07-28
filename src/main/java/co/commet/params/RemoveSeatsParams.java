package co.commet.params;

public final class RemoveSeatsParams {

    private final String customerId;
    private final String featureCode;
    private final long count;
    private final String idempotencyKey;

    private RemoveSeatsParams(Builder builder) {
        this.customerId = builder.customerId;
        this.featureCode = builder.featureCode;
        this.count = builder.count;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String customerId, String featureCode, long count) {
        return new Builder(customerId, featureCode, count);
    }

    public String getCustomerId() { return customerId; }
    public String getFeatureCode() { return featureCode; }
    public long getCount() { return count; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String customerId;
        private final String featureCode;
        private final long count;
        private String idempotencyKey;

        private Builder(String customerId, String featureCode, long count) {
            this.customerId = customerId;
            this.featureCode = featureCode;
            this.count = count;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public RemoveSeatsParams build() {
            return new RemoveSeatsParams(this);
        }
    }
}
