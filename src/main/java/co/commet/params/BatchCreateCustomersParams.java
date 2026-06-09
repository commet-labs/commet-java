package co.commet.params;

import co.commet.models.BatchCreateCustomersParamsCustomersItem;
import java.util.List;

public final class BatchCreateCustomersParams {

    private final List<BatchCreateCustomersParamsCustomersItem> customers;
    private final String idempotencyKey;

    private BatchCreateCustomersParams(Builder builder) {
        this.customers = builder.customers;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(List<BatchCreateCustomersParamsCustomersItem> customers) {
        return new Builder(customers);
    }

    public List<BatchCreateCustomersParamsCustomersItem> getCustomers() { return customers; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final List<BatchCreateCustomersParamsCustomersItem> customers;
        private String idempotencyKey;

        private Builder(List<BatchCreateCustomersParamsCustomersItem> customers) {
            this.customers = customers;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public BatchCreateCustomersParams build() {
            return new BatchCreateCustomersParams(this);
        }
    }
}
