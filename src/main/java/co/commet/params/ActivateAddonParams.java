package co.commet.params;

public final class ActivateAddonParams {

    private final String addonId;
    private final String successUrl;
    private final String idempotencyKey;

    private ActivateAddonParams(Builder builder) {
        this.addonId = builder.addonId;
        this.successUrl = builder.successUrl;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String addonId) {
        return new Builder(addonId);
    }

    public String getAddonId() { return addonId; }
    public String getSuccessUrl() { return successUrl; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String addonId;
        private String successUrl;
        private String idempotencyKey;

        private Builder(String addonId) {
            this.addonId = addonId;
        }

        public Builder successUrl(String successUrl) {
            this.successUrl = successUrl;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public ActivateAddonParams build() {
            return new ActivateAddonParams(this);
        }
    }
}
