package co.commet.params;

public final class CreateApiKeyParams {

    private final String name;
    private final Long expiresInDays;
    private final String idempotencyKey;

    private CreateApiKeyParams(Builder builder) {
        this.name = builder.name;
        this.expiresInDays = builder.expiresInDays;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    public String getName() { return name; }
    public Long getExpiresInDays() { return expiresInDays; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String name;
        private Long expiresInDays;
        private String idempotencyKey;

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

        public CreateApiKeyParams build() {
            return new CreateApiKeyParams(this);
        }
    }
}
