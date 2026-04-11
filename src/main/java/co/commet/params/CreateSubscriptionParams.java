package co.commet.params;

import java.util.Map;

public final class CreateSubscriptionParams {

    private final String customerId;
    private final String planCode;
    private final String planId;
    private final String billingInterval;
    private final Map<String, Integer> initialSeats;
    private final Boolean skipTrial;
    private final String name;
    private final String startDate;
    private final String successUrl;
    private final String idempotencyKey;

    private CreateSubscriptionParams(Builder builder) {
        this.customerId = builder.customerId;
        this.planCode = builder.planCode;
        this.planId = builder.planId;
        this.billingInterval = builder.billingInterval;
        this.initialSeats = builder.initialSeats;
        this.skipTrial = builder.skipTrial;
        this.name = builder.name;
        this.startDate = builder.startDate;
        this.successUrl = builder.successUrl;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String customerId, String planCode) {
        return new Builder(customerId, planCode);
    }

    public String getCustomerId() { return customerId; }
    public String getPlanCode() { return planCode; }
    public String getPlanId() { return planId; }
    public String getBillingInterval() { return billingInterval; }
    public Map<String, Integer> getInitialSeats() { return initialSeats; }
    public Boolean getSkipTrial() { return skipTrial; }
    public String getName() { return name; }
    public String getStartDate() { return startDate; }
    public String getSuccessUrl() { return successUrl; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String customerId;
        private final String planCode;
        private String planId;
        private String billingInterval;
        private Map<String, Integer> initialSeats;
        private Boolean skipTrial;
        private String name;
        private String startDate;
        private String successUrl;
        private String idempotencyKey;

        private Builder(String customerId, String planCode) {
            this.customerId = customerId;
            this.planCode = planCode;
        }

        public Builder planId(String planId) {
            this.planId = planId;
            return this;
        }

        public Builder billingInterval(String billingInterval) {
            this.billingInterval = billingInterval;
            return this;
        }

        public Builder initialSeats(Map<String, Integer> initialSeats) {
            this.initialSeats = initialSeats;
            return this;
        }

        public Builder skipTrial(boolean skipTrial) {
            this.skipTrial = skipTrial;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder successUrl(String successUrl) {
            this.successUrl = successUrl;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CreateSubscriptionParams build() {
            return new CreateSubscriptionParams(this);
        }
    }
}
