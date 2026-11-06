package co.commet.params;

public final class CreatePlanDraftParams {

    private final String fromVersionId;
    private final String idempotencyKey;

    private CreatePlanDraftParams(Builder builder) {
        this.fromVersionId = builder.fromVersionId;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFromVersionId() { return fromVersionId; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String fromVersionId;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder fromVersionId(String fromVersionId) {
            this.fromVersionId = fromVersionId;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CreatePlanDraftParams build() {
            return new CreatePlanDraftParams(this);
        }
    }
}
