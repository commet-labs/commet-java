package co.commet.params;

public final class ListInvoicesParams {

    private final String cursor;
    private final Long limit;
    private final String customerId;
    private final String status;
    private final String subscriptionId;

    private ListInvoicesParams(Builder builder) {
        this.cursor = builder.cursor;
        this.limit = builder.limit;
        this.customerId = builder.customerId;
        this.status = builder.status;
        this.subscriptionId = builder.subscriptionId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCursor() { return cursor; }
    public Long getLimit() { return limit; }
    public String getCustomerId() { return customerId; }
    public String getStatus() { return status; }
    public String getSubscriptionId() { return subscriptionId; }

    public static final class Builder {

        private String cursor;
        private Long limit;
        private String customerId;
        private String status;
        private String subscriptionId;

        private Builder() {
        }

        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder limit(Long limit) {
            this.limit = limit;
            return this;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder subscriptionId(String subscriptionId) {
            this.subscriptionId = subscriptionId;
            return this;
        }

        public ListInvoicesParams build() {
            return new ListInvoicesParams(this);
        }
    }
}
