package co.commet.params;

public final class UpdatePlanGroupParams {

    private final String name;
    private final String description;
    private final Boolean isPublic;
    private final String idempotencyKey;

    private UpdatePlanGroupParams(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.isPublic = builder.isPublic;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Boolean getIsPublic() { return isPublic; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String name;
        private String description;
        private Boolean isPublic;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder isPublic(Boolean isPublic) {
            this.isPublic = isPublic;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdatePlanGroupParams build() {
            return new UpdatePlanGroupParams(this);
        }
    }
}
