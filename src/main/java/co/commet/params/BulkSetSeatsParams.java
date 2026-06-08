package co.commet.params;

import java.util.Map;

public final class BulkSetSeatsParams {

    private final String customerId;
    private final Map<String, Long> seats;
    private final String idempotencyKey;

    private BulkSetSeatsParams(Builder builder) {
        this.customerId = builder.customerId;
        this.seats = builder.seats;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String customerId, Map<String, Long> seats) {
        return new Builder(customerId, seats);
    }

    public String getCustomerId() { return customerId; }
    public Map<String, Long> getSeats() { return seats; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String customerId;
        private final Map<String, Long> seats;
        private String idempotencyKey;

        private Builder(String customerId, Map<String, Long> seats) {
            this.customerId = customerId;
            this.seats = seats;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public BulkSetSeatsParams build() {
            return new BulkSetSeatsParams(this);
        }
    }
}
