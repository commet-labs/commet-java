package co.commet.params;

public final class ListPaymentsParams {

    private final String cursor;
    private final Long limit;
    private final String customerId;

    private ListPaymentsParams(Builder builder) {
        this.cursor = builder.cursor;
        this.limit = builder.limit;
        this.customerId = builder.customerId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCursor() { return cursor; }
    public Long getLimit() { return limit; }
    public String getCustomerId() { return customerId; }

    public static final class Builder {

        private String cursor;
        private Long limit;
        private String customerId;

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

        public ListPaymentsParams build() {
            return new ListPaymentsParams(this);
        }
    }
}
