package co.commet.params;

import java.util.Map;

public final class UpdatePlanParams {

    private final String name;
    private final String description;
    private final Map<String, Object> metadata;
    private final Boolean isPublic;
    private final String idempotencyKey;

    private UpdatePlanParams(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.metadata = builder.metadata;
        this.isPublic = builder.isPublic;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Map<String, Object> getMetadata() { return metadata; }
    public Boolean getIsPublic() { return isPublic; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String name;
        private String description;
        private Map<String, Object> metadata;
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

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
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

        public UpdatePlanParams build() {
            return new UpdatePlanParams(this);
        }
    }
}
