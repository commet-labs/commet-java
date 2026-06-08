package co.commet.params;

public final class RemoveQuotaParams {

    private final String featureCode;
    private final String customerId;
    private final String externalId;
    private final Long count;
    private final String idempotencyKey;

    private RemoveQuotaParams(Builder builder) {
        this.featureCode = builder.featureCode;
        this.customerId = builder.customerId;
        this.externalId = builder.externalId;
        this.count = builder.count;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String featureCode) {
        return new Builder(featureCode);
    }

    public String getFeatureCode() { return featureCode; }
    public String getCustomerId() { return customerId; }
    public String getExternalId() { return externalId; }
    public Long getCount() { return count; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String featureCode;
        private String customerId;
        private String externalId;
        private Long count;
        private String idempotencyKey;

        private Builder(String featureCode) {
            this.featureCode = featureCode;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder externalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public Builder count(Long count) {
            this.count = count;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public RemoveQuotaParams build() {
            return new RemoveQuotaParams(this);
        }
    }
}
