package co.commet.params;

public final class RemoveSeatsParams {

    private final String customerId;
    private final String featureCode;
    private final long count;

    private RemoveSeatsParams(Builder builder) {
        this.customerId = builder.customerId;
        this.featureCode = builder.featureCode;
        this.count = builder.count;
    }

    public static Builder builder(String customerId, String featureCode, long count) {
        return new Builder(customerId, featureCode, count);
    }

    public String getCustomerId() { return customerId; }
    public String getFeatureCode() { return featureCode; }
    public long getCount() { return count; }

    public static final class Builder {

        private final String customerId;
        private final String featureCode;
        private final long count;

        private Builder(String customerId, String featureCode, long count) {
            this.customerId = customerId;
            this.featureCode = featureCode;
            this.count = count;
        }

        public RemoveSeatsParams build() {
            return new RemoveSeatsParams(this);
        }
    }
}
