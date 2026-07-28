package co.commet.params;

import co.commet.models.TrackUsageParamsPropertiesItem;
import java.util.List;

public final class TrackUsageParams {

    private final String featureCode;
    private final String customerId;
    private final String eventId;
    private final String timestamp;
    private final List<TrackUsageParamsPropertiesItem> properties;
    private final String model;
    private final Long inputTokens;
    private final Long outputTokens;
    private final Double value;
    private final Long cacheReadTokens;
    private final Long cacheWriteTokens;
    private final String idempotencyKey;

    private TrackUsageParams(Builder builder) {
        this.featureCode = builder.featureCode;
        this.customerId = builder.customerId;
        this.eventId = builder.eventId;
        this.timestamp = builder.timestamp;
        this.properties = builder.properties;
        this.model = builder.model;
        this.inputTokens = builder.inputTokens;
        this.outputTokens = builder.outputTokens;
        this.value = builder.value;
        this.cacheReadTokens = builder.cacheReadTokens;
        this.cacheWriteTokens = builder.cacheWriteTokens;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String featureCode, String customerId) {
        return new Builder(featureCode, customerId);
    }

    public String getFeatureCode() { return featureCode; }
    public String getCustomerId() { return customerId; }
    public String getEventId() { return eventId; }
    public String getTimestamp() { return timestamp; }
    public List<TrackUsageParamsPropertiesItem> getProperties() { return properties; }
    public String getModel() { return model; }
    public Long getInputTokens() { return inputTokens; }
    public Long getOutputTokens() { return outputTokens; }
    public Double getValue() { return value; }
    public Long getCacheReadTokens() { return cacheReadTokens; }
    public Long getCacheWriteTokens() { return cacheWriteTokens; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String featureCode;
        private final String customerId;
        private String eventId;
        private String timestamp;
        private List<TrackUsageParamsPropertiesItem> properties;
        private String model;
        private Long inputTokens;
        private Long outputTokens;
        private Double value;
        private Long cacheReadTokens;
        private Long cacheWriteTokens;
        private String idempotencyKey;

        private Builder(String featureCode, String customerId) {
            this.featureCode = featureCode;
            this.customerId = customerId;
        }

        public Builder eventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder properties(List<TrackUsageParamsPropertiesItem> properties) {
            this.properties = properties;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder inputTokens(Long inputTokens) {
            this.inputTokens = inputTokens;
            return this;
        }

        public Builder outputTokens(Long outputTokens) {
            this.outputTokens = outputTokens;
            return this;
        }

        public Builder value(Double value) {
            this.value = value;
            return this;
        }

        public Builder cacheReadTokens(Long cacheReadTokens) {
            this.cacheReadTokens = cacheReadTokens;
            return this;
        }

        public Builder cacheWriteTokens(Long cacheWriteTokens) {
            this.cacheWriteTokens = cacheWriteTokens;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public TrackUsageParams build() {
            return new TrackUsageParams(this);
        }
    }
}
