package co.commet.params;

public final class CheckUsageAvailabilityParams {

    private final String customerId;
    private final String featureCode;
    private final Long quantity;
    private final String idempotencyKey;

    private CheckUsageAvailabilityParams(Builder builder) {
        this.customerId = builder.customerId;
        this.featureCode = builder.featureCode;
        this.quantity = builder.quantity;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String customerId, String featureCode) {
        return new Builder(customerId, featureCode);
    }

    public String getCustomerId() { return customerId; }
    public String getFeatureCode() { return featureCode; }
    public Long getQuantity() { return quantity; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String customerId;
        private final String featureCode;
        private Long quantity;
        private String idempotencyKey;

        private Builder(String customerId, String featureCode) {
            this.customerId = customerId;
            this.featureCode = featureCode;
        }

        public Builder quantity(Long quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CheckUsageAvailabilityParams build() {
            return new CheckUsageAvailabilityParams(this);
        }
    }
}
