package co.commet.params;

import java.util.Map;

public final class CreatePaymentParams {

    private final long amount;
    private final String currency;
    private final String description;
    private final String customerId;
    private final String successUrl;
    private final Map<String, String> metadata;
    private final String idempotencyKey;

    private CreatePaymentParams(Builder builder) {
        this.amount = builder.amount;
        this.currency = builder.currency;
        this.description = builder.description;
        this.customerId = builder.customerId;
        this.successUrl = builder.successUrl;
        this.metadata = builder.metadata;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(long amount, String currency, String description) {
        return new Builder(amount, currency, description);
    }

    public long getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getDescription() { return description; }
    public String getCustomerId() { return customerId; }
    public String getSuccessUrl() { return successUrl; }
    public Map<String, String> getMetadata() { return metadata; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final long amount;
        private final String currency;
        private final String description;
        private String customerId;
        private String successUrl;
        private Map<String, String> metadata;
        private String idempotencyKey;

        private Builder(long amount, String currency, String description) {
            this.amount = amount;
            this.currency = currency;
            this.description = description;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder successUrl(String successUrl) {
            this.successUrl = successUrl;
            return this;
        }

        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CreatePaymentParams build() {
            return new CreatePaymentParams(this);
        }
    }
}
