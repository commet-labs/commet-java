package co.commet.params;

public final class GetSeatBalanceParams {

    private final String customerId;
    private final String featureCode;

    private GetSeatBalanceParams(Builder builder) {
        this.customerId = builder.customerId;
        this.featureCode = builder.featureCode;
    }

    public static Builder builder(String customerId, String featureCode) {
        return new Builder(customerId, featureCode);
    }

    public String getCustomerId() { return customerId; }
    public String getFeatureCode() { return featureCode; }

    public static final class Builder {

        private final String customerId;
        private final String featureCode;

        private Builder(String customerId, String featureCode) {
            this.customerId = customerId;
            this.featureCode = featureCode;
        }

        public GetSeatBalanceParams build() {
            return new GetSeatBalanceParams(this);
        }
    }
}
