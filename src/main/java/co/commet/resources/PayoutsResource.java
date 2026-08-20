package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Payout;
import co.commet.models.PayoutBankAccount;
import co.commet.params.AddPayoutBankAccountParams;
import co.commet.params.CompletePayoutVerificationParams;
import co.commet.params.RequestPayoutParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class PayoutsResource {

    private final CommetHttpClient http;

    public PayoutsResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Add an additional destination bank account to the organization's existing payout account. Country and currency are resolved from the organization. The full account number is never returned — only `last4`.
     */
    public PayoutBankAccount addBankAccount(AddPayoutBankAccountParams params) {
        return http.post("/payouts/bank-accounts", buildBody(
                "account_number", params.getAccountNumber(),
                "account_holder_name", params.getAccountHolderName(),
                "routing_number", params.getRoutingNumber(),
                "account_type", params.getAccountType(),
                "set_default", params.getSetDefault()
        ), params.getIdempotencyKey(), new TypeReference<PayoutBankAccount>() {}).getData();
    }

    /**
     * Withdraw available balance to the organization's verified payout account. `amount` is in cents (USD, minimum 1000 = $10). The payout is created in `pending` and settles to `paid` asynchronously as provider webhooks arrive.
     */
    public Payout request(RequestPayoutParams params) {
        return http.post("/payouts", buildBody(
                "amount", params.getAmount(),
                "description", params.getDescription()
        ), params.getIdempotencyKey(), new TypeReference<Payout>() {}).getData();
    }

    /**
     * Deprecated. Complete business and identity verification in the Commet dashboard. This endpoint no longer accepts or processes KYC data.
     * @deprecated
     */
    @Deprecated
    public Void completeVerification(CompletePayoutVerificationParams params) {
        return http.post("/payouts/verification", null, params.getIdempotencyKey(), new TypeReference<Void>() {}).getData();
    }
}
