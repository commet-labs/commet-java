package co.commet.params;

public final class UpdateFeatureParams {

    private final String name;
    private final String description;
    private final String unitName;
    private final String idempotencyKey;

    private UpdateFeatureParams(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.unitName = builder.unitName;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getUnitName() { return unitName; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String name;
        private String description;
        private String unitName;
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

        public Builder unitName(String unitName) {
            this.unitName = unitName;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdateFeatureParams build() {
            return new UpdateFeatureParams(this);
        }
    }
}
