package co.commet.params;

public final class UpdateSubscriptionPauseParams {

    private final Long durationDays;
    private final String idempotencyKey;

    private UpdateSubscriptionPauseParams(Builder builder) {
        this.durationDays = builder.durationDays;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getDurationDays() { return durationDays; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private Long durationDays;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder durationDays(Long durationDays) {
            this.durationDays = durationDays;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdateSubscriptionPauseParams build() {
            return new UpdateSubscriptionPauseParams(this);
        }
    }
}
