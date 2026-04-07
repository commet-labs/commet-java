package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class CustomersResource {

    private final CommetHttpClient http;

    public CustomersResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse create(String email) {
        return create(email, null, null, null, null, null, null, null, null, null, null);
    }

    public ApiResponse create(String email, String externalId) {
        return create(email, externalId, null, null, null, null, null, null, null, null, null);
    }

    public ApiResponse create(String email, String externalId, String fullName,
                              String domain, String website, String timezone,
                              String language, String industry,
                              Map<String, Object> metadata, Map<String, String> address,
                              String idempotencyKey) {
        return http.post("/customers", buildBody(
                "billing_email", email,
                "external_id", externalId,
                "full_name", fullName,
                "domain", domain,
                "website", website,
                "timezone", timezone,
                "language", language,
                "industry", industry,
                "metadata", metadata,
                "address", address
        ), idempotencyKey);
    }

    public ApiResponse createBatch(List<Map<String, Object>> customers) {
        return createBatch(customers, null);
    }

    public ApiResponse createBatch(List<Map<String, Object>> customers, String idempotencyKey) {
        List<Map<String, Object>> mapped = new ArrayList<>();
        for (Map<String, Object> c : customers) {
            mapped.add(buildBody(
                    "billing_email", c.get("email"),
                    "external_id", c.get("external_id"),
                    "full_name", c.get("full_name"),
                    "domain", c.get("domain"),
                    "website", c.get("website"),
                    "timezone", c.get("timezone"),
                    "language", c.get("language"),
                    "industry", c.get("industry"),
                    "metadata", c.get("metadata"),
                    "address", c.get("address")
            ));
        }
        return http.post("/customers/batch", Map.of("customers", mapped), idempotencyKey);
    }

    public ApiResponse get(String customerId) {
        return http.get("/customers/" + customerId);
    }

    public ApiResponse update(String customerId, String email, String externalId, String fullName,
                              String domain, String website, String timezone,
                              String language, String industry,
                              Map<String, Object> metadata, Map<String, String> address,
                              String idempotencyKey) {
        return http.put("/customers/" + customerId, buildBody(
                "billing_email", email,
                "external_id", externalId,
                "full_name", fullName,
                "domain", domain,
                "website", website,
                "timezone", timezone,
                "language", language,
                "industry", industry,
                "metadata", metadata,
                "address", address
        ), idempotencyKey);
    }

    public ApiResponse list() {
        return list(null, null, null, null, null);
    }

    public ApiResponse list(String customerId, Boolean isActive, String search,
                            Integer limit, String cursor) {
        return http.get("/customers", buildBody(
                "customer_id", customerId,
                "is_active", isActive,
                "search", search,
                "limit", limit,
                "cursor", cursor
        ));
    }

    public ApiResponse archive(String customerId) {
        return archive(customerId, null);
    }

    public ApiResponse archive(String customerId, String idempotencyKey) {
        return http.put("/customers/" + customerId, Map.of("is_active", false), idempotencyKey);
    }
}
