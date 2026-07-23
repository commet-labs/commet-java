package co.commet.params;

import co.commet.models.BillingInterval;
import co.commet.models.CreateSubscriptionParamsIntroOffer;
import co.commet.models.PaymentProvider;
import java.util.Map;

public final class CreateSubscriptionParams {

    private final String customerId;
    private final String planId;
    private final String planCode;
    private final BillingInterval billingInterval;
    private final Map<String, Long> initialSeats;
    private final Boolean skipTrial;
    private final Long customTrialDays;
    private final CreateSubscriptionParamsIntroOffer introOffer;
    private final String promoCode;
    private final PaymentProvider provider;
    private final String name;
    private final String startDate;
    private final String successUrl;
    private final String idempotencyKey;

    private CreateSubscriptionParams(Builder builder) {
        this.customerId = builder.customerId;
        this.planId = builder.planId;
        this.planCode = builder.planCode;
        this.billingInterval = builder.billingInterval;
        this.initialSeats = builder.initialSeats;
        this.skipTrial = builder.skipTrial;
        this.customTrialDays = builder.customTrialDays;
        this.introOffer = builder.introOffer;
        this.promoCode = builder.promoCode;
        this.provider = builder.provider;
        this.name = builder.name;
        this.startDate = builder.startDate;
        this.successUrl = builder.successUrl;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String customerId) {
        return new Builder(customerId);
    }

    public String getCustomerId() { return customerId; }
    public String getPlanId() { return planId; }
    public String getPlanCode() { return planCode; }
    public BillingInterval getBillingInterval() { return billingInterval; }
    public Map<String, Long> getInitialSeats() { return initialSeats; }
    public Boolean getSkipTrial() { return skipTrial; }
    public Long getCustomTrialDays() { return customTrialDays; }
    public CreateSubscriptionParamsIntroOffer getIntroOffer() { return introOffer; }
    public String getPromoCode() { return promoCode; }
    public PaymentProvider getProvider() { return provider; }
    public String getName() { return name; }
    public String getStartDate() { return startDate; }
    public String getSuccessUrl() { return successUrl; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String customerId;
        private String planId;
        private String planCode;
        private BillingInterval billingInterval;
        private Map<String, Long> initialSeats;
        private Boolean skipTrial;
        private Long customTrialDays;
        private CreateSubscriptionParamsIntroOffer introOffer;
        private String promoCode;
        private PaymentProvider provider;
        private String name;
        private String startDate;
        private String successUrl;
        private String idempotencyKey;

        private Builder(String customerId) {
            this.customerId = customerId;
        }

        public Builder planId(String planId) {
            this.planId = planId;
            return this;
        }

        public Builder planCode(String planCode) {
            this.planCode = planCode;
            return this;
        }

        public Builder billingInterval(BillingInterval billingInterval) {
            this.billingInterval = billingInterval;
            return this;
        }

        public Builder initialSeats(Map<String, Long> initialSeats) {
            this.initialSeats = initialSeats;
            return this;
        }

        public Builder skipTrial(Boolean skipTrial) {
            this.skipTrial = skipTrial;
            return this;
        }

        public Builder customTrialDays(Long customTrialDays) {
            this.customTrialDays = customTrialDays;
            return this;
        }

        public Builder introOffer(CreateSubscriptionParamsIntroOffer introOffer) {
            this.introOffer = introOffer;
            return this;
        }

        public Builder promoCode(String promoCode) {
            this.promoCode = promoCode;
            return this;
        }

        public Builder provider(PaymentProvider provider) {
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

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CreateSubscriptionParams build() {
            return new CreateSubscriptionParams(this);
        }
    }
}
