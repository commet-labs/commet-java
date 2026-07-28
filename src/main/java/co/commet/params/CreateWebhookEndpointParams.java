package co.commet.params;

import java.util.List;

public final class CreateWebhookEndpointParams {

    private final String url;
    private final List<String> events;
    private final String description;
    private final String apiVersion;
    private final String idempotencyKey;

    private CreateWebhookEndpointParams(Builder builder) {
        this.url = builder.url;
        this.events = builder.events;
        this.description = builder.description;
        this.apiVersion = builder.apiVersion;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String url, List<String> events) {
        return new Builder(url, events);
    }

    public String getUrl() { return url; }
    public List<String> getEvents() { return events; }
    public String getDescription() { return description; }
    public String getApiVersion() { return apiVersion; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String url;
        private final List<String> events;
        private String description;
        private String apiVersion;
        private String idempotencyKey;

        private Builder(String url, List<String> events) {
            this.url = url;
            this.events = events;
        }

        public Builder description(String description) {
            this.description = description;
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

        public CreateWebhookEndpointParams build() {
            return new CreateWebhookEndpointParams(this);
        }
    }
}
