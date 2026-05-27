package co.commet;

import java.time.Duration;

public class RequestOptions {

    private final String apiVersion;
    private final String idempotencyKey;
    private final Duration timeout;

    private RequestOptions(String apiVersion, String idempotencyKey, Duration timeout) {
        this.apiVersion = apiVersion;
        this.idempotencyKey = idempotencyKey;
        this.timeout = timeout;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public Duration getTimeout() {
        return timeout;
    }

    public static class Builder {

        private String apiVersion;
        private String idempotencyKey;
        private Duration timeout;

        private Builder() {}

        public Builder apiVersion(String apiVersion) {
            this.apiVersion = apiVersion;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public Builder timeout(Duration timeout) {
            this.timeout = timeout;
            return this;
        }

        public RequestOptions build() {
            return new RequestOptions(apiVersion, idempotencyKey, timeout);
        }
    }
}
