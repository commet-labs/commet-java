package co.commet.params;

public final class CreatePlanGroupParams {

    private final String name;
    private final String description;
    private final Boolean isPublic;
    private final String idempotencyKey;

    private CreatePlanGroupParams(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.isPublic = builder.isPublic;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Boolean getIsPublic() { return isPublic; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String name;
        private String description;
        private Boolean isPublic;
        private String idempotencyKey;

        private Builder(String name) {
            this.name = name;
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

        public CreatePlanGroupParams build() {
            return new CreatePlanGroupParams(this);
        }
    }
}
