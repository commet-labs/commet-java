package co.commet.params;

public final class AddPlanToGroupParams {

    private final String planId;
    private final Long sortOrder;
    private final String idempotencyKey;

    private AddPlanToGroupParams(Builder builder) {
        this.planId = builder.planId;
        this.sortOrder = builder.sortOrder;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String planId) {
        return new Builder(planId);
    }

    public String getPlanId() { return planId; }
    public Long getSortOrder() { return sortOrder; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String planId;
        private Long sortOrder;
        private String idempotencyKey;

        private Builder(String planId) {
            this.planId = planId;
        }

        public Builder sortOrder(Long sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public AddPlanToGroupParams build() {
            return new AddPlanToGroupParams(this);
        }
    }
}
