package co.commet.params;

import co.commet.models.TransactionStatus;

public final class ListTransactionsParams {

    private final String cursor;
    private final Long limit;
    private final TransactionStatus status;
    private final String customerEmail;

    private ListTransactionsParams(Builder builder) {
        this.cursor = builder.cursor;
        this.limit = builder.limit;
        this.status = builder.status;
        this.customerEmail = builder.customerEmail;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCursor() { return cursor; }
    public Long getLimit() { return limit; }
    public TransactionStatus getStatus() { return status; }
    public String getCustomerEmail() { return customerEmail; }

    public static final class Builder {

        private String cursor;
        private Long limit;
        private TransactionStatus status;
        private String customerEmail;

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

        public Builder status(TransactionStatus status) {
            this.status = status;
            return this;
        }

        public Builder customerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        public ListTransactionsParams build() {
            return new ListTransactionsParams(this);
        }
    }
}
