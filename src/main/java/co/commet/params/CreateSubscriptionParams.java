package co.commet.params;

import java.util.Map;

public final class CreateSubscriptionParams {

    private final String customerId;
    private final String billingInterval;
    private final String priceId;
    private final Map<String, Long> initialSeats;
    private final String provider;
    private final String name;
    private final String startDate;
    private final String successUrl;
    private final String offerId;
    private final String promoCode;
    private final Long customTrialDays;
    private final Boolean skipTrial;
    private final String planId;
    private final String planCode;
    private final String cardPromotionId;
    private final String idempotencyKey;

    private CreateSubscriptionParams(Builder builder) {
        this.customerId = builder.customerId;
        this.billingInterval = builder.billingInterval;
        this.priceId = builder.priceId;
        this.initialSeats = builder.initialSeats;
        this.provider = builder.provider;
        this.name = builder.name;
        this.startDate = builder.startDate;
        this.successUrl = builder.successUrl;
        this.offerId = builder.offerId;
        this.promoCode = builder.promoCode;
        this.customTrialDays = builder.customTrialDays;
        this.skipTrial = builder.skipTrial;
        this.planId = builder.planId;
        this.planCode = builder.planCode;
        this.cardPromotionId = builder.cardPromotionId;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String customerId) {
        return new Builder(customerId);
    }

    public String getCustomerId() { return customerId; }
    public String getBillingInterval() { return billingInterval; }
    public String getPriceId() { return priceId; }
    public Map<String, Long> getInitialSeats() { return initialSeats; }
    public String getProvider() { return provider; }
    public String getName() { return name; }
    public String getStartDate() { return startDate; }
    public String getSuccessUrl() { return successUrl; }
    public String getOfferId() { return offerId; }
    public String getPromoCode() { return promoCode; }
    public Long getCustomTrialDays() { return customTrialDays; }
    public Boolean getSkipTrial() { return skipTrial; }
    public String getPlanId() { return planId; }
    public String getPlanCode() { return planCode; }
    public String getCardPromotionId() { return cardPromotionId; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String customerId;
        private String billingInterval;
        private String priceId;
        private Map<String, Long> initialSeats;
        private String provider;
        private String name;
        private String startDate;
        private String successUrl;
        private String offerId;
        private String promoCode;
        private Long customTrialDays;
        private Boolean skipTrial;
        private String planId;
        private String planCode;
        private String cardPromotionId;
        private String idempotencyKey;

        private Builder(String customerId) {
            this.customerId = customerId;
        }

        public Builder billingInterval(String billingInterval) {
            this.billingInterval = billingInterval;
            return this;
        }

        public Builder priceId(String priceId) {
            this.priceId = priceId;
            return this;
        }

        public Builder initialSeats(Map<String, Long> initialSeats) {
            this.initialSeats = initialSeats;
            return this;
        }

        public Builder provider(String provider) {
            this.provider = provider;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder successUrl(String successUrl) {
            this.successUrl = successUrl;
            return this;
        }

        public Builder offerId(String offerId) {
            this.offerId = offerId;
            return this;
        }

        public Builder promoCode(String promoCode) {
            this.promoCode = promoCode;
            return this;
        }

        public Builder customTrialDays(Long customTrialDays) {
            this.customTrialDays = customTrialDays;
            return this;
        }

        public Builder skipTrial(Boolean skipTrial) {
            this.skipTrial = skipTrial;
            return this;
        }

        public Builder planId(String planId) {
            this.planId = planId;
            return this;
        }

        public Builder planCode(String planCode) {
            this.planCode = planCode;
            return this;
        }

        public Builder cardPromotionId(String cardPromotionId) {
            this.cardPromotionId = cardPromotionId;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CreateSubscriptionParams build() {
            return new CreateSubscriptionParams(this);
        }
    }
}
