package co.commet.params;

public final class ListActiveAddonsParams {

    private final String customerId;

    private ListActiveAddonsParams(Builder builder) {
        this.customerId = builder.customerId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCustomerId() { return customerId; }

    public static final class Builder {

        private String customerId;

        private Builder() {
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public ListActiveAddonsParams build() {
            return new ListActiveAddonsParams(this);
        }
    }
}
