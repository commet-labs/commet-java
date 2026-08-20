# Plans

API version: `2026-07-31`

## updateFeature

`commet.plans().updateFeature(...)`

`PATCH /plans/{id}/features/{featureId}` · operation `update-plan-feature`

Update limits, overage, or enabled status of a feature on a plan.

### Parameters

- `id` (`String`, required)
- `featureId` (`String`, required)
- `enabled` (`Boolean`, optional)
- `includedAmount` (`Long`, optional)
- `unlimited` (`Boolean`, optional)
- `overage` (`UpdatePlanFeatureParamsOverage`, optional)
- `creditsPerUnit` (`Long | null`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`PlanFeature`

## removeFeature

`commet.plans().removeFeature(...)`

`DELETE /plans/{id}/features/{featureId}` · operation `remove-plan-feature`

Detach a feature from a plan.

### Parameters

- `id` (`String`, required)
- `featureId` (`String`, required)

### Returns

`RemovedPlanFeature`

## addFeature

`commet.plans().addFeature(...)`

`POST /plans/{id}/features` · operation `add-plan-feature`

Attach a feature to a plan with limits, overage, and credits configuration.

### Parameters

- `id` (`String`, required)
- `featureId` (`String`, required)
- `enabled` (`Boolean`, optional)
- `includedAmount` (`Long`, optional)
- `unlimited` (`Boolean`, optional)
- `overage` (`AddPlanFeatureParamsOverage`, optional)
- `creditsPerUnit` (`Long | null`, optional)
- `pricingMode` (`String`, optional)
- `margin` (`Long | null`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`PlanFeature`

## setDefaultPrice

`commet.plans().setDefaultPrice(...)`

`PUT /plans/{id}/prices/{priceId}/default` · operation `set-default-plan-price`

Set a specific price as the default and return the updated plan price.

### Parameters

- `id` (`String`, required)
- `priceId` (`String`, required)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`PlanPrice`

## setRegionalPrices

`commet.plans().setRegionalPrices(...)`

`PUT /plans/{id}/prices/{priceId}/regional` · operation `upsert-regional-prices`

Create or update regional currency price overrides for a plan price.

### Parameters

- `id` (`String`, required)
- `priceId` (`String`, required)
- `overrides` (`List<UpsertRegionalPricesParamsOverridesItem>`, required)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`PlanRegionalPricing`

## deleteRegionalPrices

`commet.plans().deleteRegionalPrices(...)`

`DELETE /plans/{id}/prices/{priceId}/regional` · operation `delete-regional-prices`

Remove all regional currency overrides for a plan price. The request is rejected while billable subscriptions depend on an override.

### Parameters

- `id` (`String`, required)
- `priceId` (`String`, required)

### Returns

`DeletedPlanRegionalPricing`

## updatePrice

`commet.plans().updatePrice(...)`

`PATCH /plans/{id}/prices/{priceId}` · operation `update-plan-price`

Update a base price or market price variant. Removing a base market override is rejected while a variant depends on it. Offer terms are managed through Offers.

### Parameters

- `id` (`String`, required)
- `priceId` (`String`, required)
- `price` (`Long`, optional)
- `isDefault` (`Boolean`, optional)
- `trialDays` (`Long`, optional)
- `includedBalance` (`Long | null`, optional)
- `includedCredits` (`Long | null`, optional)
- `metadata` (`Map<String, Object>`, optional) — Metadata keys to merge into the existing price metadata.
- `marketPrices` (`List<UpdatePlanPriceParamsMarketPricesItem>`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`PlanPrice`

## deletePrice

`commet.plans().deletePrice(...)`

`DELETE /plans/{id}/prices/{priceId}` · operation `delete-plan-price`

Archive a price for new subscriptions. Existing subscriptions that selected it continue using its current catalog value.

### Parameters

- `id` (`String`, required)
- `priceId` (`String`, required)

### Returns

`DeletedObject`

## addPrice

`commet.plans().addPrice(...)`

`POST /plans/{id}/prices` · operation `add-plan-price`

Add a base price or a selectable market price variant. Variants inherit their base price outside the markets they override. Configure introductory and promotional benefits through Offers.

### Parameters

- `id` (`String`, required)
- `billingInterval` (`String`, required)
- `metadata` (`Map<String, Object>`, optional)
- `price` (`Long`, optional)
- `trialDays` (`Long`, optional)
- `isDefault` (`Boolean`, optional)
- `includedBalance` (`Long | null`, optional)
- `includedCredits` (`Long | null`, optional)
- `marketPrices` (`List<AddPlanPriceParamsMarketPricesItem>`, optional)
- `inheritsFromPriceId` (`String`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`PlanPrice`

## setRegionalPricing

`commet.plans().setRegionalPricing(...)`

`PUT /plans/{id}/regional` · operation `set-plan-regional-pricing`

Configure regional prices and feature overage values for one currency. Currency-specific offer terms are managed through Offers.

### Parameters

- `id` (`String`, required)
- `currency` (`String`, required)
- `exchangeRate` (`Double`, required)
- `prices` (`List<SetPlanRegionalPricingParamsPricesItem>`, optional)
- `features` (`List<SetPlanRegionalPricingParamsFeaturesItem>`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`PlanRegionalPricingResult`

## get

`commet.plans().get(...)`

`GET /plans/{id}` · operation `get-plan`

Get a plan with public price IDs and their automatic introductory offer IDs.

### Parameters

- `id` (`String`, required)

### Returns

`Plan`

## update

`commet.plans().update(...)`

`PATCH /plans/{id}` · operation `update-plan`

Update a plan's name, description, visibility, or metadata.

### Parameters

- `id` (`String`, required)
- `name` (`String`, optional)
- `description` (`String | null`, optional)
- `metadata` (`Map<String, Object>`, optional)
- `isPublic` (`Boolean`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Plan`

## delete

`commet.plans().delete(...)`

`DELETE /plans/{id}` · operation `delete-plan`

Soft-delete a plan.

### Parameters

- `id` (`String`, required)

### Returns

`DeletedObject`

## setVisibility

`commet.plans().setVisibility(...)`

`PUT /plans/{id}/visibility` · operation `set-plan-visibility`

Set a plan's public visibility and return the updated plan.

### Parameters

- `id` (`String`, required)
- `isPublic` (`Boolean`, required)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Plan`

## list

`commet.plans().list(...)`

`GET /plans` · operation `list-plans`

List plans with public price IDs and their automatic introductory offer IDs.

### Parameters

- `includePrivate` (`Boolean`, optional)

### Returns

`PlansListResult`

## create

`commet.plans().create(...)`

`POST /plans` · operation `create-plan`

Create a new plan with optional consumption model, visibility, and plan group assignment.

### Parameters

- `name` (`String`, required)
- `code` (`String`, required)
- `description` (`String`, optional)
- `consumptionModel` (`String`, optional)
- `isPublic` (`Boolean`, optional)
- `isFree` (`Boolean`, optional)
- `blockOnExhaustion` (`Boolean`, optional)
- `planGroupId` (`String`, optional)
- `metadata` (`Map<String, Object>`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Plan`
