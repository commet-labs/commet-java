package co.commet.params;

import co.commet.models.FeatureType;

public final class CreateFeatureParams {

    private final String name;
    private final String code;
    private final FeatureType type;
    private final String description;
    private final String unitName;
    private final String idempotencyKey;

    private CreateFeatureParams(Builder builder) {
        this.name = builder.name;
        this.code = builder.code;
        this.type = builder.type;
        this.description = builder.description;
        this.unitName = builder.unitName;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String name, String code, FeatureType type) {
        return new Builder(name, code, type);
    }

    public String getName() { return name; }
    public String getCode() { return code; }
    public FeatureType getType() { return type; }
    public String getDescription() { return description; }
    public String getUnitName() { return unitName; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String name;
        private final String code;
        private final FeatureType type;
        private String description;
        private String unitName;
        private String idempotencyKey;

        private Builder(String name, String code, FeatureType type) {
            this.name = name;
            this.code = code;
            this.type = type;
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

        public CreateFeatureParams build() {
            return new CreateFeatureParams(this);
        }
    }
}
