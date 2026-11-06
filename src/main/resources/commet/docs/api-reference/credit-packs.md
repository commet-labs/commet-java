# Credit Packs

API version: `2026-08-27`

## update

`commet.creditPacks().update(...)`

`PATCH /credit-packs/{id}` · operation `update-credit-pack`

Update a credit pack's name, description, credits, price, active status, or the plans that sell it.

### Parameters

- `id` (`String`, required)
- `name` (`String`, optional)
- `description` (`String`, optional)
- `credits` (`Long`, optional)
- `price` (`Long`, optional)
- `isActive` (`Boolean`, optional)
- `planIds` (`List<String>`, optional) — Plans that sell the credit pack, replacing the current ones. Empty means every plan; omitted keeps them.

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
- `planIds` (`List<String>`, optional) — Plans that sell the credit pack. Omitted or empty, every plan sells it. Plans created later sell it too.

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`CreditPack`
