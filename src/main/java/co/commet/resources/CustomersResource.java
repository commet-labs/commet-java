package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Customer;
import co.commet.models.CustomerBatch;
import co.commet.params.BatchCreateCustomersParams;
import co.commet.params.CreateCustomerParams;
import co.commet.params.ListCustomersParams;
import co.commet.params.UpdateCustomerParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

import static co.commet.CommetHttpClient.buildBody;

public class CustomersResource {

    private final CommetHttpClient http;

    public CustomersResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * List customers with cursor-based pagination.
     */
    public ApiResponse<List<Customer>> list(ListCustomersParams params) {
        return http.get("/customers", buildBody(
                "external_id", params.getExternalId(),
                "limit", params.getLimit(),
                "cursor", params.getCursor()
        ), new TypeReference<>() {});
    }

    /**
     * Create a new customer. Idempotent when customerId is provided.
     */
    public ApiResponse<Customer> create(CreateCustomerParams params) {
        return http.post("/customers", buildBody(
                "id", params.getId(),
                "external_id", params.getExternalId(),
                "full_name", params.getFullName(),
                "address", params.getAddress(),
                "address_id", params.getAddressId(),
                "email", params.getEmail(),
                "timezone", params.getTimezone(),
                "metadata", params.getMetadata()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Retrieve a customer by their public ID, including subscription status and metadata.
     */
    public ApiResponse<Customer> get(String id) {
        return http.get("/customers/" + id, new TypeReference<>() {});
    }

    /**
     * Update a customer's name, external ID, or metadata.
     */
    public ApiResponse<Customer> update(String id, UpdateCustomerParams params) {
        return http.put("/customers/" + id, buildBody(
                "email", params.getEmail(),
                "full_name", params.getFullName(),
                "external_id", params.getExternalId(),
                "timezone", params.getTimezone(),
                "metadata", params.getMetadata(),
                "address", params.getAddress()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Create up to 100 customers in a single request.
     */
    public ApiResponse<CustomerBatch> createBatch(BatchCreateCustomersParams params) {
        return http.post("/customers/batch", buildBody(
                "customers", params.getCustomers()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }
}
