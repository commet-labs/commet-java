package co.commet.params;

import java.util.List;

public final class CreatePromoCodeParams {

    private final String code;
    private final String offerId;
    private final String billingInterval;
    private final Long maxRedemptions;
    private final String expiresAt;
    private final List<String> planIds;
    private final String idempotencyKey;

    private CreatePromoCodeParams(Builder builder) {
        this.code = builder.code;
        this.offerId = builder.offerId;
        this.billingInterval = builder.billingInterval;
        this.maxRedemptions = builder.maxRedemptions;
        this.expiresAt = builder.expiresAt;
        this.planIds = builder.planIds;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String code, String offerId) {
        return new Builder(code, offerId);
    }

    public String getCode() { return code; }
    public String getOfferId() { return offerId; }
    public String getBillingInterval() { return billingInterval; }
    public Long getMaxRedemptions() { return maxRedemptions; }
    public String getExpiresAt() { return expiresAt; }
    public List<String> getPlanIds() { return planIds; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String code;
        private final String offerId;
        private String billingInterval;
        private Long maxRedemptions;
        private String expiresAt;
        private List<String> planIds;
        private String idempotencyKey;

        private Builder(String code, String offerId) {
            this.code = code;
            this.offerId = offerId;
        }

        public Builder billingInterval(String billingInterval) {
            this.billingInterval = billingInterval;
            return this;
        }

        public Builder maxRedemptions(Long maxRedemptions) {
            this.maxRedemptions = maxRedemptions;
            return this;
        }

        public Builder expiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
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

        public CreatePromoCodeParams build() {
            return new CreatePromoCodeParams(this);
        }
    }
}
