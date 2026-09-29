package co.commet.params;

public final class PauseSubscriptionParams {

    private final String mode;
    private final Long durationDays;
    private final String idempotencyKey;

    private PauseSubscriptionParams(Builder builder) {
        this.mode = builder.mode;
        this.durationDays = builder.durationDays;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String mode) {
        return new Builder(mode);
    }

    public String getMode() { return mode; }
    public Long getDurationDays() { return durationDays; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String mode;
        private Long durationDays;
        private String idempotencyKey;

        private Builder(String mode) {
            this.mode = mode;
        }

        public Builder durationDays(Long durationDays) {
            this.durationDays = durationDays;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public PauseSubscriptionParams build() {
            return new PauseSubscriptionParams(this);
        }
    }
}
