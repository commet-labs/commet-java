package co.commet.params;

public final class SetPlanVisibilityParams {

    private final boolean isPublic;
    private final String idempotencyKey;

    private SetPlanVisibilityParams(Builder builder) {
        this.isPublic = builder.isPublic;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(boolean isPublic) {
        return new Builder(isPublic);
    }

    public boolean isIsPublic() { return isPublic; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final boolean isPublic;
        private String idempotencyKey;

        private Builder(boolean isPublic) {
            this.isPublic = isPublic;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public SetPlanVisibilityParams build() {
            return new SetPlanVisibilityParams(this);
        }
    }
}
