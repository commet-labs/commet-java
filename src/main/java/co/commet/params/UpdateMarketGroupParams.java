package co.commet.params;

import java.util.List;
import java.util.Map;

public final class UpdateMarketGroupParams {

    private final String name;
    private final List<String> countryCodes;
    private final Map<String, Object> metadata;
    private final String idempotencyKey;

    private UpdateMarketGroupParams(Builder builder) {
        this.name = builder.name;
        this.countryCodes = builder.countryCodes;
        this.metadata = builder.metadata;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String name, List<String> countryCodes) {
        return new Builder(name, countryCodes);
    }

    public String getName() { return name; }
    public List<String> getCountryCodes() { return countryCodes; }
    public Map<String, Object> getMetadata() { return metadata; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String name;
        private final List<String> countryCodes;
        private Map<String, Object> metadata;
        private String idempotencyKey;

        private Builder(String name, List<String> countryCodes) {
            this.name = name;
            this.countryCodes = countryCodes;
        }

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdateMarketGroupParams build() {
            return new UpdateMarketGroupParams(this);
        }
    }
}
