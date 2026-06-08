package co.commet.params;

public final class AdvanceTestClockParams {

    private final Long advanceDays;
    private final String frozenTime;
    private final String idempotencyKey;

    private AdvanceTestClockParams(Builder builder) {
        this.advanceDays = builder.advanceDays;
        this.frozenTime = builder.frozenTime;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getAdvanceDays() { return advanceDays; }
    public String getFrozenTime() { return frozenTime; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private Long advanceDays;
        private String frozenTime;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder advanceDays(Long advanceDays) {
            this.advanceDays = advanceDays;
            return this;
        }

        public Builder frozenTime(String frozenTime) {
            this.frozenTime = frozenTime;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public AdvanceTestClockParams build() {
            return new AdvanceTestClockParams(this);
        }
    }
}
