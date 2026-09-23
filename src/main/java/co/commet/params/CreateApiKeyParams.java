package co.commet.params;

import java.util.List;
import java.util.Map;

public final class CreateApiKeyParams {

    private final String name;
    private final Long expiresInDays;
    private final String idempotencyKey;
    private final Map<String, List<String>> permissions;

    private CreateApiKeyParams(Builder builder) {
        this.name = builder.name;
        this.expiresInDays = builder.expiresInDays;
        this.idempotencyKey = builder.idempotencyKey;
        this.permissions = builder.permissions;
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    public String getName() { return name; }
    public Long getExpiresInDays() { return expiresInDays; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public Map<String, List<String>> getPermissions() { return permissions; }

    public static final class Builder {

        private final String name;
        private Long expiresInDays;
        private String idempotencyKey;
        private Map<String, List<String>> permissions;

        private Builder(String name) {
            this.name = name;
        }

        public Builder expiresInDays(Long expiresInDays) {
            this.expiresInDays = expiresInDays;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public Builder permissions(Map<String, List<String>> permissions) {
            this.permissions = permissions;
            return this;
        }

        public CreateApiKeyParams build() {
            return new CreateApiKeyParams(this);
        }
    }
}
