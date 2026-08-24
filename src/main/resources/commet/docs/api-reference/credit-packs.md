# Credit Packs

API version: `2026-07-31`

## update

`commet.creditPacks().update(...)`

`PATCH /credit-packs/{id}` · operation `update-credit-pack`

Update a credit pack's name, description, credits, price, or active status.

### Parameters

- `id` (`String`, required)
- `name` (`String`, optional)
- `description` (`String`, optional)
- `credits` (`Long`, optional)
- `price` (`Long`, optional)
- `isActive` (`Boolean`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`CreditPack`

## delete

`commet.creditPacks().delete(...)`

`DELETE /credit-packs/{id}` · operation `delete-credit-pack`

Soft-delete a credit pack.

### Parameters

- `id` (`String`, required)

### Returns

`DeletedObject`

## list

`commet.creditPacks().list(...)`

`GET /credit-packs` · operation `list-credit-packs`

List all active credit packs.

### Returns

`CreditPacksListResult`

## create

`commet.creditPacks().create(...)`

`POST /credit-packs` · operation `create-credit-pack`

Create a new credit pack.

### Parameters

- `name` (`String`, required)
- `description` (`String`, optional)
- `credits` (`Long`, required)
- `price` (`Long`, required)
- `isActive` (`Boolean`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`CreditPack`
