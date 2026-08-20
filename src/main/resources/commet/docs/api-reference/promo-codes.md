# Promo Codes

API version: `2026-07-31`

## get

`commet.promoCodes().get(...)`

`GET /promo-codes/{id}` · operation `get-promo-code`

Retrieve a promo code by its public ID.

### Parameters

- `id` (`String`, required)

### Returns

`PromoCode`

## update

`commet.promoCodes().update(...)`

`PATCH /promo-codes/{id}` · operation `update-promo-code`

Update a promo code's billing interval, redemption limits, expiration, active status, or plan restrictions.

### Parameters

- `id` (`String`, required)
- `billingInterval` (`String | null`, optional)
- `maxRedemptions` (`Long | null`, optional)
- `expiresAt` (`String | null`, optional)
- `active` (`Boolean`, optional)
- `planIds` (`List<String>`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`PromoCode`

## list

`commet.promoCodes().list(...)`

`GET /promo-codes` · operation `list-promo-codes`

List promo codes with cursor-based pagination.

### Parameters

- `cursor` (`String`, optional)
- `limit` (`Long`, optional)

### Returns

`PromoCodesListResult`

## create

`commet.promoCodes().create(...)`

`POST /promo-codes` · operation `create-promo-code`

Create a distribution code for an existing Offer. The referenced Offer owns the benefit and duration; the promo code owns redemption restrictions.

### Parameters

- `code` (`String`, required)
- `offerId` (`String`, required)
- `billingInterval` (`String | null`, optional)
- `maxRedemptions` (`Long`, optional)
- `expiresAt` (`String`, optional)
- `planIds` (`List<String>`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`PromoCode`
