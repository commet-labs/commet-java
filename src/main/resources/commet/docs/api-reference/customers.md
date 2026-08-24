# Customers

API version: `2026-07-31`

## revokeCredit

`commet.customers().revokeCredit(...)`

`POST /customers/{id}/credits/{creditId}/revoke` · operation `revoke-customer-credit`

Revoke the unallocated remainder of a customer credit grant. Applied invoice history is unchanged.

### Parameters

- `id` (`String`, required)
- `creditId` (`String`, required)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`CustomerCreditRevocation`

## listCredits

`commet.customers().listCredits(...)`

`GET /customers/{id}/credits` · operation `list-customer-credits`

List currency-specific invoice credit grants and their remaining balances for a customer.

### Parameters

- `id` (`String`, required)

### Returns

`CustomersListCreditsResult`

## createCredit

`commet.customers().createCredit(...)`

`POST /customers/{id}/credits` · operation `create-customer-credit`

Grant monetary credit in one currency. Credit is applied FIFO before tax to eligible recurring invoices.

### Parameters

- `id` (`String`, required)
- `amount` (`Long`, required) — Amount in the currency's smallest unit.
- `currency` (`String`, required)
- `reason` (`String`, required)
- `expiresAt` (`String | null`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`CustomerCredit`

## revokePlanGrant

`commet.customers().revokePlanGrant(...)`

`POST /customers/{id}/plan-grants/{grantId}/revoke` · operation `revoke-plan-grant`

End expanded access immediately and restore the base plan's limits. The subscription, billing cycle, invoices, and payment state remain unchanged.

### Parameters

- `id` (`String`, required)
- `grantId` (`String`, required)
- `reason` (`String`, required)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`PlanGrant`

## updatePlanGrant

`commet.customers().updatePlanGrant(...)`

`PATCH /customers/{id}/plan-grants/{grantId}` · operation `update-plan-grant`

Keep the overlay for a number of the subscription's existing billing cycles, set an exact deadline, or leave it active until revoked. The billing anchor is never reset.

### Parameters

- `id` (`String`, required)
- `grantId` (`String`, required)
- `reason` (`String`, required)
- `duration` (`String`, required)
- `durationCycles` (`Long`, optional)
- `expiresAt` (`String`, optional)

### Valid parameter combinations

- `reason` + `duration` + `durationCycles`
- `reason` + `duration` + `expiresAt`
- `reason` + `duration`

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`PlanGrant`

## listPlanGrants

`commet.customers().listPlanGrants(...)`

`GET /customers/{id}/plan-grants` · operation `list-plan-grants`

List the independent audit timeline for paid-plan access granted without checkout or payment credentials.

### Parameters

- `id` (`String`, required)

### Returns

`CustomersListPlanGrantsResult`

## createPlanGrant

`commet.customers().createPlanGrant(...)`

`POST /customers/{id}/plan-grants` · operation `create-plan-grant`

Temporarily expand an active subscription's feature access using a higher plan in the same plan group. Billing, prices, periods, invoices, and the base subscription remain unchanged.

### Parameters

- `id` (`String`, required)
- `subscriptionId` (`String`, required)
- `planId` (`String`, required)
- `reason` (`String`, required)
- `duration` (`String`, required)
- `durationCycles` (`Long`, optional)
- `expiresAt` (`String`, optional)

### Valid parameter combinations

- `subscriptionId` + `planId` + `reason` + `duration` + `durationCycles`
- `subscriptionId` + `planId` + `reason` + `duration` + `expiresAt`
- `subscriptionId` + `planId` + `reason` + `duration`

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`PlanGrant`

## get

`commet.customers().get(...)`

`GET /customers/{id}` · operation `get-customer`

Retrieve a customer by their public ID, including subscription status and metadata.

### Parameters

- `id` (`String`, required)

### Returns

`Customer`

## update

`commet.customers().update(...)`

`PATCH /customers/{id}` · operation `update-customer`

Update a customer's name, external ID, or metadata.

### Parameters

- `id` (`String`, required)
- `email` (`String`, optional)
- `fullName` (`String`, optional)
- `taxDocument` (`String`, optional)
- `externalId` (`String`, optional)
- `timezone` (`Timezone`, optional)
- `metadata` (`Map<String, Object>`, optional)
- `address` (`UpdateCustomerParamsAddress`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Customer`

## createBatch

`commet.customers().createBatch(...)`

`POST /customers/batch` · operation `batch-create-customers`

Create up to 100 customers in a single request.

### Parameters

- `customers` (`List<BatchCreateCustomersParamsCustomersItem>`, required)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`CustomerBatch`

## list

`commet.customers().list(...)`

`GET /customers` · operation `list-customers`

List customers with cursor-based pagination.

### Parameters

- `cursor` (`String`, optional)
- `limit` (`Long`, optional)
- `externalId` (`String`, optional)

### Returns

`CustomersListResult`

## create

`commet.customers().create(...)`

`POST /customers` · operation `create-customer`

Create a new customer. Idempotent when customerId is provided.

### Parameters

- `id` (`String`, optional)
- `externalId` (`String`, optional)
- `fullName` (`String`, optional)
- `taxDocument` (`String`, optional)
- `address` (`CreateCustomerParamsAddress`, optional)
- `addressId` (`String`, optional)
- `email` (`String`, required)
- `timezone` (`Timezone`, optional)
- `metadata` (`Map<String, Object>`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Customer`
