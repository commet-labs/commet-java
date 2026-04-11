package co.commet.params;

import java.util.Map;

public final class TrackParams {

    private final String feature;
    private final String customerId;
    private final Integer value;
    private final String model;
    private final Integer inputTokens;
    private final Integer outputTokens;
    private final Integer cacheReadTokens;
    private final Integer cacheWriteTokens;
    private final String idempotencyKey;
    private final String timestamp;
    private final Map<String, String> properties;

    private TrackParams(Builder builder) {
        this.feature = builder.feature;
        this.customerId = builder.customerId;
        this.value = builder.value;
        this.model = builder.model;
        this.inputTokens = builder.inputTokens;
        this.outputTokens = builder.outputTokens;
        this.cacheReadTokens = builder.cacheReadTokens;
        this.cacheWriteTokens = builder.cacheWriteTokens;
        this.idempotencyKey = builder.idempotencyKey;
        this.timestamp = builder.timestamp;
        this.properties = builder.properties;
    }

    public static Builder builder(String feature) {
        return new Builder(feature);
    }

    public TrackParams withCustomerId(String customerId) {
        Builder b = builder(this.feature)
                .customerId(customerId)
                .value(this.value)
                .model(this.model)
                .inputTokens(this.inputTokens)
                .outputTokens(this.outputTokens)
                .cacheReadTokens(this.cacheReadTokens)
                .cacheWriteTokens(this.cacheWriteTokens)
                .idempotencyKey(this.idempotencyKey)
                .timestamp(this.timestamp)
                .properties(this.properties);
        return b.build();
    }

    public String getFeature() { return feature; }
    public String getCustomerId() { return customerId; }
    public Integer getValue() { return value; }
    public String getModel() { return model; }
    public Integer getInputTokens() { return inputTokens; }
    public Integer getOutputTokens() { return outputTokens; }
    public Integer getCacheReadTokens() { return cacheReadTokens; }
    public Integer getCacheWriteTokens() { return cacheWriteTokens; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public String getTimestamp() { return timestamp; }
    public Map<String, String> getProperties() { return properties; }

    public static final class Builder {

        private final String feature;
        private String customerId;
        private Integer value;
        private String model;
        private Integer inputTokens;
        private Integer outputTokens;
        private Integer cacheReadTokens;
        private Integer cacheWriteTokens;
        private String idempotencyKey;
        private String timestamp;
        private Map<String, String> properties;

        private Builder(String feature) {
            this.feature = feature;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder value(Integer value) {
            this.value = value;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder inputTokens(Integer inputTokens) {
            this.inputTokens = inputTokens;
            return this;
        }

        public Builder outputTokens(Integer outputTokens) {
            this.outputTokens = outputTokens;
            return this;
        }

        public Builder cacheReadTokens(Integer cacheReadTokens) {
            this.cacheReadTokens = cacheReadTokens;
            return this;
        }

        public Builder cacheWriteTokens(Integer cacheWriteTokens) {
            this.cacheWriteTokens = cacheWriteTokens;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public Builder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder properties(Map<String, String> properties) {
            this.properties = properties;
            return this;
        }

        public TrackParams build() {
            return new TrackParams(this);
        }
    }
}
