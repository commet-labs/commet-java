package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Payment;
import co.commet.models.PaymentsListResult;
import co.commet.params.CancelPaymentParams;
import co.commet.params.ChargePaymentParams;
import co.commet.params.CreatePaymentParams;
import co.commet.params.ListPaymentsParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class PaymentsResource {

    private final CommetHttpClient http;

    public PaymentsResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Cancel a pending payment link so it can no longer be paid. Only a link that has not been paid or started processing can be canceled; canceling an already canceled link is a no-op. Charges cannot be canceled.
     */
    public Payment cancel(String id, CancelPaymentParams params) {
        return http.post("/payments/" + id + "/cancel", Map.of(), params.getIdempotencyKey(), new TypeReference<Payment>() {}).getData();
    }

    /**
     * Retrieve a payment by its public ID.
     */
    public Payment get(String id) {
        return http.get("/payments/" + id, new TypeReference<Payment>() {}).getData();
    }

    /**
     * Charge a customer's vaulted payment method off-session. Calculates tax, generates an invoice, and sends a receipt. Requires the customer to have a subscription in active, trialing, or past_due state.
     */
    public Payment charge(ChargePaymentParams params) {
        return http.post("/payments/charge", buildBody(
                "customer_id", params.getCustomerId(),
                "amount", params.getAmount(),
                "currency", params.getCurrency(),
                "description", params.getDescription(),
                "metadata", params.getMetadata()
        ), params.getIdempotencyKey(), new TypeReference<Payment>() {}).getData();
    }

    /**
     * List payments with cursor-based pagination. Filter by customer.
     */
    public PaymentsListResult list(ListPaymentsParams params) {
        return http.get("/payments", buildBody(
                "cursor", params.getCursor(),
                "limit", params.getLimit(),
                "customer_id", params.getCustomerId()
        ), new TypeReference<PaymentsListResult>() {}).getData();
    }

    /**
     * Create a hosted payment link. Returns a url the customer opens to pay with any card. Calculates tax, generates an invoice, and vaults the payment method on confirmation. No subscription or plan required.
     */
    public Payment create(CreatePaymentParams params) {
        return http.post("/payments", buildBody(
                "amount", params.getAmount(),
                "currency", params.getCurrency(),
                "customer_id", params.getCustomerId(),
                "description", params.getDescription(),
                "success_url", params.getSuccessUrl(),
                "metadata", params.getMetadata()
        ), params.getIdempotencyKey(), new TypeReference<Payment>() {}).getData();
    }
}
