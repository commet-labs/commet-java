# Usage

API version: `2026-07-31`

## check

`commet.usage().check(...)`

`POST /usage/check` · operation `check-usage-availability`

Check if a customer can consume a feature before actual consumption. Returns availability and cost estimates based on the plan's consumption model.

### Parameters

- `customerId` (`String`, required)
- `featureCode` (`String`, required)
- `quantity` (`Long`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`UsageCheck`

## track

`commet.usage().track(...)`

`POST /usage/events` · operation `track-usage`

Track a usage event for a metered feature. Deducts from balance/credits if applicable.

### Parameters

- `featureCode` (`String`, required)
- `customerId` (`String`, required)
- `eventId` (`String`, optional)
- `timestamp` (`String`, optional)
- `properties` (`List<TrackUsageParamsPropertiesItem>`, optional)
- `model` (`String`, optional)
- `inputTokens` (`Long`, optional)
- `outputTokens` (`Long`, optional)
- `value` (`Double`, optional)
- `cacheReadTokens` (`Long`, optional)
- `cacheWriteTokens` (`Long`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`UsageEvent`

## set

`commet.usage().set(...)`

`PUT /usage` · operation `set-usage`

Set a metered feature's usage to an exact value for the current period. Use the Idempotency-Key header to make retries safe.

### Parameters

- `customerId` (`String`, required)
- `featureCode` (`String`, required)
- `value` (`Long`, required)
- `reason` (`String`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`UsageAdjustment`
