package co.commet.params;

public final class GetFeatureAccessParams {

    private final String customerId;
    private final String action;

    private GetFeatureAccessParams(Builder builder) {
        this.customerId = builder.customerId;
        this.action = builder.action;
    }

    public static Builder builder(String customerId) {
        return new Builder(customerId);
    }

    public String getCustomerId() { return customerId; }
    public String getAction() { return action; }

    public static final class Builder {

        private final String customerId;
        private String action;

        private Builder(String customerId) {
            this.customerId = customerId;
        }

        public Builder action(String action) {
            this.action = action;
            return this;
        }

        public GetFeatureAccessParams build() {
            return new GetFeatureAccessParams(this);
        }
    }
}
