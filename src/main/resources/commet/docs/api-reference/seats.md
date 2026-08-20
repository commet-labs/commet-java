# Seats

API version: `2026-07-31`

## getBalance

`commet.seats().getBalance(...)`

`GET /seats/balance` · operation `get-seat-balance`

Get current balance for a specific seat type.

### Parameters

- `customerId` (`String`, required)
- `featureCode` (`String`, required)

### Returns

`SeatBalance`

## getAllBalances

`commet.seats().getAllBalances(...)`

`GET /seats/balances` · operation `get-all-seat-balances`

Get the current balance for all seat types in a customer's subscription.

### Parameters

- `customerId` (`String`, required)

### Returns

`SeatBalanceCollection`

## setAll

`commet.seats().setAll(...)`

`PUT /seats/bulk` · operation `bulk-set-seats`

Set all seat types at once.

### Parameters

- `customerId` (`String`, required)
- `seats` (`Map<String, Long>`, required)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`SeatsSetAllResult`

## remove

`commet.seats().remove(...)`

`POST /seats/remove` · operation `remove-seats`

Remove seats from a customer's subscription. Takes effect at the end of the billing period.

### Parameters

- `customerId` (`String`, required)
- `featureCode` (`String`, required)
- `count` (`Long`, required)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`SeatEvent`

## add

`commet.seats().add(...)`

`POST /seats` · operation `add-seats`

Add seats to a customer's subscription. Prorates charges for the current billing period.

### Parameters

- `customerId` (`String`, required)
- `featureCode` (`String`, required)
- `count` (`Long`, required)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`SeatEvent`

## set

`commet.seats().set(...)`

`PUT /seats` · operation `set-seats`

Set seats to an exact count.

### Parameters

- `customerId` (`String`, required)
- `featureCode` (`String`, required)
- `count` (`Long`, required)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`SeatEvent`
