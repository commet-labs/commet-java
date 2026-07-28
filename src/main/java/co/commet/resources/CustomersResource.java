package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Customer;
import co.commet.models.CustomerBatch;
import co.commet.models.CustomersListResult;
import co.commet.params.BatchCreateCustomersParams;
import co.commet.params.CreateCustomerParams;
import co.commet.params.ListCustomersParams;
import co.commet.params.UpdateCustomerParams;
import com.fasterxml.jackson.core.type.TypeReference;

import static co.commet.CommetHttpClient.buildBody;

public class CustomersResource {

    private final CommetHttpClient http;

    public CustomersResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Retrieve a customer by their public ID, including subscription status and metadata.
     */
    public Customer get(String id) {
        return http.get("/customers/" + id, new TypeReference<Customer>() {}).getData();
    }

    /**
     * Update a customer's name, external ID, or metadata.
     */
    public Customer update(String id, UpdateCustomerParams params) {
        return http.patch("/customers/" + id, buildBody(
                "email", params.getEmail(),
                "full_name", params.getFullName(),
                "tax_document", params.getTaxDocument(),
                "external_id", params.getExternalId(),
                "timezone", params.getTimezone(),
                "metadata", params.getMetadata(),
                "address", params.getAddress()
        ), params.getIdempotencyKey(), new TypeReference<Customer>() {}).getData();
    }

    /**
     * Create up to 100 customers in a single request.
     */
    public CustomerBatch createBatch(BatchCreateCustomersParams params) {
        return http.post("/customers/batch", buildBody(
                "customers", params.getCustomers()
        ), params.getIdempotencyKey(), new TypeReference<CustomerBatch>() {}).getData();
    }

    /**
     * List customers with cursor-based pagination.
     */
    public CustomersListResult list(ListCustomersParams params) {
        return http.get("/customers", buildBody(
                "cursor", params.getCursor(),
                "limit", params.getLimit(),
                "external_id", params.getExternalId()
        ), new TypeReference<CustomersListResult>() {}).getData();
    }

    /**
     * Create a new customer. Idempotent when customerId is provided.
     */
    public Customer create(CreateCustomerParams params) {
        return http.post("/customers", buildBody(
                "id", params.getId(),
                "external_id", params.getExternalId(),
                "full_name", params.getFullName(),
                "tax_document", params.getTaxDocument(),
                "address", params.getAddress(),
                "address_id", params.getAddressId(),
                "email", params.getEmail(),
                "timezone", params.getTimezone(),
                "metadata", params.getMetadata()
        ), params.getIdempotencyKey(), new TypeReference<Customer>() {}).getData();
    }
}
