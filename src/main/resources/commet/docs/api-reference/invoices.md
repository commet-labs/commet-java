# Invoices

API version: `2026-07-31`

## getDownloadUrl

`commet.invoices().getDownloadUrl(...)`

`POST /invoices/{id}/download-links` · operation `download-invoice`

Generate a signed URL to download the invoice as a PDF. The URL expires after 7 days.

### Parameters

- `id` (`String`, required)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`InvoiceDownload`

## get

`commet.invoices().get(...)`

`GET /invoices/{id}` · operation `get-invoice`

Retrieve a single invoice by its public ID, including line items.

### Parameters

- `id` (`String`, required)

### Returns

`Invoice`

## send

`commet.invoices().send(...)`

`POST /invoices/{id}/send` · operation `send-invoice`

Send the invoice to the customer via email.

### Parameters

- `id` (`String`, required)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`SentInvoice`

## updateStatus

`commet.invoices().updateStatus(...)`

`PATCH /invoices/{id}/status` · operation `update-invoice-status`

Mark an outstanding invoice as "paid" or "void" and return the updated invoice. Cannot change the status of already paid or voided invoices.

### Parameters

- `id` (`String`, required)
- `status` (`String`, required)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Invoice`

## list

`commet.invoices().list(...)`

`GET /invoices` · operation `list-invoices`

List invoices with cursor-based pagination. Filter by customer, status, or subscription.

### Parameters

- `cursor` (`String`, optional)
- `limit` (`Long`, optional)
- `customerId` (`String`, optional)
- `status` (`String`, optional)
- `subscriptionId` (`String`, optional)

### Returns

`InvoicesListResult`

## createAdjustment

`commet.invoices().createAdjustment(...)`

`POST /invoices` · operation `create-adjustment-invoice`

Create a one-off adjustment invoice and return the created invoice. Use a negative amount for a credit.

### Parameters

- `customerId` (`String`, required)
- `amount` (`Long`, required)
- `description` (`String`, required)
- `metadata` (`Map<String, Object>`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Invoice`
