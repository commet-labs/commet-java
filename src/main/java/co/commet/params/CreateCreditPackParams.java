package co.commet.params;

public final class CreateCreditPackParams {

    private final String name;
    private final long credits;
    private final long price;
    private final String description;
    private final Boolean isActive;
    private final String idempotencyKey;

    private CreateCreditPackParams(Builder builder) {
        this.name = builder.name;
        this.credits = builder.credits;
        this.price = builder.price;
        this.description = builder.description;
        this.isActive = builder.isActive;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String name, long credits, long price) {
        return new Builder(name, credits, price);
    }

    public String getName() { return name; }
    public long getCredits() { return credits; }
    public long getPrice() { return price; }
    public String getDescription() { return description; }
    public Boolean getIsActive() { return isActive; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String name;
        private final long credits;
        private final long price;
        private String description;
        private Boolean isActive;
        private String idempotencyKey;

        private Builder(String name, long credits, long price) {
            this.name = name;
            this.credits = credits;
            this.price = price;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CreateCreditPackParams build() {
            return new CreateCreditPackParams(this);
        }
    }
}
