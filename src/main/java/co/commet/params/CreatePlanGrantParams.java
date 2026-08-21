package co.commet.params;

public final class CreatePlanGrantParams {

    private final String subscriptionId;
    private final String planId;
    private final String reason;
    private final String duration;
    private final Long durationCycles;
    private final String expiresAt;
    private final String idempotencyKey;

    private CreatePlanGrantParams(Builder builder) {
        this.subscriptionId = builder.subscriptionId;
        this.planId = builder.planId;
        this.reason = builder.reason;
        this.duration = builder.duration;
        this.durationCycles = builder.durationCycles;
        this.expiresAt = builder.expiresAt;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String subscriptionId, String planId, String reason, String duration) {
        return new Builder(subscriptionId, planId, reason, duration);
    }

    public String getSubscriptionId() { return subscriptionId; }
    public String getPlanId() { return planId; }
    public String getReason() { return reason; }
    public String getDuration() { return duration; }
    public Long getDurationCycles() { return durationCycles; }
    public String getExpiresAt() { return expiresAt; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String subscriptionId;
        private final String planId;
        private final String reason;
        private final String duration;
        private Long durationCycles;
        private String expiresAt;
        private String idempotencyKey;

        private Builder(String subscriptionId, String planId, String reason, String duration) {
            this.subscriptionId = subscriptionId;
            this.planId = planId;
            this.reason = reason;
            this.duration = duration;
        }

        public Builder durationCycles(Long durationCycles) {
            this.durationCycles = durationCycles;
            return this;
        }

        public Builder expiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CreatePlanGrantParams build() {
            return new CreatePlanGrantParams(this);
        }
    }
}
