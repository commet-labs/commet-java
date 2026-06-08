package co.commet.params;

public final class UpdateAddonParams {

    private final String name;
    private final String description;
    private final Long basePrice;
    private final Long includedUnits;
    private final Long overageRate;
    private final String idempotencyKey;

    private UpdateAddonParams(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.basePrice = builder.basePrice;
        this.includedUnits = builder.includedUnits;
        this.overageRate = builder.overageRate;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Long getBasePrice() { return basePrice; }
    public Long getIncludedUnits() { return includedUnits; }
    public Long getOverageRate() { return overageRate; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String name;
        private String description;
        private Long basePrice;
        private Long includedUnits;
        private Long overageRate;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder basePrice(Long basePrice) {
            this.basePrice = basePrice;
            return this;
        }

        public Builder includedUnits(Long includedUnits) {
            this.includedUnits = includedUnits;
            return this;
        }

        public Builder overageRate(Long overageRate) {
            this.overageRate = overageRate;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdateAddonParams build() {
            return new UpdateAddonParams(this);
        }
    }
}
