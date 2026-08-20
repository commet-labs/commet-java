package co.commet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.commet.models.WebhookEventType;

import co.commet.models.SubscriptionCreatedData;
import co.commet.models.SubscriptionActivatedData;
import co.commet.models.SubscriptionReactivatedData;
import co.commet.models.SubscriptionCanceledData;
import co.commet.models.SubscriptionUpdatedData;
import co.commet.models.SubscriptionPlanChangedData;
import co.commet.models.SubscriptionCancellationScheduledData;
import co.commet.models.SubscriptionCancellationRevokedData;
import co.commet.models.SubscriptionPlanChangeScheduledData;
import co.commet.models.SubscriptionPlanChangeRevokedData;
import co.commet.models.SubscriptionPastDueData;
import co.commet.models.TrialStartedData;
import co.commet.models.TrialConvertedData;
import co.commet.models.TrialExpiredData;
import co.commet.models.TrialWillEndData;
import co.commet.models.TrialCheckoutReadyData;
import co.commet.models.CheckoutReadyData;
import co.commet.models.PaymentReceivedData;
import co.commet.models.PaymentFailedData;
import co.commet.models.PaymentRecoveredData;
import co.commet.models.PaymentRetryFailedData;
import co.commet.models.PaymentRefundedData;
import co.commet.models.PaymentDisputedData;
import co.commet.models.PaymentDisputeResolvedData;
import co.commet.models.PaymentLinkCreatedData;
import co.commet.models.PaymentLinkCompletedData;
import co.commet.models.PaymentLinkFailedData;
import co.commet.models.PaymentLinkCanceledData;
import co.commet.models.InvoiceCreatedData;
import co.commet.models.InvoiceVoidedData;
import co.commet.models.InvoiceOverdueData;
import co.commet.models.InvoiceUpcomingData;
import co.commet.models.PaymentMethodAttachedData;
import co.commet.models.PaymentMethodUpdatedData;
import co.commet.models.CustomerCreatedData;
import co.commet.models.CustomerUpdatedData;
import co.commet.models.CustomerStateChangedData;
import co.commet.models.PlanGrantCreatedData;
import co.commet.models.PlanGrantUpdatedData;
import co.commet.models.PlanGrantExpiredData;
import co.commet.models.PlanGrantRevokedData;
import co.commet.models.CreditsGrantedData;
import co.commet.models.CreditsPurchasedData;
import co.commet.models.CreditsLowData;
import co.commet.models.CreditsDepletedData;
import co.commet.models.CreditsExpiredData;
import co.commet.models.BalanceToppedUpData;
import co.commet.models.BalanceLowData;
import co.commet.models.BalanceDepletedData;
import co.commet.models.QuotaThresholdReachedData;
import co.commet.models.QuotaExceededData;
import co.commet.models.SeatsUpdatedData;
import co.commet.models.SeatsLimitReachedData;
import co.commet.models.AddonActivatedData;
import co.commet.models.AddonDeactivatedData;
import co.commet.models.UsageRecordedData;
import co.commet.models.PayoutAvailableData;
import co.commet.models.PayoutCreatedData;
import co.commet.models.PayoutPaidData;
import co.commet.models.PayoutFailedData;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebhookEvent(
        @JsonProperty("event") WebhookEventType event,
        @JsonProperty("timestamp") String timestamp,
        @JsonProperty("organizationId") String organizationId,
        @JsonProperty("mode") String mode,
        @JsonProperty("apiVersion") String apiVersion,
        @JsonProperty("data") JsonNode data
) {

    private static final ObjectMapper MAPPER =
            new ObjectMapper().findAndRegisterModules();

    private <T> T convert(Class<T> type) {
        try {
            return MAPPER.treeToValue(data, type);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse webhook data as " + type.getSimpleName(), e);
        }
    }

    public SubscriptionCreatedData asSubscriptionCreated() {
        return convert(SubscriptionCreatedData.class);
    }

    public SubscriptionActivatedData asSubscriptionActivated() {
        return convert(SubscriptionActivatedData.class);
    }

    public SubscriptionReactivatedData asSubscriptionReactivated() {
        return convert(SubscriptionReactivatedData.class);
    }

    public SubscriptionCanceledData asSubscriptionCanceled() {
        return convert(SubscriptionCanceledData.class);
    }

    public SubscriptionUpdatedData asSubscriptionUpdated() {
        return convert(SubscriptionUpdatedData.class);
    }

    public SubscriptionPlanChangedData asSubscriptionPlanChanged() {
        return convert(SubscriptionPlanChangedData.class);
    }

    public SubscriptionCancellationScheduledData asSubscriptionCancellationScheduled() {
        return convert(SubscriptionCancellationScheduledData.class);
    }

    public SubscriptionCancellationRevokedData asSubscriptionCancellationRevoked() {
        return convert(SubscriptionCancellationRevokedData.class);
    }

    public SubscriptionPlanChangeScheduledData asSubscriptionPlanChangeScheduled() {
        return convert(SubscriptionPlanChangeScheduledData.class);
    }

    public SubscriptionPlanChangeRevokedData asSubscriptionPlanChangeRevoked() {
        return convert(SubscriptionPlanChangeRevokedData.class);
    }

    public SubscriptionPastDueData asSubscriptionPastDue() {
        return convert(SubscriptionPastDueData.class);
    }

    public TrialStartedData asTrialStarted() {
        return convert(TrialStartedData.class);
    }

    public TrialConvertedData asTrialConverted() {
        return convert(TrialConvertedData.class);
    }

    public TrialExpiredData asTrialExpired() {
        return convert(TrialExpiredData.class);
    }

    public TrialWillEndData asTrialWillEnd() {
        return convert(TrialWillEndData.class);
    }

    public TrialCheckoutReadyData asTrialCheckoutReady() {
        return convert(TrialCheckoutReadyData.class);
    }

    public CheckoutReadyData asCheckoutReady() {
        return convert(CheckoutReadyData.class);
    }

    public PaymentReceivedData asPaymentReceived() {
        return convert(PaymentReceivedData.class);
    }

    public PaymentFailedData asPaymentFailed() {
        return convert(PaymentFailedData.class);
    }

    public PaymentRecoveredData asPaymentRecovered() {
        return convert(PaymentRecoveredData.class);
    }

    public PaymentRetryFailedData asPaymentRetryFailed() {
        return convert(PaymentRetryFailedData.class);
    }

    public PaymentRefundedData asPaymentRefunded() {
        return convert(PaymentRefundedData.class);
    }

    public PaymentDisputedData asPaymentDisputed() {
        return convert(PaymentDisputedData.class);
    }

    public PaymentDisputeResolvedData asPaymentDisputeResolved() {
        return convert(PaymentDisputeResolvedData.class);
    }

    public PaymentLinkCreatedData asPaymentLinkCreated() {
        return convert(PaymentLinkCreatedData.class);
    }

    public PaymentLinkCompletedData asPaymentLinkCompleted() {
        return convert(PaymentLinkCompletedData.class);
    }

    public PaymentLinkFailedData asPaymentLinkFailed() {
        return convert(PaymentLinkFailedData.class);
    }

    public PaymentLinkCanceledData asPaymentLinkCanceled() {
        return convert(PaymentLinkCanceledData.class);
    }

    public InvoiceCreatedData asInvoiceCreated() {
        return convert(InvoiceCreatedData.class);
    }

    public InvoiceVoidedData asInvoiceVoided() {
        return convert(InvoiceVoidedData.class);
    }

    public InvoiceOverdueData asInvoiceOverdue() {
        return convert(InvoiceOverdueData.class);
    }

    public InvoiceUpcomingData asInvoiceUpcoming() {
        return convert(InvoiceUpcomingData.class);
    }

    public PaymentMethodAttachedData asPaymentMethodAttached() {
        return convert(PaymentMethodAttachedData.class);
    }

    public PaymentMethodUpdatedData asPaymentMethodUpdated() {
        return convert(PaymentMethodUpdatedData.class);
    }

    public CustomerCreatedData asCustomerCreated() {
        return convert(CustomerCreatedData.class);
    }

    public CustomerUpdatedData asCustomerUpdated() {
        return convert(CustomerUpdatedData.class);
    }

    public CustomerStateChangedData asCustomerStateChanged() {
        return convert(CustomerStateChangedData.class);
    }

    public PlanGrantCreatedData asPlanGrantCreated() {
        return convert(PlanGrantCreatedData.class);
    }

    public PlanGrantUpdatedData asPlanGrantUpdated() {
        return convert(PlanGrantUpdatedData.class);
    }

    public PlanGrantExpiredData asPlanGrantExpired() {
        return convert(PlanGrantExpiredData.class);
    }

    public PlanGrantRevokedData asPlanGrantRevoked() {
        return convert(PlanGrantRevokedData.class);
    }

    public CreditsGrantedData asCreditsGranted() {
        return convert(CreditsGrantedData.class);
    }

    public CreditsPurchasedData asCreditsPurchased() {
        return convert(CreditsPurchasedData.class);
    }

    public CreditsLowData asCreditsLow() {
        return convert(CreditsLowData.class);
    }

    public CreditsDepletedData asCreditsDepleted() {
        return convert(CreditsDepletedData.class);
    }

    public CreditsExpiredData asCreditsExpired() {
        return convert(CreditsExpiredData.class);
    }

    public BalanceToppedUpData asBalanceToppedUp() {
        return convert(BalanceToppedUpData.class);
    }

    public BalanceLowData asBalanceLow() {
        return convert(BalanceLowData.class);
    }

    public BalanceDepletedData asBalanceDepleted() {
        return convert(BalanceDepletedData.class);
    }

    public QuotaThresholdReachedData asQuotaThresholdReached() {
        return convert(QuotaThresholdReachedData.class);
    }

    public QuotaExceededData asQuotaExceeded() {
        return convert(QuotaExceededData.class);
    }

    public SeatsUpdatedData asSeatsUpdated() {
        return convert(SeatsUpdatedData.class);
    }

    public SeatsLimitReachedData asSeatsLimitReached() {
        return convert(SeatsLimitReachedData.class);
    }

    public AddonActivatedData asAddonActivated() {
        return convert(AddonActivatedData.class);
    }

    public AddonDeactivatedData asAddonDeactivated() {
        return convert(AddonDeactivatedData.class);
    }

    public UsageRecordedData asUsageRecorded() {
        return convert(UsageRecordedData.class);
    }

    public PayoutAvailableData asPayoutAvailable() {
        return convert(PayoutAvailableData.class);
    }

    public PayoutCreatedData asPayoutCreated() {
        return convert(PayoutCreatedData.class);
    }

    public PayoutPaidData asPayoutPaid() {
        return convert(PayoutPaidData.class);
    }

    public PayoutFailedData asPayoutFailed() {
        return convert(PayoutFailedData.class);
    }
}
