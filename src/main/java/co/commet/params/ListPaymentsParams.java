package co.commet.params;

public final class ListPaymentsParams {

    private final String customerId;
    private final String cursor;
    private final Long limit;

    private ListPaymentsParams(Builder builder) {
        this.customerId = builder.customerId;
        this.cursor = builder.cursor;
        this.limit = builder.limit;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCustomerId() { return customerId; }
    public String getCursor() { return cursor; }
    public Long getLimit() { return limit; }

    public static final class Builder {

        private String customerId;
        private String cursor;
        private Long limit;

        private Builder() {
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
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

        public ListPaymentsParams build() {
            return new ListPaymentsParams(this);
        }
    }
}
