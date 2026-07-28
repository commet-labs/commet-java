package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Refund;
import co.commet.models.Transaction;
import co.commet.models.TransactionRetry;
import co.commet.models.TransactionsListResult;
import co.commet.params.ListTransactionsParams;
import co.commet.params.RefundTransactionParams;
import co.commet.params.RetryTransactionParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class TransactionsResource {

    private final CommetHttpClient http;

    public TransactionsResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Issue a full refund and return the provider-neutral refund resource with its actual status.
     */
    public Refund refund(String id, RefundTransactionParams params) {
        return http.post("/transactions/" + id + "/refund", Map.of(), params.getIdempotencyKey(), new TypeReference<Refund>() {}).getData();
    }

    /**
     * Retry a failed subscription renewal and return an honest retry result. The original failed transaction remains immutable.
     */
    public TransactionRetry retry(String id, RetryTransactionParams params) {
        return http.post("/transactions/" + id + "/retry", Map.of(), params.getIdempotencyKey(), new TypeReference<TransactionRetry>() {}).getData();
    }

    /**
     * Retrieve a single payment transaction by its public ID, including provider details.
     */
    public Transaction get(String id) {
        return http.get("/transactions/" + id, new TypeReference<Transaction>() {}).getData();
    }

    /**
     * List payment transactions with cursor-based pagination. Filter by status or customer email.
     */
    public TransactionsListResult list(ListTransactionsParams params) {
        return http.get("/transactions", buildBody(
                "cursor", params.getCursor(),
                "limit", params.getLimit(),
                "status", params.getStatus(),
                "customer_email", params.getCustomerEmail()
        ), new TypeReference<TransactionsListResult>() {}).getData();
    }
}
