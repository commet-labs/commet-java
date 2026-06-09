package co.commet.params;

import co.commet.models.SubscriptionStatus;

public final class ListSubscriptionsParams {

    private final String customerId;
    private final SubscriptionStatus status;

    private ListSubscriptionsParams(Builder builder) {
        this.customerId = builder.customerId;
        this.status = builder.status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCustomerId() { return customerId; }
    public SubscriptionStatus getStatus() { return status; }

    public static final class Builder {

        private String customerId;
        private SubscriptionStatus status;

        private Builder() {
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder status(SubscriptionStatus status) {
            this.status = status;
            return this;
        }

        public ListSubscriptionsParams build() {
            return new ListSubscriptionsParams(this);
        }
    }
}
