# Quota

API version: `2026-07-31`

## getAll

`commet.quota().getAll(...)`

`GET /usage/quota/all` · operation `get-all-quota-allowances`

Get all quota allowances for a customer across every quota feature in their plan.

### Parameters

- `customerId` (`String`, required)

### Returns

`QuotaGetAllResult`

## remove

`commet.quota().remove(...)`

`POST /usage/quota/remove` · operation `remove-quota`

Remove from a customer's quota allowance for a feature. Defaults to 1 if count is omitted. Returns 400 insufficient_balance if the balance would go negative.

### Parameters

- `featureCode` (`String`, required)
- `count` (`Long`, optional)
- `customerId` (`String`, optional)
- `externalId` (`String`, optional)

### Valid parameter combinations

- `featureCode` + `customerId`
- `featureCode` + `externalId`

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`UsageQuotaEvent`

## get

`commet.quota().get(...)`

`GET /usage/quota` · operation `get-quota-allowance`

Get the current quota allowance (used vs included) for a specific feature.

### Parameters

- `customerId` (`String`, required)
- `featureCode` (`String`, required)

### Returns

`UsageQuota`

## add

`commet.quota().add(...)`

`POST /usage/quota` · operation `add-quota`

Add to a customer's quota allowance for a feature. Defaults to 1 if count is omitted.

### Parameters

- `featureCode` (`String`, required)
- `count` (`Long`, optional)
- `customerId` (`String`, optional)
- `externalId` (`String`, optional)

### Valid parameter combinations

- `featureCode` + `customerId`
- `featureCode` + `externalId`

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`UsageQuotaEvent`

## set

`commet.quota().set(...)`

`PUT /usage/quota` · operation `set-quota`

Set a customer's quota allowance for a feature to an exact value.

### Parameters

- `featureCode` (`String`, required)
- `count` (`Long`, required)
- `customerId` (`String`, optional)
- `externalId` (`String`, optional)

### Valid parameter combinations

- `featureCode` + `count` + `customerId`
- `featureCode` + `count` + `externalId`

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`UsageQuotaEvent`
