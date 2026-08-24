# Addons

API version: `2026-07-31`

## listActive

`commet.addons().listActive(...)`

`GET /active-addons` · operation `list-active-addons`

List all active add-ons for a customer's subscription.

### Parameters

- `customerId` (`String`, required)

### Returns

`AddonsListActiveResult`

## get

`commet.addons().get(...)`

`GET /addons/{id}` · operation `get-addon`

Retrieve an add-on by its public ID or slug.

### Parameters

- `id` (`String`, required)

### Returns

`Addon`

## update

`commet.addons().update(...)`

`PATCH /addons/{id}` · operation `update-addon`

Update an add-on's name, description, or pricing.

### Parameters

- `id` (`String`, required)
- `name` (`String`, optional)
- `description` (`String`, optional)
- `basePrice` (`Long`, optional)
- `includedUnits` (`Long`, optional)
- `overageRate` (`Long`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Addon`

## delete

`commet.addons().delete(...)`

`DELETE /addons/{id}` · operation `delete-addon`

Soft-delete an add-on. Fails if the add-on has active subscriptions.

### Parameters

- `id` (`String`, required)

### Returns

`DeletedObject`

## list

`commet.addons().list(...)`

`GET /addons` · operation `list-addons`

List all add-ons with cursor-based pagination.

### Parameters

- `cursor` (`String`, optional)
- `limit` (`Long`, optional)

### Returns

`AddonsListResult`

## create

`commet.addons().create(...)`

`POST /addons` · operation `create-addon`

Create a new add-on linked to a feature. Each feature can only be assigned to one add-on.

### Parameters

- `name` (`String`, required)
- `description` (`String`, optional)
- `basePrice` (`Long`, required)
- `featureId` (`String`, required)
- `consumptionModel` (`String`, required)
- `includedUnits` (`Long`, optional)
- `overageRate` (`Long`, optional)
- `creditCost` (`Long`, optional)

### Valid parameter combinations

- `name` + `basePrice` + `featureId` + `consumptionModel`
- `name` + `basePrice` + `featureId` + `consumptionModel` + `includedUnits` + `overageRate`
- `name` + `basePrice` + `featureId` + `consumptionModel` + `creditCost`
- `name` + `basePrice` + `featureId` + `consumptionModel` + `overageRate`

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Addon`
