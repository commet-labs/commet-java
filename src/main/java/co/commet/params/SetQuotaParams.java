package co.commet.params;

public final class SetQuotaParams {

    private final String featureCode;
    private final long count;
    private final String customerId;
    private final String externalId;
    private final String idempotencyKey;

    private SetQuotaParams(Builder builder) {
        this.featureCode = builder.featureCode;
        this.count = builder.count;
        this.customerId = builder.customerId;
        this.externalId = builder.externalId;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String featureCode, long count) {
        return new Builder(featureCode, count);
    }

    public String getFeatureCode() { return featureCode; }
    public long getCount() { return count; }
    public String getCustomerId() { return customerId; }
    public String getExternalId() { return externalId; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String featureCode;
        private final long count;
        private String customerId;
        private String externalId;
        private String idempotencyKey;

        private Builder(String featureCode, long count) {
            this.featureCode = featureCode;
            this.count = count;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder externalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public SetQuotaParams build() {
            return new SetQuotaParams(this);
        }
    }
}
