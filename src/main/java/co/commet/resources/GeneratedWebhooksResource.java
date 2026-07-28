package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.CreatedWebhook;
import co.commet.models.DeletedObject;
import co.commet.models.Webhook;
import co.commet.models.WebhookTest;
import co.commet.models.WebhooksListResult;
import co.commet.params.CreateWebhookEndpointParams;
import co.commet.params.ListWebhookEndpointsParams;
import co.commet.params.TestWebhookEndpointParams;
import co.commet.params.UpdateWebhookEndpointParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class GeneratedWebhooksResource {

    private final CommetHttpClient http;

    public GeneratedWebhooksResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Retrieve a webhook endpoint by its public ID.
     */
    public Webhook get(String id) {
        return http.get("/webhooks/" + id, new TypeReference<Webhook>() {}).getData();
    }

    /**
     * Update a webhook endpoint. Only the provided fields change.
     */
    public Webhook update(String id, UpdateWebhookEndpointParams params) {
        return http.patch("/webhooks/" + id, buildBody(
                "url", params.getUrl(),
                "events", params.getEvents(),
                "description", params.getDescription(),
                "is_active", params.getIsActive(),
                "api_version", params.getApiVersion()
        ), params.getIdempotencyKey(), new TypeReference<Webhook>() {}).getData();
    }

    /**
     * Permanently delete a webhook endpoint.
     */
    public DeletedObject delete(String id) {
        return http.delete("/webhooks/" + id, null, new TypeReference<DeletedObject>() {}).getData();
    }

    /**
     * Send a test event to a webhook endpoint to verify connectivity.
     */
    public WebhookTest test(String id, TestWebhookEndpointParams params) {
        return http.post("/webhooks/" + id + "/test", Map.of(), params.getIdempotencyKey(), new TypeReference<WebhookTest>() {}).getData();
    }

    /**
     * List webhook endpoints with cursor-based pagination.
     */
    public WebhooksListResult list(ListWebhookEndpointsParams params) {
        return http.get("/webhooks", buildBody(
                "cursor", params.getCursor(),
                "limit", params.getLimit()
        ), new TypeReference<WebhooksListResult>() {}).getData();
    }

    /**
     * Create a new webhook endpoint. The response includes the signing secret which is only returned once.
     */
    public CreatedWebhook create(CreateWebhookEndpointParams params) {
        return http.post("/webhooks", buildBody(
                "url", params.getUrl(),
                "events", params.getEvents(),
                "description", params.getDescription(),
                "api_version", params.getApiVersion()
        ), params.getIdempotencyKey(), new TypeReference<CreatedWebhook>() {}).getData();
    }
}
