# Offers

API version: `2026-07-31`

## get

`commet.offers().get(...)`

`GET /offers/{id}` · operation `get-offer`

Retrieve reusable offer terms by public ID.

### Parameters

- `id` (`String`, required)

### Returns

`Offer`

## update

`commet.offers().update(...)`

`PATCH /offers/{id}` · operation `update-offer`

Replace reusable offer terms. Existing applications keep their immutable accepted terms.

### Parameters

- `id` (`String`, required)
- `name` (`String`, required)
- `phases` (`List<UpdateOfferParamsPhasesItem>`, required)
- `metadata` (`Map<String, Object>`, optional)
- `startsAt` (`String | null`, optional)
- `endsAt` (`String | null`, optional)
- `active` (`Boolean`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Offer`

## delete

`commet.offers().delete(...)`

`DELETE /offers/{id}` · operation `delete-offer`

Soft-delete an Offer. Existing applications and their accepted terms remain available for billing and audit.

### Parameters

- `id` (`String`, required)

### Returns

`DeletedOffer`

## list

`commet.offers().list(...)`

`GET /offers` · operation `list-offers`

List reusable offer terms. Offers are independent from plans, prices, eligibility, and distribution channels.

### Parameters

- `cursor` (`String`, optional)
- `limit` (`Long`, optional)
- `active` (`Boolean`, optional)

### Returns

`OffersListResult`

## create

`commet.offers().create(...)`

`POST /offers` · operation `create-offer`

Create reusable offer terms without assigning a plan, price, eligibility rule, or distribution channel.

### Parameters

- `name` (`String`, required)
- `phases` (`List<CreateOfferParamsPhasesItem>`, required)
- `metadata` (`Map<String, Object>`, optional)
- `startsAt` (`String | null`, optional)
- `endsAt` (`String | null`, optional)
- `active` (`Boolean`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Offer`
