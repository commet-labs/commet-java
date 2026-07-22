package co.commet.params;

import co.commet.models.BillingInterval;
import co.commet.models.DiscountType;
import java.util.List;

public final class CreatePromoCodeParams {

    private final String code;
    private final DiscountType discountType;
    private final long discountValue;
    private final Long durationCycles;
    private final BillingInterval billingInterval;
    private final Long maxRedemptions;
    private final String expiresAt;
    private final List<String> planIds;
    private final String idempotencyKey;

    private CreatePromoCodeParams(Builder builder) {
        this.code = builder.code;
        this.discountType = builder.discountType;
        this.discountValue = builder.discountValue;
        this.durationCycles = builder.durationCycles;
        this.billingInterval = builder.billingInterval;
        this.maxRedemptions = builder.maxRedemptions;
        this.expiresAt = builder.expiresAt;
        this.planIds = builder.planIds;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String code, DiscountType discountType, long discountValue) {
        return new Builder(code, discountType, discountValue);
    }

    public String getCode() { return code; }
    public DiscountType getDiscountType() { return discountType; }
    public long getDiscountValue() { return discountValue; }
    public Long getDurationCycles() { return durationCycles; }
    public BillingInterval getBillingInterval() { return billingInterval; }
    public Long getMaxRedemptions() { return maxRedemptions; }
    public String getExpiresAt() { return expiresAt; }
    public List<String> getPlanIds() { return planIds; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String code;
        private final DiscountType discountType;
        private final long discountValue;
        private Long durationCycles;
        private BillingInterval billingInterval;
        private Long maxRedemptions;
        private String expiresAt;
        private List<String> planIds;
        private String idempotencyKey;

        private Builder(String code, DiscountType discountType, long discountValue) {
            this.code = code;
            this.discountType = discountType;
            this.discountValue = discountValue;
        }

        public Builder durationCycles(Long durationCycles) {
            this.durationCycles = durationCycles;
            return this;
        }

        public Builder billingInterval(BillingInterval billingInterval) {
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
