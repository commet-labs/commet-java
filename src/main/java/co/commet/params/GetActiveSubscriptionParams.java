package co.commet.params;

public final class GetActiveSubscriptionParams {

    private final String customerId;

    private GetActiveSubscriptionParams(Builder builder) {
        this.customerId = builder.customerId;
    }

    public static Builder builder(String customerId) {
        return new Builder(customerId);
    }

    public String getCustomerId() { return customerId; }

    public static final class Builder {

        private final String customerId;

        private Builder(String customerId) {
            this.customerId = customerId;
        }

        public GetActiveSubscriptionParams build() {
            return new GetActiveSubscriptionParams(this);
        }
    }
}
