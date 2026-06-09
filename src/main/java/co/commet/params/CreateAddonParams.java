package co.commet.params;

public final class CreateAddonParams {

    private final String name;
    private final long basePrice;
    private final String featureId;
    private final String consumptionModel;
    private final String description;
    private final Long includedUnits;
    private final Long overageRate;
    private final Long creditCost;
    private final String idempotencyKey;

    private CreateAddonParams(Builder builder) {
        this.name = builder.name;
        this.basePrice = builder.basePrice;
        this.featureId = builder.featureId;
        this.consumptionModel = builder.consumptionModel;
        this.description = builder.description;
        this.includedUnits = builder.includedUnits;
        this.overageRate = builder.overageRate;
        this.creditCost = builder.creditCost;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String name, long basePrice, String featureId, String consumptionModel) {
        return new Builder(name, basePrice, featureId, consumptionModel);
    }

    public String getName() { return name; }
    public long getBasePrice() { return basePrice; }
    public String getFeatureId() { return featureId; }
    public String getConsumptionModel() { return consumptionModel; }
    public String getDescription() { return description; }
    public Long getIncludedUnits() { return includedUnits; }
    public Long getOverageRate() { return overageRate; }
    public Long getCreditCost() { return creditCost; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String name;
        private final long basePrice;
        private final String featureId;
        private final String consumptionModel;
        private String description;
        private Long includedUnits;
        private Long overageRate;
        private Long creditCost;
        private String idempotencyKey;

        private Builder(String name, long basePrice, String featureId, String consumptionModel) {
            this.name = name;
            this.basePrice = basePrice;
            this.featureId = featureId;
            this.consumptionModel = consumptionModel;
        }

        public Builder description(String description) {
            this.description = description;
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

        public Builder creditCost(Long creditCost) {
            this.creditCost = creditCost;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CreateAddonParams build() {
            return new CreateAddonParams(this);
        }
    }
}
