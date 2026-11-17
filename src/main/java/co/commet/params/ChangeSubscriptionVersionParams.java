package co.commet.params;

public final class ChangeSubscriptionVersionParams {

    private final String planVersionId;
    private final String effective;
    private final String currency;
    private final String idempotencyKey;

    private ChangeSubscriptionVersionParams(Builder builder) {
        this.planVersionId = builder.planVersionId;
        this.effective = builder.effective;
        this.currency = builder.currency;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String planVersionId, String effective) {
        return new Builder(planVersionId, effective);
    }

    public String getPlanVersionId() { return planVersionId; }
    public String getEffective() { return effective; }
    public String getCurrency() { return currency; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String planVersionId;
        private final String effective;
        private String currency;
        private String idempotencyKey;

        private Builder(String planVersionId, String effective) {
            this.planVersionId = planVersionId;
            this.effective = effective;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public ChangeSubscriptionVersionParams build() {
            return new ChangeSubscriptionVersionParams(this);
        }
    }
}
