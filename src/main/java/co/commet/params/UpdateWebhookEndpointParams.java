package co.commet.params;

import java.util.List;

public final class UpdateWebhookEndpointParams {

    private final String url;
    private final List<String> events;
    private final String description;
    private final Boolean isActive;
    private final String apiVersion;
    private final String idempotencyKey;

    private UpdateWebhookEndpointParams(Builder builder) {
        this.url = builder.url;
        this.events = builder.events;
        this.description = builder.description;
        this.isActive = builder.isActive;
        this.apiVersion = builder.apiVersion;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUrl() { return url; }
    public List<String> getEvents() { return events; }
    public String getDescription() { return description; }
    public Boolean getIsActive() { return isActive; }
    public String getApiVersion() { return apiVersion; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String url;
        private List<String> events;
        private String description;
        private Boolean isActive;
        private String apiVersion;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder events(List<String> events) {
            this.events = events;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder apiVersion(String apiVersion) {
            this.apiVersion = apiVersion;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdateWebhookEndpointParams build() {
            return new UpdateWebhookEndpointParams(this);
        }
    }
}
