package co.commet.params;

public final class ListInvoicesParams {

    private final String customerId;
    private final String status;
    private final String subscriptionId;
    private final String cursor;
    private final Long limit;

    private ListInvoicesParams(Builder builder) {
        this.customerId = builder.customerId;
        this.status = builder.status;
        this.subscriptionId = builder.subscriptionId;
        this.cursor = builder.cursor;
        this.limit = builder.limit;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCustomerId() { return customerId; }
    public String getStatus() { return status; }
    public String getSubscriptionId() { return subscriptionId; }
    public String getCursor() { return cursor; }
    public Long getLimit() { return limit; }

    public static final class Builder {

        private String customerId;
        private String status;
        private String subscriptionId;
        private String cursor;
        private Long limit;

        private Builder() {
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

        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder limit(Long limit) {
            this.limit = limit;
            return this;
        }

        public ListInvoicesParams build() {
            return new ListInvoicesParams(this);
        }
    }
}
