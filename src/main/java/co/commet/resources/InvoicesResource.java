package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Invoice;
import co.commet.models.InvoiceDownload;
import co.commet.models.InvoicesListResult;
import co.commet.models.SentInvoice;
import co.commet.params.CreateAdjustmentInvoiceParams;
import co.commet.params.DownloadInvoiceParams;
import co.commet.params.ListInvoicesParams;
import co.commet.params.SendInvoiceParams;
import co.commet.params.UpdateInvoiceStatusParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class InvoicesResource {

    private final CommetHttpClient http;

    public InvoicesResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Generate a signed URL to download the invoice as a PDF. The URL expires after 7 days.
     */
    public InvoiceDownload getDownloadUrl(String id, DownloadInvoiceParams params) {
        return http.post("/invoices/" + id + "/download-links", Map.of(), params.getIdempotencyKey(), new TypeReference<InvoiceDownload>() {}).getData();
    }

    /**
     * Retrieve a single invoice by its public ID, including line items.
     */
    public Invoice get(String id) {
        return http.get("/invoices/" + id, new TypeReference<Invoice>() {}).getData();
    }

    /**
     * Send the invoice to the customer via email.
     */
    public SentInvoice send(String id, SendInvoiceParams params) {
        return http.post("/invoices/" + id + "/send", Map.of(), params.getIdempotencyKey(), new TypeReference<SentInvoice>() {}).getData();
    }

    /**
     * Mark an outstanding invoice as "paid" or "void" and return the updated invoice. Cannot change the status of already paid or voided invoices.
     */
    public Invoice updateStatus(String id, UpdateInvoiceStatusParams params) {
        return http.patch("/invoices/" + id + "/status", buildBody(
                "status", params.getStatus()
        ), params.getIdempotencyKey(), new TypeReference<Invoice>() {}).getData();
    }

    /**
     * List invoices with cursor-based pagination. Filter by customer, status, or subscription.
     */
    public InvoicesListResult list(ListInvoicesParams params) {
        return http.get("/invoices", buildBody(
                "cursor", params.getCursor(),
                "limit", params.getLimit(),
                "customer_id", params.getCustomerId(),
                "status", params.getStatus(),
                "subscription_id", params.getSubscriptionId()
        ), new TypeReference<InvoicesListResult>() {}).getData();
    }

    /**
     * Create a one-off adjustment invoice and return the created invoice. Use a negative amount for a credit.
     */
    public Invoice createAdjustment(CreateAdjustmentInvoiceParams params) {
        return http.post("/invoices", buildBody(
                "customer_id", params.getCustomerId(),
                "amount", params.getAmount(),
                "description", params.getDescription(),
                "metadata", params.getMetadata()
        ), params.getIdempotencyKey(), new TypeReference<Invoice>() {}).getData();
    }
}
