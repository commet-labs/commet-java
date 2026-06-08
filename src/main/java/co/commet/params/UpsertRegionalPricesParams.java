package co.commet.params;

import co.commet.models.UpsertRegionalPricesParamsOverridesItem;
import java.util.List;

public final class UpsertRegionalPricesParams {

    private final List<UpsertRegionalPricesParamsOverridesItem> overrides;
    private final String idempotencyKey;

    private UpsertRegionalPricesParams(Builder builder) {
        this.overrides = builder.overrides;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(List<UpsertRegionalPricesParamsOverridesItem> overrides) {
        return new Builder(overrides);
    }

    public List<UpsertRegionalPricesParamsOverridesItem> getOverrides() { return overrides; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final List<UpsertRegionalPricesParamsOverridesItem> overrides;
        private String idempotencyKey;

        private Builder(List<UpsertRegionalPricesParamsOverridesItem> overrides) {
            this.overrides = overrides;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpsertRegionalPricesParams build() {
            return new UpsertRegionalPricesParams(this);
        }
    }
}
