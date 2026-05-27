package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Transaction;
import co.commet.models.TransactionRefundResult;
import co.commet.models.TransactionRetryResult;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class TransactionsResource {

    private final CommetHttpClient http;

    public TransactionsResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<List<Transaction>> list() {
        return list(null, null, null, null);
    }

    public ApiResponse<List<Transaction>> list(String status, String customerEmail,
                                               Integer limit, String cursor) {
        return http.get("/transactions", buildBody(
                "status", status,
                "customer_email", customerEmail,
                "limit", limit,
                "cursor", cursor
        ), new TypeReference<>() {});
    }

    public ApiResponse<Transaction> get(String id) {
        return http.get("/transactions/" + id, new TypeReference<>() {});
    }

    public ApiResponse<TransactionRefundResult> refund(String id) {
        return http.post("/transactions/" + id + "/refund", Map.of(), new TypeReference<>() {});
    }

    public ApiResponse<TransactionRetryResult> retry(String id) {
        return http.post("/transactions/" + id + "/retry", Map.of(), new TypeReference<>() {});
    }
}
