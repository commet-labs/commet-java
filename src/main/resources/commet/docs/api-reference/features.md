# Features

API version: `2026-08-27`

## get

`commet.features().get(...)`

`GET /features/{code}` · operation `get-feature`

Get a single feature definition by code from the organization's feature catalog.

### Parameters

- `code` (`String`, required)

### Returns

`Feature`

## update

`commet.features().update(...)`

`PATCH /features/{code}` · operation `update-feature`

Update a feature's name, description, or unit name. At least one field must be provided.

### Parameters

- `code` (`String`, required)
- `name` (`String`, optional)
- `description` (`String | null`, optional)
- `unitName` (`String | null`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Feature`

## delete

`commet.features().delete(...)`

`DELETE /features/{code}` · operation `delete-feature`

Delete a feature. Fails while a plan's current version, a running experiment or a draft includes it, or while it has an active add-on. Subscribers whose plan version includes it keep it, and its code can be used by a new feature right away.

### Parameters

- `code` (`String`, required)

### Returns

`DeletedObject`

## list

`commet.features().list(...)`

`GET /features` · operation `list-features`

List every feature defined in the organization. This is the organization's feature catalog (definitions), not a customer's feature access.

### Returns

`FeaturesListResult`

## create

`commet.features().create(...)`

`POST /features` · operation `create-feature`

Create a new feature. Code must be lowercase alphanumeric with underscores.

### Parameters

- `name` (`String`, required)
- `code` (`String`, required)
- `type` (`String`, required)
- `description` (`String`, optional)
- `unitName` (`String`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Feature`
