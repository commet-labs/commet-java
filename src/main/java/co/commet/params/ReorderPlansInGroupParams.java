package co.commet.params;

import java.util.List;

public final class ReorderPlansInGroupParams {

    private final List<String> planIds;
    private final String idempotencyKey;

    private ReorderPlansInGroupParams(Builder builder) {
        this.planIds = builder.planIds;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(List<String> planIds) {
        return new Builder(planIds);
    }

    public List<String> getPlanIds() { return planIds; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final List<String> planIds;
        private String idempotencyKey;

        private Builder(List<String> planIds) {
            this.planIds = planIds;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public ReorderPlansInGroupParams build() {
            return new ReorderPlansInGroupParams(this);
        }
    }
}
