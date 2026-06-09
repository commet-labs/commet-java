package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Transaction;
import co.commet.models.TransactionRefund;
import co.commet.models.TransactionRetry;
import co.commet.params.ListTransactionsParams;
import co.commet.params.RefundTransactionParams;
import co.commet.params.RetryTransactionParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class TransactionsResource {

    private final CommetHttpClient http;

    public TransactionsResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * List payment transactions with cursor-based pagination. Filter by status or customer email.
     */
    public ApiResponse<List<Transaction>> list(ListTransactionsParams params) {
        return http.get("/transactions", buildBody(
                "status", params.getStatus(),
                "customer_email", params.getCustomerEmail(),
                "limit", params.getLimit(),
                "cursor", params.getCursor()
        ), new TypeReference<>() {});
    }

    /**
     * Retrieve a single payment transaction by its public ID, including provider details.
     */
    public ApiResponse<Transaction> get(String id) {
        return http.get("/transactions/" + id, new TypeReference<>() {});
    }

    /**
     * Issue a full refund for a payment transaction.
     */
    public ApiResponse<TransactionRefund> refund(String id, RefundTransactionParams params) {
        return http.post("/transactions/" + id + "/refund", Map.of(), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Retry a failed payment transaction. Creates a new invoice and initiates a new payment attempt.
     */
    public ApiResponse<TransactionRetry> retry(String id, RetryTransactionParams params) {
        return http.post("/transactions/" + id + "/retry", Map.of(), params.getIdempotencyKey(), new TypeReference<>() {});
    }
}
