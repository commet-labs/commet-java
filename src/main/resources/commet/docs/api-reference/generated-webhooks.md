# Webhooks

API version: `2026-07-31`

## get

`commet.webhooks().get(...)`

`GET /webhooks/{id}` · operation `get-webhook-endpoint`

Retrieve a webhook endpoint by its public ID.

### Parameters

- `id` (`String`, required)

### Returns

`Webhook`

## update

`commet.webhooks().update(...)`

`PATCH /webhooks/{id}` · operation `update-webhook-endpoint`

Update a webhook endpoint. Only the provided fields change.

### Parameters

- `id` (`String`, required)
- `url` (`String`, optional)
- `events` (`List<String>`, optional)
- `description` (`String | null`, optional)
- `isActive` (`Boolean`, optional)
- `apiVersion` (`String`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Webhook`

## delete

`commet.webhooks().delete(...)`

`DELETE /webhooks/{id}` · operation `delete-webhook-endpoint`

Permanently delete a webhook endpoint.

### Parameters

- `id` (`String`, required)

### Returns

`DeletedObject`

## test

`commet.webhooks().test(...)`

`POST /webhooks/{id}/test` · operation `test-webhook-endpoint`

Send a test event to a webhook endpoint to verify connectivity.

### Parameters

- `id` (`String`, required)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`WebhookTest`

## list

`commet.webhooks().list(...)`

`GET /webhooks` · operation `list-webhook-endpoints`

List webhook endpoints with cursor-based pagination.

### Parameters

- `cursor` (`String`, optional)
- `limit` (`Long`, optional)

### Returns

`WebhooksListResult`

## create

`commet.webhooks().create(...)`

`POST /webhooks` · operation `create-webhook-endpoint`

Create a new webhook endpoint. The response includes the signing secret which is only returned once.

### Parameters

- `url` (`String`, required)
- `events` (`List<String>`, required)
- `description` (`String`, optional)
- `apiVersion` (`String`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`CreatedWebhook`
