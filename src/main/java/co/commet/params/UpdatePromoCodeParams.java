package co.commet.params;

import java.util.List;

public final class UpdatePromoCodeParams {

    private final Long maxRedemptions;
    private final String expiresAt;
    private final Boolean active;
    private final List<String> planIds;
    private final String idempotencyKey;

    private UpdatePromoCodeParams(Builder builder) {
        this.maxRedemptions = builder.maxRedemptions;
        this.expiresAt = builder.expiresAt;
        this.active = builder.active;
        this.planIds = builder.planIds;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getMaxRedemptions() { return maxRedemptions; }
    public String getExpiresAt() { return expiresAt; }
    public Boolean getActive() { return active; }
    public List<String> getPlanIds() { return planIds; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private Long maxRedemptions;
        private String expiresAt;
        private Boolean active;
        private List<String> planIds;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder maxRedemptions(Long maxRedemptions) {
            this.maxRedemptions = maxRedemptions;
            return this;
        }

        public Builder expiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
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

        public UpdatePromoCodeParams build() {
            return new UpdatePromoCodeParams(this);
        }
    }
}
