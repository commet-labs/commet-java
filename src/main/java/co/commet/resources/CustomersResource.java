package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Customer;
import co.commet.models.CustomerBatch;
import co.commet.models.CustomerCredit;
import co.commet.models.CustomerCreditRevocation;
import co.commet.models.CustomersListCreditsResult;
import co.commet.models.CustomersListPlanGrantsResult;
import co.commet.models.CustomersListResult;
import co.commet.models.PlanGrant;
import co.commet.params.BatchCreateCustomersParams;
import co.commet.params.CreateCustomerCreditParams;
import co.commet.params.CreateCustomerParams;
import co.commet.params.CreatePlanGrantParams;
import co.commet.params.ListCustomersParams;
import co.commet.params.RevokeCustomerCreditParams;
import co.commet.params.RevokePlanGrantParams;
import co.commet.params.UpdateCustomerParams;
import co.commet.params.UpdatePlanGrantParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class CustomersResource {

    private final CommetHttpClient http;

    public CustomersResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Revoke the unallocated remainder of a customer credit grant. Applied invoice history is unchanged.
     */
    public CustomerCreditRevocation revokeCredit(String id, String creditId, RevokeCustomerCreditParams params) {
        return http.post("/customers/" + id + "/credits/" + creditId + "/revoke", Map.of(), params.getIdempotencyKey(), new TypeReference<CustomerCreditRevocation>() {}).getData();
    }

    /**
     * List currency-specific invoice credit grants and their remaining balances for a customer.
     */
    public CustomersListCreditsResult listCredits(String id) {
        return http.get("/customers/" + id + "/credits", new TypeReference<CustomersListCreditsResult>() {}).getData();
    }

    /**
     * Grant monetary credit in one currency. Credit is applied FIFO before tax to eligible recurring invoices.
     */
    public CustomerCredit createCredit(String id, CreateCustomerCreditParams params) {
        return http.post("/customers/" + id + "/credits", buildBody(
                "amount", params.getAmount(),
                "currency", params.getCurrency(),
                "reason", params.getReason(),
                "expires_at", params.getExpiresAt()
        ), params.getIdempotencyKey(), new TypeReference<CustomerCredit>() {}).getData();
    }

    /**
     * End expanded access immediately and restore the base plan's limits. The subscription, billing cycle, invoices, and payment state remain unchanged.
     */
    public PlanGrant revokePlanGrant(String id, String grantId, RevokePlanGrantParams params) {
        return http.post("/customers/" + id + "/plan-grants/" + grantId + "/revoke", buildBody(
                "reason", params.getReason()
        ), params.getIdempotencyKey(), new TypeReference<PlanGrant>() {}).getData();
    }

    /**
     * Keep the overlay for a number of the subscription's existing billing cycles, set an exact deadline, or leave it active until revoked. The billing anchor is never reset.
     */
    public PlanGrant updatePlanGrant(String id, String grantId, UpdatePlanGrantParams params) {
        return http.patch("/customers/" + id + "/plan-grants/" + grantId, buildBody(
                "reason", params.getReason(),
                "duration", params.getDuration(),
                "duration_cycles", params.getDurationCycles(),
                "expires_at", params.getExpiresAt()
        ), params.getIdempotencyKey(), new TypeReference<PlanGrant>() {}).getData();
    }

    /**
     * List the independent audit timeline for paid-plan access granted without checkout or payment credentials.
     */
    public CustomersListPlanGrantsResult listPlanGrants(String id) {
        return http.get("/customers/" + id + "/plan-grants", new TypeReference<CustomersListPlanGrantsResult>() {}).getData();
    }

    /**
     * Temporarily expand an active subscription's feature access using a higher plan in the same plan group. Billing, prices, periods, invoices, and the base subscription remain unchanged.
     */
    public PlanGrant createPlanGrant(String id, CreatePlanGrantParams params) {
        return http.post("/customers/" + id + "/plan-grants", buildBody(
                "subscription_id", params.getSubscriptionId(),
                "plan_id", params.getPlanId(),
                "reason", params.getReason(),
                "duration", params.getDuration(),
                "duration_cycles", params.getDurationCycles(),
                "expires_at", params.getExpiresAt()
        ), params.getIdempotencyKey(), new TypeReference<PlanGrant>() {}).getData();
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
