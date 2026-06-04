package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Invoice;
import co.commet.models.InvoiceDownloadResult;
import co.commet.models.InvoiceSendResult;
import co.commet.models.InvoiceStatus;
import co.commet.models.InvoiceStatusResult;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class InvoicesResource {

    private final CommetHttpClient http;

    public InvoicesResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<List<Invoice>> list() {
        return list(null, null, null, null, null);
    }

    public ApiResponse<List<Invoice>> list(String customerId, InvoiceStatus status, String subscriptionId,
                                           Integer limit, String cursor) {
        return http.get("/invoices", buildBody(
                "customer_id", customerId,
                "status", status == null ? null : status.getValue(),
                "subscription_id", subscriptionId,
                "limit", limit,
                "cursor", cursor
        ), new TypeReference<>() {});
    }

    public ApiResponse<Invoice> get(String id) {
        return http.get("/invoices/" + id, new TypeReference<>() {});
    }

    public ApiResponse<Invoice> createAdjustment(String customerId, long amount) {
        return createAdjustment(customerId, amount, null, null);
    }

    public ApiResponse<Invoice> createAdjustment(String customerId, long amount, String description,
                                                 Map<String, Object> metadata) {
        return http.post("/invoices", buildBody(
                "customer_id", customerId,
                "amount", amount,
                "description", description,
                "metadata", metadata
        ), new TypeReference<>() {});
    }

    public ApiResponse<InvoiceDownloadResult> getDownloadUrl(String id) {
        return http.get("/invoices/" + id + "/download", new TypeReference<>() {});
    }

    public ApiResponse<InvoiceSendResult> send(String id) {
        return http.post("/invoices/" + id + "/send", Map.of(), new TypeReference<>() {});
    }

    public ApiResponse<InvoiceStatusResult> updateStatus(String id, InvoiceStatus status) {
        return http.put("/invoices/" + id + "/status", buildBody(
                "status", status == null ? null : status.getValue()
        ), new TypeReference<>() {});
    }
}
