package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.BatchResult;
import co.commet.models.Customer;
import co.commet.params.CreateCustomerParams;
import co.commet.params.ListCustomersParams;
import co.commet.params.UpdateCustomerParams;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class CustomersResource {

    private final CommetHttpClient http;

    public CustomersResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<Customer> create(String email) {
        return create(CreateCustomerParams.builder(email).build());
    }

    public ApiResponse<Customer> create(CreateCustomerParams params) {
        return http.post("/customers", buildBody(
                "billing_email", params.getEmail(),
                "external_id", params.getId(),
                "full_name", params.getFullName(),
                "domain", params.getDomain(),
                "website", params.getWebsite(),
                "timezone", params.getTimezone(),
                "language", params.getLanguage(),
                "industry", params.getIndustry(),
                "metadata", params.getMetadata(),
                "address", params.getAddress()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    public ApiResponse<BatchResult> createBatch(List<Map<String, Object>> customers) {
        return createBatch(customers, null);
    }

    public ApiResponse<BatchResult> createBatch(List<Map<String, Object>> customers, String idempotencyKey) {
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
        return http.post("/customers/batch", Map.of("customers", mapped), idempotencyKey,
                new TypeReference<>() {});
    }

    public ApiResponse<Customer> get(String customerId) {
        return http.get("/customers/" + customerId, new TypeReference<>() {});
    }

    public ApiResponse<Customer> update(String customerId, UpdateCustomerParams params) {
        return http.put("/customers/" + customerId, buildBody(
                "billing_email", params.getEmail(),
                "full_name", params.getFullName(),
                "domain", params.getDomain(),
                "website", params.getWebsite(),
                "timezone", params.getTimezone(),
                "language", params.getLanguage(),
                "industry", params.getIndustry(),
                "metadata", params.getMetadata(),
                "address", params.getAddress()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    public ApiResponse<List<Customer>> list() {
        return http.get("/customers", new TypeReference<>() {});
    }

    public ApiResponse<List<Customer>> list(ListCustomersParams params) {
        return http.get("/customers", buildBody(
                "customer_id", params.getCustomerId(),
                "is_active", params.getIsActive(),
                "search", params.getSearch(),
                "limit", params.getLimit(),
                "cursor", params.getCursor()
        ), new TypeReference<>() {});
    }

    public ApiResponse<Customer> archive(String customerId) {
        return archive(customerId, null);
    }

    public ApiResponse<Customer> archive(String customerId, String idempotencyKey) {
        return http.put("/customers/" + customerId, Map.of("is_active", false), idempotencyKey,
                new TypeReference<>() {});
    }
}
