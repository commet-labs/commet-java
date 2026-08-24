# Schemas

Generated from Commet API version `2026-07-31`.

## Enums

### BillingInterval

- `"weekly"`
- `"monthly"`
- `"quarterly"`
- `"yearly"`
- `"one_time"`

### ConsumptionModel

- `"metered"`
- `"credits"`
- `"balance"`

### FeatureType

- `"boolean"`
- `"usage"`
- `"seats"`
- `"quota"`

### InvoiceType

- `"recurring"`
- `"overage"`
- `"plan_change"`
- `"adjustment"`
- `"credit_purchase"`
- `"balance_topup"`
- `"addon_activation"`
- `"one_time_payment"`
- `"reactivation"`

### PaymentProvider

- `"stripe"`
- `"commet"`
- `"dlocal"`

### SubscriptionStatus

- `"draft"`
- `"pending_payment"`
- `"trialing"`
- `"active"`
- `"past_due"`
- `"canceled"`

### Timezone

- `"UTC"`
- `"America/New_York"`
- `"America/Chicago"`
- `"America/Denver"`
- `"America/Los_Angeles"`
- `"America/Sao_Paulo"`
- `"America/Mexico_City"`
- `"America/Buenos_Aires"`
- `"America/Santiago"`
- `"America/Bogota"`
- `"America/Lima"`
- `"America/Asuncion"`
- `"Europe/London"`
- `"Europe/Paris"`
- `"Europe/Berlin"`
- `"Europe/Madrid"`
- `"Asia/Tokyo"`
- `"Asia/Shanghai"`
- `"Asia/Singapore"`
- `"Asia/Dubai"`
- `"Australia/Sydney"`

### TransactionStatus

- `"pending"`
- `"succeeded"`
- `"failed"`
- `"refunded"`
- `"disputed"`

## Models

### ActiveAddon

- `slug` (`String`, required)
- `name` (`String`, required)
- `basePrice` (`Long`, required)
- `featureCode` (`String`, required)
- `featureName` (`String`, required)
- `featureType` (`FeatureType`, required)
- `consumptionModel` (`String`, required)
- `activatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### AddedPlanToGroup

- `success` (`Boolean`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### Addon

- `id` (`String`, required)
- `name` (`String`, required)
- `slug` (`String`, required)
- `description` (`String | null`, required)
- `basePrice` (`Long`, required)
- `featureCode` (`String`, required)
- `featureName` (`String`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `consumptionModel` (`String`, required)
- `includedUnits` (`Long | null`, required)
- `overageRate` (`Long | null`, required)
- `creditCost` (`Long | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### AddonsListActiveResult

- `object` (`String`, required)
- `data` (`List<ActiveAddon>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### AddonsListResult

- `object` (`String`, required)
- `data` (`List<Addon>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### AddPlanFeatureParamsOverage

- `enabled` (`Boolean`, optional)
- `unitPrice` (`Long`, optional)

### AddPlanPriceParamsMarketPricesItem

- `marketGroupId` (`String`, required) — Public ID of a reusable pricing market group.
- `currency` (`String`, required) — Presentment currency configured for this plan and market.
- `price` (`Long`, required) — Market price in the currency's minor unit.

### ApiKey

- `id` (`String`, required)
- `name` (`String`, required)
- `prefix` (`String`, required)
- `expiresAt` (`String | null`, required)
- `lastUsedAt` (`String | null`, required)
- `createdAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### ApiKeysListResult

- `object` (`String`, required)
- `data` (`List<ApiKey>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### BalanceAdjustment

- `amount` (`Long`, required)
- `newBalance` (`Long`, required)
- `reason` (`String | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### BalanceTopup

- `amount` (`Long`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### BatchCreateCustomersParamsCustomersItem

- `email` (`String`, required)
- `id` (`String`, optional)
- `externalId` (`String`, optional)
- `fullName` (`String`, optional)
- `taxDocument` (`String`, optional)
- `timezone` (`Timezone`, optional)
- `metadata` (`Map<String, Object>`, optional)
- `address` (`BatchCreateCustomersParamsCustomersItemAddress`, optional)

### BatchCreateCustomersParamsCustomersItemAddress

- `line1` (`String`, required)
- `line2` (`String`, optional)
- `city` (`String`, required)
- `state` (`String`, optional)
- `postalCode` (`String`, required)
- `country` (`String`, required)
- `region` (`String`, optional)

### ClaimLink

- `url` (`String`, required)
- `expiresAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### CreateCustomerParamsAddress

- `line1` (`String`, required)
- `line2` (`String`, optional)
- `city` (`String`, required)
- `state` (`String`, optional)
- `postalCode` (`String`, required)
- `country` (`String`, required)
- `region` (`String`, optional)

### CreatedApiKey

- `id` (`String`, required)
- `name` (`String`, required)
- `apiKey` (`String`, required)
- `prefix` (`String`, required)
- `expiresAt` (`String`, required)
- `createdAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### CreatedSubscription

- `id` (`String`, required)
- `customerId` (`String`, required)
- `plan` (`CreatedSubscriptionPlan`, required)
- `name` (`String`, required)
- `description` (`String | null`, required)
- `status` (`SubscriptionStatus`, required)
- `billingInterval` (`BillingInterval | null`, required)
- `trialEndsAt` (`String | null`, required)
- `currentPeriod` (`CreatedSubscriptionCurrentPeriod | null`, required)
- `cancellation` (`CreatedSubscriptionCancellation | null`, required)
- `cancelAtPeriodEnd` (`Boolean`, required)
- `scheduledPlanChange` (`CreatedSubscriptionScheduledPlanChange | null`, required)
- `startDate` (`String`, required)
- `endDate` (`String | null`, required)
- `billingDayOfMonth` (`Long | null`, required)
- `nextBillingDate` (`String | null`, required)
- `checkoutUrl` (`String | null`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `offerApplications` (`List<SubscriptionOfferApplication>`, required)
- `checkoutProvider` (`PaymentProvider | null`, required) — Payment provider resolved for this checkout when the subscription response was created. This is an informational snapshot and may differ when the checkout is loaded if its country or the organization's routing changes.
- `priceId` (`String | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### CreatedSubscriptionCancellation

- `scheduledAt` (`String`, required)
- `reason` (`String | null`, required)
- `effectiveAt` (`String`, required)

### CreatedSubscriptionCurrentPeriod

- `start` (`String`, required)
- `end` (`String`, required)
- `daysRemaining` (`Double`, required)

### CreatedSubscriptionPlan

- `id` (`String`, required)
- `name` (`String`, required)

### CreatedSubscriptionScheduledPlanChange

- `changeType` (`String`, required)
- `newPlanId` (`String | null`, required)
- `newPlanName` (`String | null`, required)
- `newBillingInterval` (`String | null`, required)
- `scheduledFor` (`String`, required)

### CreatedWebhook

- `id` (`String`, required)
- `url` (`String`, required)
- `events` (`List<String>`, required)
- `description` (`String | null`, required)
- `isActive` (`Boolean`, required)
- `apiVersion` (`String | null`, required)
- `createdAt` (`String`, required)
- `secretKey` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### CreateOfferParamsPhasesItem

Variants:

- `CreateOfferParamsPhasesItemVariant1`
- `CreateOfferParamsPhasesItemVariant2`
- `CreateOfferParamsPhasesItemVariant3`
- `CreateOfferParamsPhasesItemVariant4`

Discriminator: `type`

- `"free_trial"` → `CreateOfferParamsPhasesItemVariant1`
- `"percentage"` → `CreateOfferParamsPhasesItemVariant2`
- `"amount_off"` → `CreateOfferParamsPhasesItemVariant3`
- `"fixed_price"` → `CreateOfferParamsPhasesItemVariant4`

### CreateOfferParamsPhasesItemVariant1

- `type` (`String`, required)
- `durationDays` (`Long`, required)

### CreateOfferParamsPhasesItemVariant2

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, optional) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `percentage` (`Long`, required) — Discount in basis points. 5000 means 50%.

### CreateOfferParamsPhasesItemVariant3

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, optional) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `amounts` (`List<CreateOfferParamsPhasesItemVariant3AmountsItem>`, required)

### CreateOfferParamsPhasesItemVariant3AmountsItem

- `currency` (`String`, required)
- `amount` (`Long`, required) — Amount in the currency's minor unit (for example, cents for USD).

### CreateOfferParamsPhasesItemVariant4

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, optional) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `prices` (`List<CreateOfferParamsPhasesItemVariant4PricesItem>`, required)

### CreateOfferParamsPhasesItemVariant4PricesItem

- `currency` (`String`, required)
- `amount` (`Long`, required) — Amount in the currency's minor unit (for example, cents for USD).

### CreditGrant

- `credits` (`Long`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### CreditPack

- `id` (`String`, required)
- `name` (`String`, required)
- `description` (`String | null`, required)
- `credits` (`Long`, required)
- `price` (`Long`, required)
- `isActive` (`Boolean`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### CreditPackListItem

- `id` (`String`, required)
- `name` (`String`, required)
- `description` (`String | null`, required)
- `credits` (`Long`, required)
- `price` (`Long`, required)
- `currency` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### CreditPacksListResult

- `object` (`String`, required)
- `data` (`List<CreditPackListItem>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### Customer

- `id` (`String`, required)
- `externalId` (`String | null`, required)
- `fullName` (`String | null`, required)
- `email` (`String`, required)
- `taxDocument` (`String | null`, required)
- `documentType` (`String | null`, required)
- `timezone` (`String | null`, required)
- `metadata` (`Map<String, Object> | null`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### CustomerBatch

- `successful` (`List<CustomerBatchSuccessfulItem>`, required)
- `failed` (`List<CustomerBatchFailedItem>`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### CustomerBatchFailedItem

- `index` (`Long`, required)
- `error` (`String`, required)
- `data` (`CustomerBatchFailedItemData`, required)

### CustomerBatchFailedItemData

- `id` (`String`, optional)
- `externalId` (`String`, optional)
- `email` (`String`, required)
- `fullName` (`String | null`, optional)
- `taxDocument` (`String | null`, optional)
- `timezone` (`String`, optional)
- `metadata` (`Map<String, Object> | null`, optional)
- `address` (`CustomerBatchFailedItemDataAddress`, optional)

### CustomerBatchFailedItemDataAddress

- `line1` (`String`, required)
- `line2` (`String`, optional)
- `city` (`String`, required)
- `state` (`String`, optional)
- `postalCode` (`String`, required)
- `country` (`String`, required)
- `region` (`String`, optional)

### CustomerBatchSuccessfulItem

- `id` (`String`, required)
- `externalId` (`String | null`, required)
- `email` (`String`, required)

### CustomerCredit

- `id` (`String`, required)
- `amount` (`Long`, required) — Original grant amount in the currency's smallest unit.
- `appliedAmount` (`Long`, required)
- `reversedAmount` (`Long`, required)
- `revokedAmount` (`Long`, required)
- `remainingAmount` (`Long`, required)
- `currency` (`String`, required)
- `reason` (`String`, required)
- `source` (`String`, required)
- `expiresAt` (`String | null`, required)
- `createdAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### CustomerCreditRevocation

- `id` (`String`, required)
- `remainingAmount` (`Long`, required)
- `revokedAmount` (`Long`, required)
- `currency` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### CustomersListCreditsResult

- `object` (`String`, required)
- `data` (`List<CustomerCredit>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### CustomersListPlanGrantsResult

- `object` (`String`, required)
- `data` (`List<PlanGrant>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### CustomersListResult

- `object` (`String`, required)
- `data` (`List<Customer>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### DeletedObject

- `id` (`String`, required)
- `deleted` (`Object`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### DeletedOffer

- `deleted` (`Object`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### DeletedPlanRegionalPricing

- `deleted` (`Object`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### DeletedSubscriptionAddon

- `id` (`String`, required)
- `status` (`String`, required)
- `deactivatedAt` (`String | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### Feature

- `id` (`String`, required)
- `name` (`String`, required)
- `code` (`String`, required)
- `type` (`FeatureType`, required)
- `description` (`String | null`, required)
- `unitName` (`String | null`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### FeatureAccess

Variants:

- `FeatureAccessVariant1`
- `FeatureAccessVariant2`
- `FeatureAccessVariant3`
- `FeatureAccessVariant4`

Discriminator: `type`

- `"boolean"` → `FeatureAccessVariant1`
- `"usage"` → `FeatureAccessVariant2`
- `"seats"` → `FeatureAccessVariant3`
- `"quota"` → `FeatureAccessVariant4`

### FeatureAccessListResult

- `object` (`String`, required)
- `data` (`List<FeatureAccess>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### FeatureAccessVariant1

- `code` (`String`, required) — Unique feature code.
- `name` (`String`, required) — Display name of the feature.
- `unitName` (`String | null`, required) — Display name for one product unit, or null when not applicable.
- `allowed` (`Boolean`, required) — Whether the customer can currently access or consume the feature.
- `type` (`String`, required)
- `enabled` (`Boolean`, required) — Whether the feature is enabled.
- `baseAccess` (`FeatureAccessVariant1BaseAccess | null`, optional)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### FeatureAccessVariant1BaseAccess

- `enabled` (`Boolean`, required)

### FeatureAccessVariant2

- `code` (`String`, required) — Unique feature code.
- `name` (`String`, required) — Display name of the feature.
- `unitName` (`String | null`, required) — Display name for one product unit, or null when not applicable.
- `allowed` (`Boolean`, required) — Whether the customer can currently access or consume the feature.
- `type` (`String`, required)
- `consumption` (`FeatureAccessVariant2Consumption`, required)
- `baseAccess` (`FeatureAccessVariant2BaseAccess | null`, optional)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### FeatureAccessVariant2BaseAccess

- `includedUnits` (`Double`, required)
- `unlimited` (`Boolean`, required)

### FeatureAccessVariant2Consumption

Variants:

- `FeatureAccessVariant2ConsumptionVariant1`
- `FeatureAccessVariant2ConsumptionVariant2`
- `FeatureAccessVariant2ConsumptionVariant3`

Discriminator: `model`

- `"metered"` → `FeatureAccessVariant2ConsumptionVariant1`
- `"credits"` → `FeatureAccessVariant2ConsumptionVariant2`
- `"balance"` → `FeatureAccessVariant2ConsumptionVariant3`

### FeatureAccessVariant2ConsumptionVariant1

- `model` (`String`, required) — Usage is measured against an included allowance and overage.
- `period` (`FeatureAccessVariant2ConsumptionVariant1Period`, required) — Time range used to calculate this feature's consumption.
- `unitsUsed` (`Double`, required) — Product units recorded during the period.
- `includedUnits` (`Double`, required) — Product units included in the subscription for the period.
- `remainingUnits` (`Double`, optional) — Included units not yet consumed. Absent when usage is unlimited.
- `unlimited` (`Boolean`, required) — Whether the feature has no usage limit.
- `overage` (`FeatureAccessVariant2ConsumptionVariant1Overage`, required)

### FeatureAccessVariant2ConsumptionVariant1Overage

- `enabled` (`Boolean`, required) — Whether usage above the included amount is allowed and billed.
- `units` (`Double`, required) — Units consumed above the included amount.
- `unitPrice` (`FeatureAccessVariant2ConsumptionVariant1OverageUnitPrice`, optional) — Price for one additional product unit.

### FeatureAccessVariant2ConsumptionVariant1OverageUnitPrice

- `amount` (`Long`, required) — Integer rate amount. Divide by scale to obtain the price.
- `currency` (`String`, required) — Lowercase ISO 4217 currency code.
- `scale` (`Object`, required) — Divide amount by scale to obtain the major-unit price.

### FeatureAccessVariant2ConsumptionVariant1Period

- `start` (`String`, required) — Inclusive usage period start.
- `end` (`String`, required) — Exclusive usage period end.

### FeatureAccessVariant2ConsumptionVariant2

- `model` (`String`, required) — Product usage consumes credits from a shared pool.
- `period` (`FeatureAccessVariant2ConsumptionVariant2Period`, required) — Time range used to calculate this feature's consumption.
- `unitsUsed` (`Double`, required) — Product units recorded during the period.
- `creditsPerUnit` (`Long`, required) — Credits deducted for each product unit.
- `creditsConsumed` (`Double`, required) — Actual credits deducted by this feature during the period.
- `availableUnits` (`Long`, required) — Additional product units available from the current shared credit pool at this feature's conversion rate.

### FeatureAccessVariant2ConsumptionVariant2Period

- `start` (`String`, required) — Inclusive usage period start.
- `end` (`String`, required) — Exclusive usage period end.

### FeatureAccessVariant2ConsumptionVariant3

- `model` (`String`, required) — Product usage deducts money from a shared balance.
- `period` (`FeatureAccessVariant2ConsumptionVariant3Period`, required) — Time range used to calculate this feature's consumption.
- `unitsUsed` (`Double`, required) — Product units recorded during the period.
- `spent` (`FeatureAccessVariant2ConsumptionVariant3Spent`, required) — Actual money deducted for this feature during the period.
- `availableUnits` (`Long`, optional) — Estimated additional units available from the current shared balance at this feature's fixed price. Absent for dynamic pricing.
- `unitPrice` (`FeatureAccessVariant2ConsumptionVariant3UnitPrice`, optional) — Price for one additional product unit.

### FeatureAccessVariant2ConsumptionVariant3Period

- `start` (`String`, required) — Inclusive usage period start.
- `end` (`String`, required) — Exclusive usage period end.

### FeatureAccessVariant2ConsumptionVariant3Spent

- `amount` (`Long`, required) — Amount in the currency's smallest unit.
- `currency` (`String`, required) — Lowercase ISO 4217 currency code.

### FeatureAccessVariant2ConsumptionVariant3UnitPrice

- `amount` (`Long`, required) — Integer rate amount. Divide by scale to obtain the price.
- `currency` (`String`, required) — Lowercase ISO 4217 currency code.
- `scale` (`Object`, required) — Divide amount by scale to obtain the major-unit price.

### FeatureAccessVariant3

- `code` (`String`, required) — Unique feature code.
- `name` (`String`, required) — Display name of the feature.
- `unitName` (`String | null`, required) — Display name for one product unit, or null when not applicable.
- `allowed` (`Boolean`, required) — Whether the customer can currently access or consume the feature.
- `type` (`String`, required)
- `usage` (`FeatureAccessVariant3Usage`, required)
- `baseAccess` (`FeatureAccessVariant3BaseAccess | null`, optional)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### FeatureAccessVariant3BaseAccess

- `includedUnits` (`Double`, required)
- `unlimited` (`Boolean`, required)

### FeatureAccessVariant3Usage

- `period` (`FeatureAccessVariant3UsagePeriod`, required) — Time range used to calculate this feature's consumption.
- `unitsUsed` (`Double`, required) — Current units assigned or in use.
- `includedUnits` (`Double`, required) — Units included in the subscription for the period.
- `remainingUnits` (`Double`, optional) — Included units still available. Absent when usage is unlimited.
- `unlimited` (`Boolean`, required) — Whether the feature has no usage limit.
- `overage` (`FeatureAccessVariant3UsageOverage`, required)

### FeatureAccessVariant3UsageOverage

- `enabled` (`Boolean`, required) — Whether usage above the included amount is allowed and billed.
- `units` (`Double`, required) — Units consumed above the included amount.
- `unitPrice` (`FeatureAccessVariant3UsageOverageUnitPrice`, optional) — Price for one additional product unit.

### FeatureAccessVariant3UsageOverageUnitPrice

- `amount` (`Long`, required) — Integer rate amount. Divide by scale to obtain the price.
- `currency` (`String`, required) — Lowercase ISO 4217 currency code.
- `scale` (`Object`, required) — Divide amount by scale to obtain the major-unit price.

### FeatureAccessVariant3UsagePeriod

- `start` (`String`, required) — Inclusive usage period start.
- `end` (`String`, required) — Exclusive usage period end.

### FeatureAccessVariant4

- `code` (`String`, required) — Unique feature code.
- `name` (`String`, required) — Display name of the feature.
- `unitName` (`String | null`, required) — Display name for one product unit, or null when not applicable.
- `allowed` (`Boolean`, required) — Whether the customer can currently access or consume the feature.
- `type` (`String`, required)
- `usage` (`FeatureAccessVariant4Usage`, required)
- `baseAccess` (`FeatureAccessVariant4BaseAccess | null`, optional)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### FeatureAccessVariant4BaseAccess

- `includedUnits` (`Double`, required)
- `unlimited` (`Boolean`, required)

### FeatureAccessVariant4Usage

- `period` (`FeatureAccessVariant4UsagePeriod`, required) — Time range used to calculate this feature's consumption.
- `unitsUsed` (`Double`, required) — Current units assigned or in use.
- `includedUnits` (`Double`, required) — Units included in the subscription for the period.
- `remainingUnits` (`Double`, optional) — Included units still available. Absent when usage is unlimited.
- `unlimited` (`Boolean`, required) — Whether the feature has no usage limit.
- `overage` (`FeatureAccessVariant4UsageOverage`, required)
- `billedUnits` (`Double`, required) — Highest quota reached during the period and used for billing.

### FeatureAccessVariant4UsageOverage

- `enabled` (`Boolean`, required) — Whether usage above the included amount is allowed and billed.
- `units` (`Double`, required) — Units consumed above the included amount.
- `unitPrice` (`FeatureAccessVariant4UsageOverageUnitPrice`, optional) — Price for one additional product unit.

### FeatureAccessVariant4UsageOverageUnitPrice

- `amount` (`Long`, required) — Integer rate amount. Divide by scale to obtain the price.
- `currency` (`String`, required) — Lowercase ISO 4217 currency code.
- `scale` (`Object`, required) — Divide amount by scale to obtain the major-unit price.

### FeatureAccessVariant4UsagePeriod

- `start` (`String`, required) — Inclusive usage period start.
- `end` (`String`, required) — Exclusive usage period end.

### FeaturesListResult

- `object` (`String`, required)
- `data` (`List<Feature>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### Invoice

- `id` (`String`, required)
- `customerId` (`String`, required)
- `subscriptionId` (`String | null`, required)
- `invoiceNumber` (`String`, required)
- `status` (`String`, required)
- `invoiceType` (`InvoiceType`, required)
- `currency` (`String`, required)
- `subtotal` (`Long`, required)
- `discountAmount` (`Long`, required)
- `taxAmount` (`Long`, required)
- `total` (`Long`, required)
- `periodStart` (`String`, required)
- `periodEnd` (`String`, required)
- `issueDate` (`String`, required)
- `dueDate` (`String`, required)
- `memo` (`String | null`, required)
- `metadata` (`Map<String, Object>`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `creditApplied` (`Long`, required)
- `planName` (`String | null`, required)
- `poNumber` (`String | null`, required)
- `reference` (`String | null`, required)
- `lineItems` (`List<InvoiceLineItemsItem>`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### InvoiceDownload

- `url` (`String`, required)
- `expiresAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### InvoiceLineItemsItem

- `lineType` (`String`, required)
- `featureName` (`String | null`, required)
- `description` (`String`, required)
- `quantity` (`Long`, required)
- `unitAmount` (`Long`, required)
- `amount` (`Long`, required)
- `includedAmount` (`Long | null`, required)
- `usedAmount` (`Long | null`, required)
- `overageAmount` (`Long | null`, required)
- `discountType` (`String | null`, required)
- `discountValue` (`Long | null`, required)
- `discountName` (`String | null`, required)
- `chargeType` (`String`, required)

### InvoiceListItem

- `id` (`String`, required)
- `customerId` (`String`, required)
- `subscriptionId` (`String | null`, required)
- `invoiceNumber` (`String`, required)
- `status` (`String`, required)
- `invoiceType` (`InvoiceType`, required)
- `currency` (`String`, required)
- `subtotal` (`Long`, required)
- `discountAmount` (`Long`, required)
- `taxAmount` (`Long`, required)
- `total` (`Long`, required)
- `periodStart` (`String`, required)
- `periodEnd` (`String`, required)
- `issueDate` (`String`, required)
- `dueDate` (`String`, required)
- `memo` (`String | null`, required)
- `metadata` (`Map<String, Object>`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### InvoicesListResult

- `object` (`String`, required)
- `data` (`List<InvoiceListItem>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### Market

- `id` (`String`, required)
- `name` (`String`, required)
- `countryCodes` (`List<String>`, required)
- `metadata` (`Map<String, Object>`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### MarketsListResult

- `object` (`String`, required)
- `data` (`List<Market>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### Offer

- `id` (`String`, required)
- `name` (`String`, required)
- `phases` (`List<OfferPhasesItem>`, required)
- `metadata` (`Map<String, Object>`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)
- `active` (`Boolean`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### OfferPhasesItem

Variants:

- `OfferPhasesItemVariant1`
- `OfferPhasesItemVariant2`
- `OfferPhasesItemVariant3`
- `OfferPhasesItemVariant4`

Discriminator: `type`

- `"free_trial"` → `OfferPhasesItemVariant1`
- `"percentage"` → `OfferPhasesItemVariant2`
- `"amount_off"` → `OfferPhasesItemVariant3`
- `"fixed_price"` → `OfferPhasesItemVariant4`

### OfferPhasesItemVariant1

- `type` (`String`, required)
- `durationDays` (`Long`, required)

### OfferPhasesItemVariant2

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `percentage` (`Long`, required) — Discount in basis points. 5000 means 50%.

### OfferPhasesItemVariant3

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `amounts` (`List<OfferPhasesItemVariant3AmountsItem>`, required)

### OfferPhasesItemVariant3AmountsItem

- `currency` (`String`, required)
- `amount` (`Long`, required) — Amount in the currency's minor unit (for example, cents for USD).

### OfferPhasesItemVariant4

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `prices` (`List<OfferPhasesItemVariant4PricesItem>`, required)

### OfferPhasesItemVariant4PricesItem

- `currency` (`String`, required)
- `amount` (`Long`, required) — Amount in the currency's minor unit (for example, cents for USD).

### OffersListResult

- `object` (`String`, required)
- `data` (`List<Offer>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### Payment

- `id` (`String`, required)
- `customerId` (`String | null`, required)
- `kind` (`String`, required)
- `status` (`String`, required)
- `provider` (`String`, required)
- `amountSubtotal` (`Long`, required)
- `taxAmount` (`Long`, required)
- `amountTotal` (`Long`, required)
- `currency` (`String`, required)
- `description` (`String`, required)
- `metadata` (`Map<String, Object> | null`, required)
- `url` (`String | null`, required)
- `expiresAt` (`String | null`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PaymentMethodUpdateCheckout

- `checkoutUrl` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PaymentsListResult

- `object` (`String`, required)
- `data` (`List<Payment>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### Payout

- `id` (`String`, required)
- `status` (`String`, required)
- `amount` (`Long`, required)
- `fee` (`Long`, required)
- `netAmount` (`Long`, required)
- `currency` (`String`, required)
- `description` (`String | null`, required)
- `providerTransferId` (`String`, required)
- `createdAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PayoutBankAccount

- `id` (`String`, required)
- `providerExternalAccountId` (`String | null`, required)
- `holderName` (`String`, required)
- `last4` (`String`, required)
- `bankName` (`String | null`, required)
- `country` (`String`, required)
- `currency` (`String`, required)
- `accountType` (`String | null`, required)
- `isDefault` (`Boolean`, required)
- `status` (`String`, required)
- `createdAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### Plan

- `id` (`String`, required)
- `name` (`String`, required)
- `code` (`String`, required)
- `description` (`String | null`, required)
- `consumptionModel` (`ConsumptionModel | null`, required)
- `isPublic` (`Boolean`, required)
- `isDefault` (`Boolean`, required)
- `isFree` (`Boolean`, required)
- `blockOnExhaustion` (`Boolean | null`, required)
- `sortOrder` (`Long`, required)
- `planGroupId` (`String | null`, required)
- `metadata` (`Map<String, Object> | null`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `features` (`List<PlanFeaturesItem>`, required)
- `prices` (`List<PlanPricesItem>`, required)
- `exchangeRates` (`List<PlanExchangeRatesItem>`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanChange

Variants:

- `PlanChangeVariant1`
- `PlanChangeVariant2`
- `PlanChangeVariant3`

Discriminator: `outcome`

- `"requires_checkout"` → `PlanChangeVariant1`
- `"scheduled"` → `PlanChangeVariant2`
- `"completed"` → `PlanChangeVariant3`

### PlanChangeVariant1

- `outcome` (`String`, required)
- `requiresCheckout` (`Object`, required)
- `checkoutUrl` (`String`, required)
- `offerApplication` (`PlanChangeVariant1OfferApplication`, optional)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanChangeVariant1OfferApplication

- `id` (`String`, required)
- `offerId` (`String`, required)
- `name` (`String`, required)
- `currency` (`String`, required)
- `subtotal` (`Long`, required) — Subtotal in the currency's minor unit.
- `discountAmount` (`Long`, required) — Discount in the currency's minor unit.
- `total` (`Long`, required) — Total in the currency's minor unit.
- `phases` (`List<PlanChangeVariant1OfferApplicationPhasesItem>`, required)
- `appliesTo` (`PlanChangeVariant1OfferApplicationAppliesTo`, required)

### PlanChangeVariant1OfferApplicationAppliesTo

Variants:

- `PlanChangeVariant1OfferApplicationAppliesToVariant1`
- `PlanChangeVariant1OfferApplicationAppliesToVariant2`
- `PlanChangeVariant1OfferApplicationAppliesToVariant3`

Discriminator: `type`

- `"plan_price"` → `PlanChangeVariant1OfferApplicationAppliesToVariant1`
- `"addon"` → `PlanChangeVariant1OfferApplicationAppliesToVariant2`
- `"credit_pack"` → `PlanChangeVariant1OfferApplicationAppliesToVariant3`

### PlanChangeVariant1OfferApplicationAppliesToVariant1

- `type` (`String`, required)
- `id` (`String`, required)

### PlanChangeVariant1OfferApplicationAppliesToVariant2

- `type` (`String`, required)
- `id` (`String`, required)

### PlanChangeVariant1OfferApplicationAppliesToVariant3

- `type` (`String`, required)
- `id` (`String`, required)

### PlanChangeVariant1OfferApplicationPhasesItem

Variants:

- `PlanChangeVariant1OfferApplicationPhasesItemVariant1`
- `PlanChangeVariant1OfferApplicationPhasesItemVariant2`
- `PlanChangeVariant1OfferApplicationPhasesItemVariant3`
- `PlanChangeVariant1OfferApplicationPhasesItemVariant4`

Discriminator: `type`

- `"free_trial"` → `PlanChangeVariant1OfferApplicationPhasesItemVariant1`
- `"percentage"` → `PlanChangeVariant1OfferApplicationPhasesItemVariant2`
- `"amount_off"` → `PlanChangeVariant1OfferApplicationPhasesItemVariant3`
- `"fixed_price"` → `PlanChangeVariant1OfferApplicationPhasesItemVariant4`

### PlanChangeVariant1OfferApplicationPhasesItemVariant1

- `type` (`String`, required)
- `durationDays` (`Long`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)

### PlanChangeVariant1OfferApplicationPhasesItemVariant2

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)
- `percentage` (`Long`, required) — Discount in basis points. 5000 means 50%.

### PlanChangeVariant1OfferApplicationPhasesItemVariant3

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)
- `amount` (`Long`, required) — Discount in the application currency's minor unit.

### PlanChangeVariant1OfferApplicationPhasesItemVariant4

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)
- `price` (`Long`, required) — Fixed price in the application currency's minor unit.

### PlanChangeVariant2

- `outcome` (`String`, required)
- `id` (`String`, required)
- `scheduled` (`Object`, required)
- `scheduledFor` (`String`, required)
- `changeType` (`String`, required)
- `customerId` (`String`, required)
- `newPlanId` (`String`, optional)
- `newPlanName` (`String`, optional)
- `newBillingInterval` (`String`, optional)
- `seatLimitWarning` (`PlanChangeVariant2SeatLimitWarning`, optional)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanChangeVariant2SeatLimitWarning

- `featureCode` (`String`, required)
- `featureName` (`String`, required)
- `currentSeats` (`Long`, required)
- `included` (`Long`, required)
- `newPlanName` (`String`, required)
- `effectiveDate` (`String`, required)

### PlanChangeVariant3

- `outcome` (`String`, required)
- `id` (`String`, required)
- `scheduled` (`Object`, required)
- `customerId` (`String`, required)
- `previousPlan` (`PlanChangeVariant3PreviousPlan`, required)
- `currentPlan` (`PlanChangeVariant3CurrentPlan`, required)
- `billingInterval` (`String`, required)
- `billing` (`PlanChangeVariant3Billing`, required)
- `invoiceId` (`String`, optional)
- `offerApplication` (`PlanChangeVariant3OfferApplication`, optional)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanChangeVariant3Billing

- `credit` (`Long`, required)
- `creditsApplied` (`Long`, required)
- `charge` (`Long`, required)
- `taxAmount` (`Long`, required)
- `netAmount` (`Long`, required)
- `totalCharged` (`Long`, required)
- `remainingCreditBalance` (`Long`, required)

### PlanChangeVariant3CurrentPlan

- `id` (`String`, required)
- `name` (`String`, required)
- `price` (`Long`, required)

### PlanChangeVariant3OfferApplication

- `id` (`String`, required)
- `offerId` (`String`, required)
- `name` (`String`, required)
- `currency` (`String`, required)
- `subtotal` (`Long`, required) — Subtotal in the currency's minor unit.
- `discountAmount` (`Long`, required) — Discount in the currency's minor unit.
- `total` (`Long`, required) — Total in the currency's minor unit.
- `phases` (`List<PlanChangeVariant3OfferApplicationPhasesItem>`, required)
- `appliesTo` (`PlanChangeVariant3OfferApplicationAppliesTo`, required)

### PlanChangeVariant3OfferApplicationAppliesTo

Variants:

- `PlanChangeVariant3OfferApplicationAppliesToVariant1`
- `PlanChangeVariant3OfferApplicationAppliesToVariant2`
- `PlanChangeVariant3OfferApplicationAppliesToVariant3`

Discriminator: `type`

- `"plan_price"` → `PlanChangeVariant3OfferApplicationAppliesToVariant1`
- `"addon"` → `PlanChangeVariant3OfferApplicationAppliesToVariant2`
- `"credit_pack"` → `PlanChangeVariant3OfferApplicationAppliesToVariant3`

### PlanChangeVariant3OfferApplicationAppliesToVariant1

- `type` (`String`, required)
- `id` (`String`, required)

### PlanChangeVariant3OfferApplicationAppliesToVariant2

- `type` (`String`, required)
- `id` (`String`, required)

### PlanChangeVariant3OfferApplicationAppliesToVariant3

- `type` (`String`, required)
- `id` (`String`, required)

### PlanChangeVariant3OfferApplicationPhasesItem

Variants:

- `PlanChangeVariant3OfferApplicationPhasesItemVariant1`
- `PlanChangeVariant3OfferApplicationPhasesItemVariant2`
- `PlanChangeVariant3OfferApplicationPhasesItemVariant3`
- `PlanChangeVariant3OfferApplicationPhasesItemVariant4`

Discriminator: `type`

- `"free_trial"` → `PlanChangeVariant3OfferApplicationPhasesItemVariant1`
- `"percentage"` → `PlanChangeVariant3OfferApplicationPhasesItemVariant2`
- `"amount_off"` → `PlanChangeVariant3OfferApplicationPhasesItemVariant3`
- `"fixed_price"` → `PlanChangeVariant3OfferApplicationPhasesItemVariant4`

### PlanChangeVariant3OfferApplicationPhasesItemVariant1

- `type` (`String`, required)
- `durationDays` (`Long`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)

### PlanChangeVariant3OfferApplicationPhasesItemVariant2

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)
- `percentage` (`Long`, required) — Discount in basis points. 5000 means 50%.

### PlanChangeVariant3OfferApplicationPhasesItemVariant3

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)
- `amount` (`Long`, required) — Discount in the application currency's minor unit.

### PlanChangeVariant3OfferApplicationPhasesItemVariant4

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)
- `price` (`Long`, required) — Fixed price in the application currency's minor unit.

### PlanChangeVariant3PreviousPlan

- `id` (`String`, required)
- `name` (`String`, required)

### PlanExchangeRatesItem

- `currency` (`String`, required)
- `exchangeRate` (`Double`, required)

### PlanFeature

- `planId` (`String`, required)
- `featureId` (`String`, required)
- `enabled` (`Boolean`, required)
- `includedAmount` (`Long`, required)
- `unlimited` (`Boolean`, required)
- `overage` (`PlanFeatureOverage`, required)
- `creditsPerUnit` (`Long | null`, required)
- `pricingMode` (`String`, required)
- `margin` (`Long | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanFeatureOverage

- `enabled` (`Boolean`, required)
- `unitPrice` (`Long`, required)

### PlanFeaturesItem

- `code` (`String`, required)
- `name` (`String`, required)
- `type` (`FeatureType`, required)
- `unitName` (`String | null`, required)
- `enabled` (`Boolean`, required)
- `includedAmount` (`Long | null`, required)
- `unlimited` (`Boolean`, required)
- `overage` (`PlanFeaturesItemOverage | null`, required)
- `regionalPrices` (`List<PlanFeaturesItemRegionalPricesItem>`, required)

### PlanFeaturesItemOverage

- `enabled` (`Boolean`, required)
- `model` (`String | null`, required)
- `unitPrice` (`Long | null`, required)

### PlanFeaturesItemRegionalPricesItem

- `currency` (`String`, required)
- `overageUnitPrice` (`Long | null`, required)
- `autoSynced` (`Boolean`, required)

### PlanGrant

- `id` (`String`, required)
- `customerId` (`String`, required)
- `subscriptionId` (`String`, required)
- `basePlanId` (`String`, required)
- `planId` (`String`, required)
- `planReleaseId` (`String`, required)
- `status` (`String`, required)
- `duration` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `startsAt` (`String`, required)
- `expiresAt` (`String | null`, required)
- `reason` (`String`, required)
- `source` (`String`, required)
- `revokedAt` (`String | null`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `events` (`List<PlanGrantEventsItem>`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanGrantEventsItem

- `id` (`String`, required)
- `type` (`String`, required)
- `reason` (`String`, required)
- `source` (`String`, required)
- `previousExpiresAt` (`String | null`, required)
- `expiresAt` (`String | null`, required)
- `duration` (`String | null`, required)
- `durationCycles` (`Long | null`, required)
- `requestedExpiresAt` (`String | null`, required)
- `createdAt` (`String`, required)

### PlanGroup

- `id` (`String`, required)
- `name` (`String`, required)
- `description` (`String | null`, required)
- `isPublic` (`Boolean`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanGroupDetail

- `id` (`String`, required)
- `name` (`String`, required)
- `description` (`String | null`, required)
- `isPublic` (`Boolean`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `plans` (`List<PlanGroupDetailPlansItem>`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanGroupDetailPlansItem

- `id` (`String`, required)
- `name` (`String`, required)
- `sortOrder` (`Long`, required)

### PlanGroupsListResult

- `object` (`String`, required)
- `data` (`List<PlanGroup>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### PlanPrice

- `id` (`String`, required) — Public plan price ID.
- `planId` (`String`, required)
- `billingInterval` (`BillingInterval`, required)
- `price` (`Long`, required) — Price in the currency's minor unit (for example, cents for USD).
- `isDefault` (`Boolean`, required)
- `trialDays` (`Long`, required)
- `includedBalance` (`Long | null`, required)
- `includedCredits` (`Long | null`, required)
- `offerId` (`String | null`, required) — Automatic introductory offer for this price.
- `inheritsFromPriceId` (`String | null`, required) — Public base price ID for a market price variant, or null for a base price.
- `metadata` (`Map<String, Object>`, required) — Application metadata. Variant display names may use metadata.name.
- `marketPrices` (`List<PlanPriceMarketPricesItem>`, required) — Country-market overrides. Variants inherit their base price for every market not listed.
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanPriceMarketPricesItem

- `marketGroupId` (`String`, required) — Public pricing market group ID.
- `currency` (`String`, required) — Presentment currency for this market.
- `price` (`Long`, required) — Market price in the currency's minor unit.

### PlanPricesItem

- `id` (`String`, required) — Public plan price ID.
- `billingInterval` (`BillingInterval`, required)
- `price` (`Long`, required) — Price in the currency's minor unit (for example, cents for USD).
- `isDefault` (`Boolean`, required)
- `trialDays` (`Long`, required)
- `includedBalance` (`Long | null`, required)
- `includedCredits` (`Long | null`, required)
- `offerId` (`String | null`, required) — Automatic introductory offer for this price. Pass a Promotional Offer ID when creating a subscription to override it.
- `inheritsFromPriceId` (`String | null`, required) — Public base price ID for a market price variant, or null for a base price.
- `metadata` (`Map<String, Object>`, required) — Application metadata. Variant display names may use metadata.name.
- `marketPrices` (`List<PlanPricesItemMarketPricesItem>`, required) — Country-market overrides. An empty array means currency pricing and then the global USD price remain the fallback.
- `regionalPrices` (`List<PlanPricesItemRegionalPricesItem>`, required)

### PlanPricesItemMarketPricesItem

- `marketGroupId` (`String`, required) — Public pricing market group ID.
- `currency` (`String`, required) — Presentment currency for this market.
- `price` (`Long`, required) — Market price in the currency's minor unit.

### PlanPricesItemRegionalPricesItem

- `currency` (`String`, required)
- `price` (`Long`, required)
- `includedBalance` (`Long | null`, required)
- `autoSynced` (`Boolean`, required)

### PlanRegionalPricing

- `priceId` (`String`, required)
- `overrides` (`List<PlanRegionalPricingOverridesItem>`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanRegionalPricingOverridesItem

- `currency` (`String`, required)
- `price` (`Long`, required)
- `includedBalance` (`Long`, optional)

### PlanRegionalPricingResult

- `planId` (`String`, required)
- `currency` (`String`, required)
- `exchangeRate` (`Double`, required)
- `pricesConfigured` (`Long`, required)
- `featuresConfigured` (`Long`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlansListResult

- `object` (`String`, required)
- `data` (`List<Plan>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### PortalAccess

- `portalUrl` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PreviewChange

- `currency` (`String`, required)
- `currentPlanCredit` (`Long`, required)
- `newPlanCharge` (`Long`, required)
- `estimatedTotal` (`Long`, required)
- `effectiveDate` (`String`, required)
- `daysRemaining` (`Long`, required)
- `totalDays` (`Long`, required)
- `isUpgrade` (`Boolean`, required)
- `offerApplication` (`PreviewChangeOfferApplication`, optional)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PreviewChangeOfferApplication

- `id` (`String`, required)
- `offerId` (`String`, required)
- `name` (`String`, required)
- `currency` (`String`, required)
- `subtotal` (`Long`, required) — Subtotal in the currency's minor unit.
- `discountAmount` (`Long`, required) — Discount in the currency's minor unit.
- `total` (`Long`, required) — Total in the currency's minor unit.
- `phases` (`List<PreviewChangeOfferApplicationPhasesItem>`, required)
- `appliesTo` (`PreviewChangeOfferApplicationAppliesTo`, required)

### PreviewChangeOfferApplicationAppliesTo

Variants:

- `PreviewChangeOfferApplicationAppliesToVariant1`
- `PreviewChangeOfferApplicationAppliesToVariant2`
- `PreviewChangeOfferApplicationAppliesToVariant3`

Discriminator: `type`

- `"plan_price"` → `PreviewChangeOfferApplicationAppliesToVariant1`
- `"addon"` → `PreviewChangeOfferApplicationAppliesToVariant2`
- `"credit_pack"` → `PreviewChangeOfferApplicationAppliesToVariant3`

### PreviewChangeOfferApplicationAppliesToVariant1

- `type` (`String`, required)
- `id` (`String`, required)

### PreviewChangeOfferApplicationAppliesToVariant2

- `type` (`String`, required)
- `id` (`String`, required)

### PreviewChangeOfferApplicationAppliesToVariant3

- `type` (`String`, required)
- `id` (`String`, required)

### PreviewChangeOfferApplicationPhasesItem

Variants:

- `PreviewChangeOfferApplicationPhasesItemVariant1`
- `PreviewChangeOfferApplicationPhasesItemVariant2`
- `PreviewChangeOfferApplicationPhasesItemVariant3`
- `PreviewChangeOfferApplicationPhasesItemVariant4`

Discriminator: `type`

- `"free_trial"` → `PreviewChangeOfferApplicationPhasesItemVariant1`
- `"percentage"` → `PreviewChangeOfferApplicationPhasesItemVariant2`
- `"amount_off"` → `PreviewChangeOfferApplicationPhasesItemVariant3`
- `"fixed_price"` → `PreviewChangeOfferApplicationPhasesItemVariant4`

### PreviewChangeOfferApplicationPhasesItemVariant1

- `type` (`String`, required)
- `durationDays` (`Long`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)

### PreviewChangeOfferApplicationPhasesItemVariant2

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)
- `percentage` (`Long`, required) — Discount in basis points. 5000 means 50%.

### PreviewChangeOfferApplicationPhasesItemVariant3

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)
- `amount` (`Long`, required) — Discount in the application currency's minor unit.

### PreviewChangeOfferApplicationPhasesItemVariant4

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)
- `price` (`Long`, required) — Fixed price in the application currency's minor unit.

### PromoCode

- `id` (`String`, required)
- `code` (`String`, required)
- `offerId` (`String`, required)
- `billingInterval` (`BillingInterval | null`, required)
- `maxRedemptions` (`Long | null`, required)
- `expiresAt` (`String | null`, required)
- `isActive` (`Boolean`, required)
- `redemptionCount` (`Long`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PromoCodesListResult

- `object` (`String`, required)
- `data` (`List<PromoCode>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### QuotaGetAllResult

- `object` (`String`, required)
- `data` (`List<UsageQuota>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### ReactivatedSubscription

- `subscriptionId` (`String`, required)
- `invoiceId` (`String`, required)
- `status` (`String`, required)
- `offerApplication` (`ReactivatedSubscriptionOfferApplication`, optional)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### ReactivatedSubscriptionOfferApplication

- `id` (`String`, required)
- `offerId` (`String`, required)
- `name` (`String`, required)
- `currency` (`String`, required)
- `subtotal` (`Long`, required) — Subtotal in the currency's minor unit.
- `discountAmount` (`Long`, required) — Discount in the currency's minor unit.
- `total` (`Long`, required) — Total in the currency's minor unit.
- `phases` (`List<ReactivatedSubscriptionOfferApplicationPhasesItem>`, required)
- `appliesTo` (`ReactivatedSubscriptionOfferApplicationAppliesTo`, required)

### ReactivatedSubscriptionOfferApplicationAppliesTo

Variants:

- `ReactivatedSubscriptionOfferApplicationAppliesToVariant1`
- `ReactivatedSubscriptionOfferApplicationAppliesToVariant2`
- `ReactivatedSubscriptionOfferApplicationAppliesToVariant3`

Discriminator: `type`

- `"plan_price"` → `ReactivatedSubscriptionOfferApplicationAppliesToVariant1`
- `"addon"` → `ReactivatedSubscriptionOfferApplicationAppliesToVariant2`
- `"credit_pack"` → `ReactivatedSubscriptionOfferApplicationAppliesToVariant3`

### ReactivatedSubscriptionOfferApplicationAppliesToVariant1

- `type` (`String`, required)
- `id` (`String`, required)

### ReactivatedSubscriptionOfferApplicationAppliesToVariant2

- `type` (`String`, required)
- `id` (`String`, required)

### ReactivatedSubscriptionOfferApplicationAppliesToVariant3

- `type` (`String`, required)
- `id` (`String`, required)

### ReactivatedSubscriptionOfferApplicationPhasesItem

Variants:

- `ReactivatedSubscriptionOfferApplicationPhasesItemVariant1`
- `ReactivatedSubscriptionOfferApplicationPhasesItemVariant2`
- `ReactivatedSubscriptionOfferApplicationPhasesItemVariant3`
- `ReactivatedSubscriptionOfferApplicationPhasesItemVariant4`

Discriminator: `type`

- `"free_trial"` → `ReactivatedSubscriptionOfferApplicationPhasesItemVariant1`
- `"percentage"` → `ReactivatedSubscriptionOfferApplicationPhasesItemVariant2`
- `"amount_off"` → `ReactivatedSubscriptionOfferApplicationPhasesItemVariant3`
- `"fixed_price"` → `ReactivatedSubscriptionOfferApplicationPhasesItemVariant4`

### ReactivatedSubscriptionOfferApplicationPhasesItemVariant1

- `type` (`String`, required)
- `durationDays` (`Long`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)

### ReactivatedSubscriptionOfferApplicationPhasesItemVariant2

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)
- `percentage` (`Long`, required) — Discount in basis points. 5000 means 50%.

### ReactivatedSubscriptionOfferApplicationPhasesItemVariant3

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)
- `amount` (`Long`, required) — Discount in the application currency's minor unit.

### ReactivatedSubscriptionOfferApplicationPhasesItemVariant4

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)
- `price` (`Long`, required) — Fixed price in the application currency's minor unit.

### RecoveryLink

- `url` (`String`, required)
- `token` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### Refund

- `id` (`String`, required)
- `transactionId` (`String`, required)
- `amount` (`Long`, required)
- `currency` (`String`, required)
- `chargeId` (`String | null`, required)
- `status` (`String`, required)
- `reason` (`String | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### RemovedPlanFeature

- `id` (`String`, required)
- `removed` (`Object`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### RemovedPlanFromGroup

- `id` (`String`, required)
- `removed` (`Boolean`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### ReorderedPlans

- `reordered` (`Boolean`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### SeatBalance

- `current` (`Long`, required)
- `asOf` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### SeatBalanceCollection

- `balances` (`Map<String, SeatBalanceCollectionBalancesValue>`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### SeatBalanceCollectionBalancesValue

- `current` (`Long`, required)
- `asOf` (`String`, required)

### SeatEvent

- `id` (`String`, required)
- `customerId` (`String`, required)
- `featureCode` (`String`, required)
- `previousBalance` (`Long`, required)
- `newBalance` (`Long`, required)
- `ts` (`String`, required)
- `createdAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### SeatsSetAllResult

- `object` (`String`, required)
- `data` (`List<SeatEvent>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### SentInvoice

- `sent` (`Boolean`, required)
- `sentAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### SetPlanRegionalPricingParamsFeaturesItem

- `featureId` (`String`, required)
- `overageUnitPrice` (`Long`, required)

### SetPlanRegionalPricingParamsPricesItem

- `priceId` (`String`, required)
- `price` (`Long`, required)
- `includedBalance` (`Long`, optional)

### Subscription

- `id` (`String`, required)
- `customerId` (`String`, required)
- `plan` (`SubscriptionPlan`, required)
- `name` (`String`, required)
- `description` (`String | null`, required)
- `status` (`SubscriptionStatus`, required)
- `billingInterval` (`BillingInterval | null`, required)
- `trialEndsAt` (`String | null`, required)
- `currentPeriod` (`SubscriptionCurrentPeriod | null`, required)
- `cancellation` (`SubscriptionCancellation | null`, required)
- `cancelAtPeriodEnd` (`Boolean`, required)
- `scheduledPlanChange` (`SubscriptionScheduledPlanChange | null`, required)
- `startDate` (`String`, required)
- `endDate` (`String | null`, required)
- `billingDayOfMonth` (`Long | null`, required)
- `nextBillingDate` (`String | null`, required)
- `checkoutUrl` (`String | null`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `offerApplications` (`List<SubscriptionOfferApplication>`, required)
- `planGrant` (`SubscriptionPlanGrant`, optional)
- `consumptionModel` (`ConsumptionModel | null`, required)
- `features` (`List<SubscriptionFeaturesItem>`, required)
- `credits` (`SubscriptionCredits | null`, required)
- `balance` (`SubscriptionBalance | null`, required)
- `priceId` (`String | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### SubscriptionAddon

- `addonId` (`String`, required)
- `status` (`String`, required)
- `proratedCharge` (`Long`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### SubscriptionBalance

- `remaining` (`Double`, required)
- `included` (`Double`, required)
- `currency` (`String`, required)

### SubscriptionCancellation

- `scheduledAt` (`String`, required)
- `reason` (`String | null`, required)
- `effectiveAt` (`String`, required)

### SubscriptionCredits

- `remaining` (`Double`, required)
- `included` (`Double`, required)
- `purchased` (`Double`, required)

### SubscriptionCurrentPeriod

- `start` (`String`, required)
- `end` (`String`, required)
- `daysRemaining` (`Double`, required)

### SubscriptionFeaturesItem

Variants:

- `SubscriptionFeaturesItemVariant1`
- `SubscriptionFeaturesItemVariant2`
- `SubscriptionFeaturesItemVariant3`
- `SubscriptionFeaturesItemVariant4`

Discriminator: `type`

- `"boolean"` → `SubscriptionFeaturesItemVariant1`
- `"usage"` → `SubscriptionFeaturesItemVariant2`
- `"seats"` → `SubscriptionFeaturesItemVariant3`
- `"quota"` → `SubscriptionFeaturesItemVariant4`

### SubscriptionFeaturesItemVariant1

- `code` (`String`, required)
- `name` (`String`, required)
- `type` (`String`, required)
- `enabled` (`Boolean`, required)
- `baseAccess` (`SubscriptionFeaturesItemVariant1BaseAccess | null`, optional)

### SubscriptionFeaturesItemVariant1BaseAccess

- `enabled` (`Boolean`, required)

### SubscriptionFeaturesItemVariant2

- `code` (`String`, required)
- `name` (`String`, required)
- `type` (`String`, required)
- `usage` (`SubscriptionFeaturesItemVariant2Usage`, optional)
- `baseAccess` (`SubscriptionFeaturesItemVariant2BaseAccess | null`, optional)

### SubscriptionFeaturesItemVariant2BaseAccess

- `included` (`Double`, required)
- `unlimited` (`Boolean`, required)

### SubscriptionFeaturesItemVariant2Usage

- `current` (`Double`, required)
- `included` (`Double`, required)
- `overageQuantity` (`Double`, required)
- `overageUnitPrice` (`Double`, optional)
- `unlimited` (`Boolean`, optional)

### SubscriptionFeaturesItemVariant3

- `code` (`String`, required)
- `name` (`String`, required)
- `type` (`String`, required)
- `usage` (`SubscriptionFeaturesItemVariant3Usage`, required)
- `baseAccess` (`SubscriptionFeaturesItemVariant3BaseAccess | null`, optional)

### SubscriptionFeaturesItemVariant3BaseAccess

- `included` (`Double`, required)
- `unlimited` (`Boolean`, required)

### SubscriptionFeaturesItemVariant3Usage

- `current` (`Double`, required)
- `included` (`Double`, required)
- `overageQuantity` (`Double`, required)
- `overageUnitPrice` (`Double`, optional)
- `unlimited` (`Boolean`, optional)

### SubscriptionFeaturesItemVariant4

- `code` (`String`, required)
- `name` (`String`, required)
- `type` (`String`, required)
- `usage` (`SubscriptionFeaturesItemVariant4Usage`, optional)
- `baseAccess` (`SubscriptionFeaturesItemVariant4BaseAccess | null`, optional)

### SubscriptionFeaturesItemVariant4BaseAccess

- `included` (`Double`, required)
- `unlimited` (`Boolean`, required)

### SubscriptionFeaturesItemVariant4Usage

- `current` (`Double`, required)
- `included` (`Double`, required)
- `overageQuantity` (`Double`, required)
- `overageUnitPrice` (`Double`, optional)
- `unlimited` (`Boolean`, optional)

### SubscriptionOfferApplication

- `id` (`String`, required)
- `name` (`String`, required)
- `appliesTo` (`SubscriptionOfferApplicationAppliesTo`, required)
- `offerId` (`String | null`, required)
- `source` (`String`, required)
- `status` (`String`, required)
- `currency` (`String | null`, required)
- `subtotal` (`Long | null`, required)
- `discountAmount` (`Long | null`, required)
- `total` (`Long | null`, required)
- `phases` (`List<SubscriptionOfferApplicationPhase>`, required)
- `quotedAt` (`String`, required)
- `expiresAt` (`String | null`, required)
- `appliedAt` (`String | null`, required)

### SubscriptionOfferApplicationAppliesTo

Variants:

- `SubscriptionOfferApplicationAppliesToVariant1`
- `SubscriptionOfferApplicationAppliesToVariant2`
- `SubscriptionOfferApplicationAppliesToVariant3`

Discriminator: `type`

- `"plan_price"` → `SubscriptionOfferApplicationAppliesToVariant1`
- `"addon"` → `SubscriptionOfferApplicationAppliesToVariant2`
- `"credit_pack"` → `SubscriptionOfferApplicationAppliesToVariant3`

### SubscriptionOfferApplicationAppliesToVariant1

- `type` (`String`, required)
- `id` (`String`, required)

### SubscriptionOfferApplicationAppliesToVariant2

- `type` (`String`, required)
- `id` (`String`, required)

### SubscriptionOfferApplicationAppliesToVariant3

- `type` (`String`, required)
- `id` (`String`, required)

### SubscriptionOfferApplicationPhase

Variants:

- `SubscriptionOfferApplicationPhaseVariant1`
- `SubscriptionOfferApplicationPhaseVariant2`
- `SubscriptionOfferApplicationPhaseVariant3`
- `SubscriptionOfferApplicationPhaseVariant4`

Discriminator: `type`

- `"free_trial"` → `SubscriptionOfferApplicationPhaseVariant1`
- `"percentage"` → `SubscriptionOfferApplicationPhaseVariant2`
- `"amount_off"` → `SubscriptionOfferApplicationPhaseVariant3`
- `"fixed_price"` → `SubscriptionOfferApplicationPhaseVariant4`

### SubscriptionOfferApplicationPhaseVariant1

- `type` (`String`, required)
- `durationDays` (`Long`, required)
- `durationInterval` (`String | null`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)

### SubscriptionOfferApplicationPhaseVariant2

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `percentage` (`Long`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)

### SubscriptionOfferApplicationPhaseVariant3

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `amount` (`Long`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)

### SubscriptionOfferApplicationPhaseVariant4

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required)
- `price` (`Long`, required)
- `startsAt` (`String | null`, required)
- `endsAt` (`String | null`, required)

### SubscriptionPlan

- `id` (`String`, required)
- `name` (`String`, required)
- `basePrice` (`Double`, required)

### SubscriptionPlanGrant

- `id` (`String`, required) — The active Plan Grant ID.
- `plan` (`SubscriptionPlanGrantPlan`, required) — The higher plan whose access is temporarily applied.
- `expiresAt` (`String | null`, required) — When the temporary access ends, or null when it lasts until revoked.

### SubscriptionPlanGrantPlan

- `id` (`String`, required)
- `name` (`String`, required)

### SubscriptionScheduledPlanChange

- `changeType` (`String`, required)
- `newPlanId` (`String | null`, required)
- `newPlanName` (`String | null`, required)
- `newBillingInterval` (`String | null`, required)
- `scheduledFor` (`String`, required)

### SubscriptionsListResult

- `object` (`String`, required)
- `data` (`List<SubscriptionSummary>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### SubscriptionSummary

- `id` (`String`, required)
- `customerId` (`String`, required)
- `plan` (`SubscriptionSummaryPlan`, required)
- `name` (`String`, required)
- `description` (`String | null`, required)
- `status` (`SubscriptionStatus`, required)
- `billingInterval` (`BillingInterval | null`, required)
- `trialEndsAt` (`String | null`, required)
- `currentPeriod` (`SubscriptionSummaryCurrentPeriod | null`, required)
- `cancellation` (`SubscriptionSummaryCancellation | null`, required)
- `cancelAtPeriodEnd` (`Boolean`, required)
- `scheduledPlanChange` (`SubscriptionSummaryScheduledPlanChange | null`, required)
- `startDate` (`String`, required)
- `endDate` (`String | null`, required)
- `billingDayOfMonth` (`Long | null`, required)
- `nextBillingDate` (`String | null`, required)
- `checkoutUrl` (`String | null`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `offerApplications` (`List<SubscriptionOfferApplication>`, required)
- `priceId` (`String | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### SubscriptionSummaryCancellation

- `scheduledAt` (`String`, required)
- `reason` (`String | null`, required)
- `effectiveAt` (`String`, required)

### SubscriptionSummaryCurrentPeriod

- `start` (`String`, required)
- `end` (`String`, required)
- `daysRemaining` (`Double`, required)

### SubscriptionSummaryPlan

- `id` (`String`, required)
- `name` (`String`, required)

### SubscriptionSummaryScheduledPlanChange

- `changeType` (`String`, required)
- `newPlanId` (`String | null`, required)
- `newPlanName` (`String | null`, required)
- `newBillingInterval` (`String | null`, required)
- `scheduledFor` (`String`, required)

### TestClock

- `simulatedTime` (`String | null`, required)
- `isActive` (`Boolean`, required)
- `now` (`String`, required)
- `latestRun` (`TestClockLatestRun | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### TestClockLatestRun

- `id` (`String`, required)
- `status` (`String`, required)
- `startedAtTime` (`String`, required)
- `targetTime` (`String`, required)
- `estimatedDeadlineCount` (`Long`, required)
- `completedDeadlineCount` (`Long`, required)
- `failedDeadlineCount` (`Long`, required)
- `error` (`String | null`, required)
- `items` (`List<TestClockLatestRunItemsItem>`, required)

### TestClockLatestRunItemsItem

- `kind` (`String`, required)
- `status` (`String`, required)
- `dueAt` (`String`, required)
- `subscriptionId` (`String`, required)
- `customerName` (`String | null`, required)
- `invoiceNumber` (`String | null`, required)
- `invoiceId` (`String | null`, required)
- `outcome` (`String | null`, required)
- `detail` (`String | null`, required)
- `error` (`String | null`, required)

### TestClockRun

- `id` (`String`, required)
- `status` (`String`, required)
- `startedAtTime` (`String`, required)
- `targetTime` (`String`, required)
- `estimatedDeadlineCount` (`Long`, required)
- `completedDeadlineCount` (`Long`, required)
- `failedDeadlineCount` (`Long`, required)
- `error` (`String | null`, required)
- `items` (`List<TestClockRunItemsItem>`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### TestClockRunItemsItem

- `kind` (`String`, required)
- `status` (`String`, required)
- `dueAt` (`String`, required)
- `subscriptionId` (`String`, required)
- `customerName` (`String | null`, required)
- `invoiceNumber` (`String | null`, required)
- `invoiceId` (`String | null`, required)
- `outcome` (`String | null`, required)
- `detail` (`String | null`, required)
- `error` (`String | null`, required)

### TrackUsageParamsPropertiesItem

- `property` (`String`, required)
- `value` (`String`, required)

### Transaction

- `id` (`String`, required)
- `invoiceId` (`String | null`, required)
- `grossAmount` (`Long | null`, required) — Gross amount in USD cents. Null when the provider has not reported an honest USD figure; see presentmentAmount.
- `subtotal` (`Long | null`, required) — Subtotal in USD cents (gross minus tax). Null when grossAmount is null.
- `taxAmount` (`Long | null`, required)
- `presentmentAmount` (`Long | null`, required) — Amount in the charge currency's smallest unit, as presented to the customer. Set for non-USD charges; null when the charge was made in USD.
- `currency` (`String`, required)
- `provider` (`PaymentProvider`, required) — The payment provider the charge was routed to: stripe, commet, or dlocal.
- `status` (`TransactionStatus`, required)
- `customerEmail` (`String | null`, required)
- `customerName` (`String | null`, required)
- `paidAt` (`String | null`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `availableAt` (`String | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### TransactionListItem

- `id` (`String`, required)
- `invoiceId` (`String | null`, required)
- `grossAmount` (`Long | null`, required) — Gross amount in USD cents. Null when the provider has not reported an honest USD figure; see presentmentAmount.
- `subtotal` (`Long | null`, required) — Subtotal in USD cents (gross minus tax). Null when grossAmount is null.
- `taxAmount` (`Long | null`, required)
- `presentmentAmount` (`Long | null`, required) — Amount in the charge currency's smallest unit, as presented to the customer. Set for non-USD charges; null when the charge was made in USD.
- `currency` (`String`, required)
- `provider` (`PaymentProvider`, required) — The payment provider the charge was routed to: stripe, commet, or dlocal.
- `status` (`TransactionStatus`, required)
- `customerEmail` (`String | null`, required)
- `customerName` (`String | null`, required)
- `paidAt` (`String | null`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### TransactionRetry

- `originalTransactionId` (`String`, required)
- `invoiceId` (`String`, required)
- `status` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### TransactionsListResult

- `object` (`String`, required)
- `data` (`List<TransactionListItem>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### UpdateCustomerParamsAddress

- `line1` (`String`, required)
- `line2` (`String`, optional)
- `city` (`String`, required)
- `state` (`String`, optional)
- `postalCode` (`String`, required)
- `country` (`String`, required)
- `region` (`String`, optional)

### UpdateOfferParamsPhasesItem

Variants:

- `UpdateOfferParamsPhasesItemVariant1`
- `UpdateOfferParamsPhasesItemVariant2`
- `UpdateOfferParamsPhasesItemVariant3`
- `UpdateOfferParamsPhasesItemVariant4`

Discriminator: `type`

- `"free_trial"` → `UpdateOfferParamsPhasesItemVariant1`
- `"percentage"` → `UpdateOfferParamsPhasesItemVariant2`
- `"amount_off"` → `UpdateOfferParamsPhasesItemVariant3`
- `"fixed_price"` → `UpdateOfferParamsPhasesItemVariant4`

### UpdateOfferParamsPhasesItemVariant1

- `type` (`String`, required)
- `durationDays` (`Long`, required)

### UpdateOfferParamsPhasesItemVariant2

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, optional) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `percentage` (`Long`, required) — Discount in basis points. 5000 means 50%.

### UpdateOfferParamsPhasesItemVariant3

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, optional) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `amounts` (`List<UpdateOfferParamsPhasesItemVariant3AmountsItem>`, required)

### UpdateOfferParamsPhasesItemVariant3AmountsItem

- `currency` (`String`, required)
- `amount` (`Long`, required) — Amount in the currency's minor unit (for example, cents for USD).

### UpdateOfferParamsPhasesItemVariant4

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, optional) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `prices` (`List<UpdateOfferParamsPhasesItemVariant4PricesItem>`, required)

### UpdateOfferParamsPhasesItemVariant4PricesItem

- `currency` (`String`, required)
- `amount` (`Long`, required) — Amount in the currency's minor unit (for example, cents for USD).

### UpdatePlanFeatureParamsOverage

- `enabled` (`Boolean`, optional)
- `unitPrice` (`Long`, optional)

### UpdatePlanPriceParamsMarketPricesItem

- `marketGroupId` (`String`, required)
- `currency` (`String`, required)
- `price` (`Long`, required)

### UpsertRegionalPricesParamsOverridesItem

- `currency` (`String`, required)
- `price` (`Long`, required)
- `includedBalance` (`Long`, optional)

### UsageAdjustment

- `id` (`String`, required)
- `value` (`Long`, required)
- `previousValue` (`Long`, required)
- `adjustment` (`Long`, required)
- `customerId` (`String`, required)
- `reason` (`String | null`, required)
- `ts` (`String`, required)
- `createdAt` (`String`, required)
- `featureCode` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### UsageCheck

Variants:

- `UsageCheckVariant1`
- `UsageCheckVariant2`
- `UsageCheckVariant3`

Discriminator: `consumptionModel`

- `"metered"` → `UsageCheckVariant1`
- `"credits"` → `UsageCheckVariant2`
- `"balance"` → `UsageCheckVariant3`

### UsageCheckVariant1

- `allowed` (`Boolean`, required)
- `subscriptionStatus` (`String`, required)
- `featureCode` (`String`, required)
- `quantity` (`Long`, required)
- `reason` (`String`, optional)
- `message` (`String`, optional)
- `consumptionModel` (`String`, required)
- `current` (`Double`, required)
- `remaining` (`Double`, required)
- `unlimited` (`Boolean`, required)
- `included` (`Double`, required)
- `overageEnabled` (`Boolean`, required)
- `overageUnitPrice` (`Double | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### UsageCheckVariant2

- `allowed` (`Boolean`, required)
- `subscriptionStatus` (`String`, required)
- `featureCode` (`String`, required)
- `quantity` (`Long`, required)
- `reason` (`String`, optional)
- `message` (`String`, optional)
- `consumptionModel` (`String`, required)
- `creditsPerUnit` (`Long`, required)
- `estimatedCredits` (`Long`, required)
- `planCredits` (`Long`, required)
- `purchasedCredits` (`Long`, required)
- `totalCredits` (`Long`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### UsageCheckVariant3

- `allowed` (`Boolean`, required)
- `subscriptionStatus` (`String`, required)
- `featureCode` (`String`, required)
- `quantity` (`Long`, required)
- `reason` (`String`, optional)
- `message` (`String`, optional)
- `consumptionModel` (`String`, required)
- `unitPrice` (`Double`, required)
- `estimatedAmount` (`Double`, required)
- `currentBalance` (`Double`, required)
- `blockOnExhaustion` (`Boolean`, required)
- `currency` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### UsageEvent

- `id` (`String`, required)
- `featureCode` (`String`, required)
- `value` (`Double`, required)
- `customerId` (`String`, required)
- `eventId` (`String | null`, required)
- `ts` (`String`, required)
- `createdAt` (`String`, required)
- `properties` (`List<UsageEventPropertiesItem>`, required)
- `consumption` (`UsageEventConsumption`, optional)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### UsageEventConsumption

- `model` (`String`, required)
- `deducted` (`Double`, required)
- `remaining` (`Double`, required)
- `blocked` (`Boolean`, required)

### UsageEventPropertiesItem

- `property` (`String`, required)
- `value` (`String`, required)

### UsageQuota

- `featureCode` (`String`, required)
- `current` (`Double`, required)
- `included` (`Double`, required)
- `remaining` (`Double | null`, required)
- `billedQuantity` (`Double`, required)
- `unlimited` (`Boolean`, required)
- `overageEnabled` (`Boolean`, required)
- `asOf` (`String | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### UsageQuotaEvent

- `id` (`String`, required)
- `customerId` (`String`, required)
- `featureCode` (`String`, required)
- `previousBalance` (`Long`, required)
- `newBalance` (`Long`, required)
- `ts` (`String`, required)
- `createdAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### Webhook

- `id` (`String`, required)
- `url` (`String`, required)
- `events` (`List<String>`, required)
- `description` (`String | null`, required)
- `isActive` (`Boolean`, required)
- `apiVersion` (`String | null`, required)
- `createdAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### WebhookAddonRef

- `id` (`String`, required)
- `name` (`String`, required)

### WebhookBalance

- `currentBalance` (`Double`, required)

### WebhookBankRef

- `bankName` (`String | null`, required)
- `last4` (`String`, required)

### WebhookCardInfo

- `brand` (`String`, required)
- `last4` (`String`, required)
- `expMonth` (`Double`, required)
- `expYear` (`Double`, required)

### WebhookCreditsBalance

- `planCredits` (`Double`, required)
- `purchasedCredits` (`Double`, required)
- `totalCredits` (`Double`, required)

### WebhookPlanGrantTimelineEvent

- `id` (`String`, required) — The public ID of this plan grant event.
- `type` (`String`, required) — The durable lifecycle transition recorded by this event.
- `reason` (`String`, required) — The reason recorded for this transition.
- `source` (`String`, required) — Where this transition originated.
- `previousExpiresAt` (`String | null`, required) — The prior expiration deadline for an update, otherwise null.
- `expiresAt` (`String | null`, required) — The expiration deadline after this transition, if any.
- `duration` (`String | null`, required) — The duration selected by a create or update event.
- `durationCycles` (`Long | null`, required) — The selected cycle count when duration is cycles.
- `requestedExpiresAt` (`String | null`, required) — The requested deadline when duration is until_date.
- `createdAt` (`String`, required) — When this transition occurred.

### WebhookPlanRef

- `id` (`String`, required)
- `name` (`String`, required)

### WebhookSeatSummary

- `code` (`String`, required)
- `current` (`Double | null`, required)
- `included` (`Double | null`, required)
- `remaining` (`Double | null`, required)
- `unlimited` (`Boolean | null`, required)

### WebhooksListResult

- `object` (`String`, required)
- `data` (`List<Webhook>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### WebhookTest

- `success` (`Boolean`, required)
- `deliveryId` (`String`, required)
- `deliveredAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)
