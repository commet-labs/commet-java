package co.commet.params;

public final class UpdatePlanGrantParams {

    private final String reason;
    private final String duration;
    private final Long durationCycles;
    private final String expiresAt;
    private final String idempotencyKey;

    private UpdatePlanGrantParams(Builder builder) {
        this.reason = builder.reason;
        this.duration = builder.duration;
        this.durationCycles = builder.durationCycles;
        this.expiresAt = builder.expiresAt;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String reason, String duration) {
        return new Builder(reason, duration);
    }

    public String getReason() { return reason; }
    public String getDuration() { return duration; }
    public Long getDurationCycles() { return durationCycles; }
    public String getExpiresAt() { return expiresAt; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String reason;
        private final String duration;
        private Long durationCycles;
        private String expiresAt;
        private String idempotencyKey;

        private Builder(String reason, String duration) {
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

        public UpdatePlanGrantParams build() {
            return new UpdatePlanGrantParams(this);
        }
    }
}
