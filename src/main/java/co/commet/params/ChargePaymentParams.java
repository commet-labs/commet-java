package co.commet.params;

import java.util.Map;

public final class ChargePaymentParams {

    private final String customerId;
    private final long amount;
    private final String currency;
    private final String description;
    private final Map<String, String> metadata;
    private final String idempotencyKey;

    private ChargePaymentParams(Builder builder) {
        this.customerId = builder.customerId;
        this.amount = builder.amount;
        this.currency = builder.currency;
        this.description = builder.description;
        this.metadata = builder.metadata;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String customerId, long amount, String currency, String description) {
        return new Builder(customerId, amount, currency, description);
    }

    public String getCustomerId() { return customerId; }
    public long getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getDescription() { return description; }
    public Map<String, String> getMetadata() { return metadata; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String customerId;
        private final long amount;
        private final String currency;
        private final String description;
        private Map<String, String> metadata;
        private String idempotencyKey;

        private Builder(String customerId, long amount, String currency, String description) {
            this.customerId = customerId;
            this.amount = amount;
            this.currency = currency;
            this.description = description;
        }

        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public ChargePaymentParams build() {
            return new ChargePaymentParams(this);
        }
    }
}
