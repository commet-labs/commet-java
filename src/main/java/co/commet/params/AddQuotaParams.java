package co.commet.params;

public final class AddQuotaParams {

    private final String featureCode;
    private final Long count;
    private final String customerId;
    private final String externalId;
    private final String idempotencyKey;

    private AddQuotaParams(Builder builder) {
        this.featureCode = builder.featureCode;
        this.count = builder.count;
        this.customerId = builder.customerId;
        this.externalId = builder.externalId;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String featureCode) {
        return new Builder(featureCode);
    }

    public String getFeatureCode() { return featureCode; }
    public Long getCount() { return count; }
    public String getCustomerId() { return customerId; }
    public String getExternalId() { return externalId; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String featureCode;
        private Long count;
        private String customerId;
        private String externalId;
        private String idempotencyKey;

        private Builder(String featureCode) {
            this.featureCode = featureCode;
        }

        public Builder count(Long count) {
            this.count = count;
            return this;
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

        public AddQuotaParams build() {
            return new AddQuotaParams(this);
        }
    }
}
