package co.commet.params;

public final class UpdateSubscriptionAutoTopUpParams {

    private final Boolean enabled;
    private final Long threshold;
    private final Long quantity;
    private final Long maxPerPeriod;
    private final String idempotencyKey;

    private UpdateSubscriptionAutoTopUpParams(Builder builder) {
        this.enabled = builder.enabled;
        this.threshold = builder.threshold;
        this.quantity = builder.quantity;
        this.maxPerPeriod = builder.maxPerPeriod;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Boolean getEnabled() { return enabled; }
    public Long getThreshold() { return threshold; }
    public Long getQuantity() { return quantity; }
    public Long getMaxPerPeriod() { return maxPerPeriod; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private Boolean enabled;
        private Long threshold;
        private Long quantity;
        private Long maxPerPeriod;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder threshold(Long threshold) {
            this.threshold = threshold;
            return this;
        }

        public Builder quantity(Long quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder maxPerPeriod(Long maxPerPeriod) {
            this.maxPerPeriod = maxPerPeriod;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdateSubscriptionAutoTopUpParams build() {
            return new UpdateSubscriptionAutoTopUpParams(this);
        }
    }
}
