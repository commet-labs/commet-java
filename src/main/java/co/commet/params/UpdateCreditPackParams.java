package co.commet.params;

import java.util.List;

public final class UpdateCreditPackParams {

    private final String name;
    private final String description;
    private final Long credits;
    private final Long price;
    private final Boolean isActive;
    private final List<String> planIds;
    private final String idempotencyKey;

    private UpdateCreditPackParams(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.credits = builder.credits;
        this.price = builder.price;
        this.isActive = builder.isActive;
        this.planIds = builder.planIds;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Long getCredits() { return credits; }
    public Long getPrice() { return price; }
    public Boolean getIsActive() { return isActive; }
    public List<String> getPlanIds() { return planIds; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String name;
        private String description;
        private Long credits;
        private Long price;
        private Boolean isActive;
        private List<String> planIds;
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

        public Builder credits(Long credits) {
            this.credits = credits;
            return this;
        }

        public Builder price(Long price) {
            this.price = price;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder planIds(List<String> planIds) {
            this.planIds = planIds;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdateCreditPackParams build() {
            return new UpdateCreditPackParams(this);
        }
    }
}
