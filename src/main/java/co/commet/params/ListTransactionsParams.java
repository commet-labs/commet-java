package co.commet.params;

import co.commet.models.TransactionStatus;

public final class ListTransactionsParams {

    private final TransactionStatus status;
    private final String customerEmail;
    private final Long limit;
    private final String cursor;

    private ListTransactionsParams(Builder builder) {
        this.status = builder.status;
        this.customerEmail = builder.customerEmail;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public TransactionStatus getStatus() { return status; }
    public String getCustomerEmail() { return customerEmail; }
    public Long getLimit() { return limit; }
    public String getCursor() { return cursor; }

    public static final class Builder {

        private TransactionStatus status;
        private String customerEmail;
        private Long limit;
        private String cursor;

        private Builder() {
        }

        public Builder status(TransactionStatus status) {
            this.status = status;
            return this;
        }

        public Builder customerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        public Builder limit(Long limit) {
            this.limit = limit;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public ListTransactionsParams build() {
            return new ListTransactionsParams(this);
        }
    }
}
