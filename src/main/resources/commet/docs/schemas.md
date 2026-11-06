# Schemas

Generated from Commet API version `2026-08-27`.

## Enums

### BillingInterval

- `"weekly"`
- `"monthly"`
- `"quarterly"`
- `"semiannual"`
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
- `"resume"`
- `"prepayment"`

### PaymentMethod

- `"card"`
- `"oxxo"`
- `"mercado_pago"`
- `"google_pay"`
- `"smartpix"`

### PaymentProvider

- `"stripe"`
- `"commet"`
- `"dlocal"`

### SubPaymentMethod

- `"credit_card"`
- `"debit_card"`
- `"prepaid_card"`
- `"bank_transfer"`
- `"account_money"`

### SubscriptionStatus

- `"draft"`
- `"pending_payment"`
- `"trialing"`
- `"active"`
- `"past_due"`
- `"paused"`
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
- `planIds` (`List<String>`, required) — Plans that sell the add-on.
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

### ArchivePlanExperimentParamsChangesItem

- `subscriptionId` (`String`, required)
- `keepOnVersion` (`Object`, optional) — Leave this subscriber on its version.
- `billingInterval` (`String`, optional)
- `seatLimit` (`Object`, optional) — Lower its seats to the version's limit at renewal.
- `removeAddonIds` (`List<String>`, optional) — Add-ons it stops paying at renewal.

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

### BusinessTaxId

- `country` (`String`, required)
- `type` (`String`, required)
- `value` (`String`, required)

### ClaimLink

- `url` (`String`, required)
- `expiresAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### CreateApiKeyParamsPermissions

- `customer` (`List<String>`, optional)
- `subscription` (`List<String>`, optional)
- `invoice` (`List<String>`, optional)
- `usage` (`List<String>`, optional)
- `seat` (`List<String>`, optional)
- `plan` (`List<String>`, optional)
- `plan_group` (`List<String>`, optional)
- `feature` (`List<String>`, optional)
- `addon` (`List<String>`, optional)
- `credit_pack` (`List<String>`, optional)
- `offer` (`List<String>`, optional)
- `promo_code` (`List<String>`, optional)
- `market_group` (`List<String>`, optional)
- `payment` (`List<String>`, optional)
- `transaction` (`List<String>`, optional)
- `payout` (`List<String>`, optional)
- `test_clock` (`List<String>`, optional)
- `organization` (`List<String>`, optional)
- `api_key` (`List<String>`, optional)

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
- `hasPaymentMethod` (`Boolean`, required) — Whether Commet can charge this subscription on its own at its next charge (the trial end or the renewal). A trial that started without a payment method reports false until the customer adds one for this subscription; a payment method saved for another subscription does not count. A subscription on a free plan reports false.
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `planVersion` (`CreatedSubscriptionPlanVersion | null`, required) — The plan version whose terms the subscription has now. It keeps paying and receiving everything from this version until it is moved.
- `offerApplications` (`List<SubscriptionOfferApplication>`, required)
- `pause` (`CreatedSubscriptionPause | null`, required)
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

### CreatedSubscriptionPause

Variants:

- `CreatedSubscriptionPauseVariant1`
- `CreatedSubscriptionPauseVariant2`

Discriminator: `status`

- `"scheduled"` → `CreatedSubscriptionPauseVariant1`
- `"active"` → `CreatedSubscriptionPauseVariant2`

### CreatedSubscriptionPauseVariant1

- `status` (`String`, required)
- `mode` (`String`, required)
- `requestedAt` (`String`, required)
- `effectiveAt` (`String`, required)
- `resumeAt` (`String | null`, required)

### CreatedSubscriptionPauseVariant2

- `status` (`String`, required)
- `mode` (`String`, required)
- `requestedAt` (`String`, required)
- `effectiveAt` (`String`, required)
- `resumeAt` (`String | null`, required)

### CreatedSubscriptionPlan

- `id` (`String`, required)
- `name` (`String`, required)

### CreatedSubscriptionPlanVersion

- `id` (`String`, required) — Public plan version ID.
- `label` (`String`, required) — Main versions are 1, 2, 3; an experiment's versions carry its own code, like price-test 2.

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

Discriminator: `type`

- `"percentage"` → `CreateOfferParamsPhasesItemVariant1`
- `"amount_off"` → `CreateOfferParamsPhasesItemVariant2`
- `"fixed_price"` → `CreateOfferParamsPhasesItemVariant3`

### CreateOfferParamsPhasesItemVariant1

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, optional) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `percentage` (`Long`, required) — Discount in basis points. 5000 means 50%.

### CreateOfferParamsPhasesItemVariant2

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, optional) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `amounts` (`List<CreateOfferParamsPhasesItemVariant2AmountsItem>`, required)

### CreateOfferParamsPhasesItemVariant2AmountsItem

- `currency` (`String`, required)
- `amount` (`Long`, required) — Amount in the currency's minor unit (for example, cents for USD).

### CreateOfferParamsPhasesItemVariant3

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, optional) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `prices` (`List<CreateOfferParamsPhasesItemVariant3PricesItem>`, required)

### CreateOfferParamsPhasesItemVariant3PricesItem

- `currency` (`String`, required)
- `amount` (`Long`, required) — Amount in the currency's minor unit (for example, cents for USD).

### CreatePlanExperimentParamsCurrenciesItem

- `currency` (`String`, required)
- `exchangeRate` (`Double`, required)

### CreatePlanExperimentParamsPricesItem

- `billingInterval` (`String`, required) — An interval the plan already sells. Prices not listed are copied unchanged from the current version.
- `price` (`Long`, required) — USD price in the currency's minor unit (cents).
- `includedCredits` (`Long | null`, optional)
- `includedBalance` (`Long | null`, optional)
- `regionalPrices` (`List<CreatePlanExperimentParamsPricesItemRegionalPricesItem>`, optional) — Per-currency amounts. A currency the current version does not sell also needs its exchangeRate in currencies; its amounts not listed here are derived from the USD price.

### CreatePlanExperimentParamsPricesItemRegionalPricesItem

- `currency` (`String`, required)
- `price` (`Long`, required)
- `includedBalance` (`Long | null`, optional)

### CreatePlanExperimentVersionParamsCurrenciesItem

- `currency` (`String`, required)
- `exchangeRate` (`Double`, required)

### CreatePlanExperimentVersionParamsPricesItem

- `billingInterval` (`String`, required) — An interval the plan already sells. Prices not listed are copied unchanged from the current version.
- `price` (`Long`, required) — USD price in the currency's minor unit (cents).
- `includedCredits` (`Long | null`, optional)
- `includedBalance` (`Long | null`, optional)
- `regionalPrices` (`List<CreatePlanExperimentVersionParamsPricesItemRegionalPricesItem>`, optional) — Per-currency amounts. A currency the current version does not sell also needs its exchangeRate in currencies; its amounts not listed here are derived from the USD price.

### CreatePlanExperimentVersionParamsPricesItemRegionalPricesItem

- `currency` (`String`, required)
- `price` (`Long`, required)
- `includedBalance` (`Long | null`, optional)

### CreatePlanMoveParamsChangesItem

- `subscriptionId` (`String`, required)
- `keepOnVersion` (`Object`, optional) — Leave this subscriber on its version.
- `billingInterval` (`String`, optional)
- `seatLimit` (`Object`, optional) — Lower its seats to the version's limit at renewal.
- `removeAddonIds` (`List<String>`, optional) — Add-ons it stops paying at renewal.

### CreatePlanParamsPlanBalanceLimit

- `amount` (`Long`, required) — The most plan balance a subscription spends in one window, in USD cents. Other currencies convert it with the plan's exchange rate unless the dashboard sets a custom amount for that currency.
- `interval` (`String`, required) — The window length: `day` is 24 hours and `week` is 7 days, starting at the time of day of the subscription's billing anchor.

### CreatePlanParamsPlanCreditLimit

- `credits` (`Long`, required) — The most plan credits a subscription spends in one window.
- `interval` (`String`, required) — The window length: `day` is 24 hours and `week` is 7 days, starting at the time of day of the subscription's billing anchor.

### CreatePlanParamsUnusedPlanBalance

Variants:

- `CreatePlanParamsUnusedPlanBalanceVariant1`
- `CreatePlanParamsUnusedPlanBalanceVariant2`

Discriminator: `type`

- `"expire"` → `CreatePlanParamsUnusedPlanBalanceVariant1`
- `"roll_over"` → `CreatePlanParamsUnusedPlanBalanceVariant2`

### CreatePlanParamsUnusedPlanBalanceVariant1

- `type` (`String`, required)

### CreatePlanParamsUnusedPlanBalanceVariant2

- `type` (`String`, required)
- `maxPlanBalance` (`Long | null`, required) — The most plan balance a subscription holds after a reset, in USD cents, including the balance that reset grants; balance above it expires. At least the included balance of every price. Other currencies convert it with the plan's exchange rate unless the dashboard sets a custom amount for that currency. null means no limit other than the largest storable amount, 2,147,483,647 cents.

### CreatePlanParamsUnusedPlanCredits

Variants:

- `CreatePlanParamsUnusedPlanCreditsVariant1`
- `CreatePlanParamsUnusedPlanCreditsVariant2`

Discriminator: `type`

- `"expire"` → `CreatePlanParamsUnusedPlanCreditsVariant1`
- `"roll_over"` → `CreatePlanParamsUnusedPlanCreditsVariant2`

### CreatePlanParamsUnusedPlanCreditsVariant1

- `type` (`String`, required)

### CreatePlanParamsUnusedPlanCreditsVariant2

- `type` (`String`, required)
- `maxPlanCredits` (`Long | null`, required) — The most plan credits a subscription holds after a reset, including the credits that reset grants; credits above it expire. At least the included credits of every price. null means no limit other than the largest storable balance, 2,147,483,647 plan credits.

### CreatePlanVersionParamsCurrenciesItem

- `currency` (`String`, required)
- `exchangeRate` (`Double`, required)

### CreatePlanVersionParamsPricesItem

- `billingInterval` (`String`, required) — An interval the plan already sells. Prices not listed are copied unchanged from the current version.
- `price` (`Long`, required) — USD price in the currency's minor unit (cents).
- `includedCredits` (`Long | null`, optional)
- `includedBalance` (`Long | null`, optional)
- `regionalPrices` (`List<CreatePlanVersionParamsPricesItemRegionalPricesItem>`, optional) — Per-currency amounts. A currency the current version does not sell also needs its exchangeRate in currencies; its amounts not listed here are derived from the USD price.

### CreatePlanVersionParamsPricesItemRegionalPricesItem

- `currency` (`String`, required)
- `price` (`Long`, required)
- `includedBalance` (`Long | null`, optional)

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
- `planIds` (`List<String>`, required) — Plans that sell the credit pack.
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
- `planIds` (`List<String>`, required) — Plans that sell the credit pack.
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
- `businessTaxId` (`BusinessTaxId | null`, required)
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

### KeptOnVersion

- `subscriptionId` (`String`, required)
- `keptOnVersion` (`Object`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### ManagedBy

Variants:

- `String`
- `Object`

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
- `managedBy` (`ManagedBy`, required) — Integration that manages this record, or null when the merchant does. While an integration manages it, its terms change only in that integration and edits answer 409 managed_by_integration.
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### OfferPhasesItem

Variants:

- `OfferPhasesItemVariant1`
- `OfferPhasesItemVariant2`
- `OfferPhasesItemVariant3`

Discriminator: `type`

- `"percentage"` → `OfferPhasesItemVariant1`
- `"amount_off"` → `OfferPhasesItemVariant2`
- `"fixed_price"` → `OfferPhasesItemVariant3`

### OfferPhasesItemVariant1

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `percentage` (`Long`, required) — Discount in basis points. 5000 means 50%.

### OfferPhasesItemVariant2

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `amounts` (`List<OfferPhasesItemVariant2AmountsItem>`, required)

### OfferPhasesItemVariant2AmountsItem

- `currency` (`String`, required)
- `amount` (`Long`, required) — Amount in the currency's minor unit (for example, cents for USD).

### OfferPhasesItemVariant3

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, required) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `prices` (`List<OfferPhasesItemVariant3PricesItem>`, required)

### OfferPhasesItemVariant3PricesItem

- `currency` (`String`, required)
- `amount` (`Long`, required) — Amount in the currency's minor unit (for example, cents for USD).

### OffersListResult

- `object` (`String`, required)
- `data` (`List<Offer>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### Payment

- `paymentContext` (`PaymentPaymentContext | null`, required) — Charge context captured for new payments. Null for historical payments with no captured context.
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

### PaymentPaymentContext

- `reason` (`String`, required) — The original reason for the charge. Recovery never replaces this reason.
- `paymentLinkId` (`String | null`, required) — The public payment link ID, independently of the reason, or null when no payment link originated the charge.
- `recovery` (`PaymentPaymentContextRecovery | null`, required)

### PaymentPaymentContextRecovery

Variants:

- `PaymentPaymentContextRecoveryVariant1`
- `PaymentPaymentContextRecoveryVariant2`

Discriminator: `type`

- `"payment_recovery"` → `PaymentPaymentContextRecoveryVariant1`
- `"dunning_retry"` → `PaymentPaymentContextRecoveryVariant2`

### PaymentPaymentContextRecoveryVariant1

- `type` (`String`, required)

### PaymentPaymentContextRecoveryVariant2

- `type` (`String`, required)
- `attempt` (`Long`, required) — Current retry, starting at 1. The original decline is not a retry.
- `maxAttempts` (`Long`, required) — Total retries applicable to this charge's dunning schedule.

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
- `blockOnExhaustion` (`Boolean | null`, required) — Credits and balance plans: true stops usage when the plan and purchased amounts run out; false lets usage continue and bills the missing amount as overage at the next renewal (credits at the price per credit). Trials and free plans always stop.
- `unusedPlanCredits` (`PlanUnusedPlanCredits | null`, required) — Credits plans only; null for other consumption models. What happens to unused plan credits at each reset. Purchased credits never expire and never count toward maxPlanCredits.
- `planCreditLimit` (`PlanPlanCreditLimit | null`, required) — Credits plans only. The most plan credits a subscription spends per day or per week; null means no limit.
- `unusedPlanBalance` (`PlanUnusedPlanBalance | null`, required) — Balance plans only; null for other consumption models. What happens to unused plan balance at each reset. Purchased balance never expires and never counts toward maxPlanBalance.
- `planBalanceLimit` (`PlanPlanBalanceLimit | null`, required) — Balance plans only. The most plan balance a subscription spends per day or per week, in USD cents; null means no limit.
- `sortOrder` (`Long`, required)
- `planGroupId` (`String | null`, required)
- `metadata` (`Map<String, Object> | null`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `features` (`List<PlanFeaturesItem>`, required)
- `prices` (`List<PlanPricesItem>`, required)
- `exchangeRates` (`List<PlanExchangeRatesItem>`, required)
- `countries` (`List<PlanCountriesItem>`, required) — Countries with their own currency or prices in the current version. Buyers from any other country pay the USD prices.
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

### PlanCountriesItem

- `country` (`String`, required) — ISO country code.
- `currency` (`String`, required) — The currency buyers from the country pay, USD included.
- `prices` (`List<PlanCountriesItemPricesItem>`, required)
- `addons` (`List<PlanCountriesItemAddonsItem>`, required) — Every add-on the version sells, priced for the country.
- `creditPacks` (`List<PlanCountriesItemCreditPacksItem>`, required) — Every credit pack the version sells, priced for the country.

### PlanCountriesItemAddonsItem

- `addonId` (`String`, required)
- `price` (`Long`, required) — What buyers from the country pay for the add-on, in the currency's minor unit.
- `manual` (`Boolean`, required) — True when set by hand; false when it follows the add-on's USD price at the exchange rate.

### PlanCountriesItemCreditPacksItem

- `creditPackId` (`String`, required)
- `price` (`Long`, required) — What buyers from the country pay for the pack, in the currency's minor unit.
- `manual` (`Boolean`, required) — True when set by hand; false when it follows the pack's USD price at the exchange rate.

### PlanCountriesItemPricesItem

- `billingInterval` (`BillingInterval`, required)
- `price` (`Long`, required) — The country's price in the currency's minor unit.
- `manual` (`Boolean`, required) — True when set by hand; false when it follows the USD base at the exchange rate.

### PlanDraft

- `id` (`String`, required) — Public plan draft ID.
- `fromVersionId` (`String`, required) — The version the draft started from.
- `changes` (`List<PlanDraftChangesItem>`, required) — What the draft changes against the version it started from.
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanDraftChangesItem

- `key` (`String`, required) — Identifies the change; send it to undo just this change.
- `section` (`String`, required) — Where the change is: Price, Trial, a rules section, Add-ons, or a country.
- `country` (`String | null`, required) — ISO country code when the change belongs to one country.
- `label` (`String`, required) — What changed, such as Monthly price.
- `before` (`String | null`, required) — The value before, formatted.
- `after` (`String | null`, required) — The value now, formatted.

### PlanDraftPublication

- `preview` (`Boolean`, required)
- `version` (`PlanDraftPublicationVersion | null`, required) — The published version. Null for a preview.
- `moveId` (`String | null`, required) — The move of subscribers, if any.
- `subscribers` (`PlanDraftPublicationSubscribers | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanDraftPublicationSubscribers

- `moving` (`Long`, required)
- `keptOnVersion` (`Long`, required)
- `needsAChange` (`Long`, required) — Left on their version because no change makes them fit; they show among the subscribers that need a change.
- `leftOut` (`List<PlanDraftPublicationSubscribersLeftOutItem>`, required)

### PlanDraftPublicationSubscribersLeftOutItem

- `subscriptionId` (`String`, required)
- `code` (`String`, required)
- `message` (`String`, required)

### PlanDraftPublicationVersion

- `id` (`String`, required) — Public plan version ID.
- `label` (`String`, required) — The plan's versions are numbered 1, 2, 3; an experiment's own versions read with its code, such as price-test 2.
- `number` (`Long | null`, required) — The plan's version number. Null for a version that only belongs to an experiment; an experiment version made current takes the next number.
- `experiment` (`PlanDraftPublicationVersionExperiment | null`, required) — The experiment this version belongs to, if any.
- `isCurrent` (`Boolean`, required) — Whether new buyers get this version.
- `parentVersionId` (`String | null`, required) — The version this one was created from.
- `subscriptionCount` (`Long`, required) — Active, trialing, past due and paused subscriptions on it.
- `maxPlanCredits` (`Long | null`, required)
- `maxPlanBalance` (`Long | null`, required)
- `prices` (`List<PlanDraftPublicationVersionPricesItem>`, required)
- `createdAt` (`String`, required)

### PlanDraftPublicationVersionExperiment

- `code` (`String`, required) — The experiment's code, as sold with planCode.
- `version` (`Long`, required) — Its number within the experiment.

### PlanDraftPublicationVersionPricesItem

- `id` (`String`, required) — Public plan price ID.
- `billingInterval` (`String`, required)
- `price` (`Long`, required)
- `includedCredits` (`Long | null`, required)
- `includedBalance` (`Long | null`, required)
- `regionalPrices` (`List<PlanDraftPublicationVersionPricesItemRegionalPricesItem>`, required)

### PlanDraftPublicationVersionPricesItemRegionalPricesItem

- `currency` (`String`, required)
- `price` (`Long`, required)
- `includedBalance` (`Long | null`, required)

### PlanExchangeRatesItem

- `currency` (`String`, required)
- `exchangeRate` (`Double`, required)

### PlanExperiment

- `id` (`String`, required) — Public plan experiment ID.
- `code` (`String`, required) — The code to sell it with as planCode, such as pro:price-test. It always sells the experiment's latest version while running, and the plan's current version once closed.
- `status` (`String`, required) — running sells its latest version; won became the plan's current version; archived stopped selling.
- `startedFromVersionId` (`String`, required) — The plan's version that was current when it started.
- `latestVersionId` (`String`, required) — Its latest version.
- `sellsVersionId` (`String`, required) — The version its code sells to new buyers today.
- `subscriptionCount` (`Long`, required) — Active, trialing, past due and paused subscriptions on its versions.
- `createdAt` (`String`, required)
- `closedAt` (`String | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanExperimentArchive

- `experiment` (`PlanExperimentArchiveExperiment`, required)
- `moveId` (`String | null`, required) — The move of its subscribers, or null when they stay.
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanExperimentArchiveExperiment

- `id` (`String`, required) — Public plan experiment ID.
- `code` (`String`, required) — The code to sell it with as planCode, such as pro:price-test. It always sells the experiment's latest version while running, and the plan's current version once closed.
- `status` (`String`, required) — running sells its latest version; won became the plan's current version; archived stopped selling.
- `startedFromVersionId` (`String`, required) — The plan's version that was current when it started.
- `latestVersionId` (`String`, required) — Its latest version.
- `sellsVersionId` (`String`, required) — The version its code sells to new buyers today.
- `subscriptionCount` (`Long`, required) — Active, trialing, past due and paused subscriptions on its versions.
- `createdAt` (`String`, required)
- `closedAt` (`String | null`, required)

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

### PlanMove

- `id` (`String | null`, required) — Public move ID. Null for a preview, which records nothing.
- `toVersionId` (`String`, required)
- `fromVersionIds` (`List<String>`, required) — The versions its subscribers are moving from.
- `effective` (`String`, required)
- `preview` (`Boolean`, required)
- `status` (`String`, required) — checked is a preview where everyone fits; moving while subscribers wait for their move; completed once every move ran; canceled after it was canceled.
- `counts` (`PlanMoveCounts`, required)
- `subscriptions` (`List<PlanMoveSubscriptionsItem>`, required)
- `createdAt` (`String | null`, required)
- `completedAt` (`String | null`, required)
- `canceledAt` (`String | null`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanMoveCounts

- `moving` (`Long`, required)
- `moved` (`Long`, required)
- `needsAChange` (`Long`, required)
- `leftOut` (`Long`, required)
- `canceled` (`Long`, required)
- `keptOnVersion` (`Long`, required)

### PlanMoveSubscriptionsItem

- `subscriptionId` (`String`, required)
- `status` (`String`, required) — moving waits for its renewal or is being moved; moved is on the destination; needs_a_change could not move and keeps its version until it is resolved or kept; left_out was not moved because it was not active, trialing or past due, such as a paused subscription (invalid_subscription_status), or because a listed subscription was already on the destination (no_change_requested); canceled was canceled before it moved; kept_on_version was left on its version by the merchant.
- `code` (`String | null`, required)
- `message` (`String | null`, required)

### PlanPlanBalanceLimit

- `amount` (`Long`, required) — The most plan balance a subscription spends in one window, in USD cents. Other currencies convert it with the plan's exchange rate unless the dashboard sets a custom amount for that currency.
- `interval` (`String`, required) — The window length: `day` is 24 hours and `week` is 7 days, starting at the time of day of the subscription's billing anchor.

### PlanPlanCreditLimit

- `credits` (`Long`, required) — The most plan credits a subscription spends in one window.
- `interval` (`String`, required) — The window length: `day` is 24 hours and `week` is 7 days, starting at the time of day of the subscription's billing anchor.

### PlanPrice

- `id` (`String`, required) — Public plan price ID.
- `planId` (`String`, required)
- `billingInterval` (`BillingInterval`, required)
- `price` (`Long`, required) — Price in the currency's minor unit (for example, cents for USD).
- `isDefault` (`Boolean`, required)
- `trialDays` (`Long`, required)
- `trialRequiresPaymentMethod` (`Boolean | null`, required) — Whether the price's free trial needs a payment method to start. When false, a new subscription starts trialing right away without checkout; without a payment method added by the trial end, the customer moves to the plan group's default plan, or the subscription is canceled when there is none. Null when the price has no trial.
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
- `trialRequiresPaymentMethod` (`Boolean | null`, required) — Whether the price's free trial needs a payment method to start. When false, a new subscription starts trialing right away without checkout; without a payment method added by the trial end, the customer moves to the plan group's default plan, or the subscription is canceled when there is none. Null when the price has no trial.
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

### PlansListDraftsResult

- `object` (`String`, required)
- `data` (`List<PlanDraft>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### PlansListExperimentsResult

- `object` (`String`, required)
- `data` (`List<PlanExperiment>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### PlansListMovesResult

- `object` (`String`, required)
- `data` (`List<PlanMove>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### PlansListResult

- `object` (`String`, required)
- `data` (`List<Plan>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### PlansListSubscribersNeedingAChangeResult

- `object` (`String`, required)
- `data` (`List<SubscriberNeedingAChange>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### PlansListVersionsResult

- `object` (`String`, required)
- `data` (`List<PlanVersion>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### PlanUnusedPlanBalance

Variants:

- `PlanUnusedPlanBalanceVariant1`
- `PlanUnusedPlanBalanceVariant2`

Discriminator: `type`

- `"expire"` → `PlanUnusedPlanBalanceVariant1`
- `"roll_over"` → `PlanUnusedPlanBalanceVariant2`

### PlanUnusedPlanBalanceVariant1

- `type` (`String`, required)

### PlanUnusedPlanBalanceVariant2

- `type` (`String`, required)
- `maxPlanBalance` (`Long | null`, required) — The most plan balance a subscription holds after a reset, in USD cents, including the balance that reset grants; balance above it expires. At least the included balance of every price. Other currencies convert it with the plan's exchange rate unless the dashboard sets a custom amount for that currency. null means no limit other than the largest storable amount, 2,147,483,647 cents.

### PlanUnusedPlanCredits

Variants:

- `PlanUnusedPlanCreditsVariant1`
- `PlanUnusedPlanCreditsVariant2`

Discriminator: `type`

- `"expire"` → `PlanUnusedPlanCreditsVariant1`
- `"roll_over"` → `PlanUnusedPlanCreditsVariant2`

### PlanUnusedPlanCreditsVariant1

- `type` (`String`, required)

### PlanUnusedPlanCreditsVariant2

- `type` (`String`, required)
- `maxPlanCredits` (`Long | null`, required) — The most plan credits a subscription holds after a reset, including the credits that reset grants; credits above it expire. At least the included credits of every price. null means no limit other than the largest storable balance, 2,147,483,647 plan credits.

### PlanVersion

- `id` (`String`, required) — Public plan version ID.
- `label` (`String`, required) — The plan's versions are numbered 1, 2, 3; an experiment's own versions read with its code, such as price-test 2.
- `number` (`Long | null`, required) — The plan's version number. Null for a version that only belongs to an experiment; an experiment version made current takes the next number.
- `experiment` (`PlanVersionExperiment | null`, required) — The experiment this version belongs to, if any.
- `isCurrent` (`Boolean`, required) — Whether new buyers get this version.
- `parentVersionId` (`String | null`, required) — The version this one was created from.
- `subscriptionCount` (`Long`, required) — Active, trialing, past due and paused subscriptions on it.
- `maxPlanCredits` (`Long | null`, required)
- `maxPlanBalance` (`Long | null`, required)
- `prices` (`List<PlanVersionPricesItem>`, required)
- `createdAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanVersionComparison

- `versionId` (`String`, required) — The version the changes start from.
- `againstVersionId` (`String`, required) — The version they end at.
- `changes` (`List<PlanVersionComparisonChangesItem>`, required) — Every term that differs, the plan's first and then each country.
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PlanVersionComparisonChangesItem

- `key` (`String`, required) — Identifies the change; send it to undo just this change.
- `section` (`String`, required) — Where the change is: Price, Trial, a rules section, Add-ons, or a country.
- `country` (`String | null`, required) — ISO country code when the change belongs to one country.
- `label` (`String`, required) — What changed, such as Monthly price.
- `before` (`String | null`, required) — The value before, formatted.
- `after` (`String | null`, required) — The value now, formatted.

### PlanVersionExperiment

- `code` (`String`, required) — The experiment's code, as sold with planCode.
- `version` (`Long`, required) — Its number within the experiment.

### PlanVersionPricesItem

- `id` (`String`, required) — Public plan price ID.
- `billingInterval` (`String`, required)
- `price` (`Long`, required)
- `includedCredits` (`Long | null`, required)
- `includedBalance` (`Long | null`, required)
- `regionalPrices` (`List<PlanVersionPricesItemRegionalPricesItem>`, required)

### PlanVersionPricesItemRegionalPricesItem

- `currency` (`String`, required)
- `price` (`Long`, required)
- `includedBalance` (`Long | null`, required)

### PortalAccess

- `portalUrl` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PrepaidPeriodsCheckout

- `checkoutUrl` (`String`, required)
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
- `deactivatedAddons` (`List<PreviewChangeDeactivatedAddonsItem>`, required) — Active add-ons that the version the change moves the subscription to does not sell. The change deactivates them when it applies.
- `offerApplication` (`PreviewChangeOfferApplication`, optional)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PreviewChangeDeactivatedAddonsItem

- `addonId` (`String`, required)
- `name` (`String`, required)

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
- `firstPurchaseOnly` (`Boolean`, required) — Whether the code only applies to a customer's first purchase: one with no paid invoice above zero and no paid subscription.
- `managedBy` (`ManagedBy`, required) — Integration that manages this record, or null when the merchant does. While an integration manages it, its terms change only in that integration and edits answer 409 managed_by_integration.
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### PromoCodesListResult

- `object` (`String`, required)
- `data` (`List<PromoCode>`, required)
- `hasMore` (`Boolean`, required)
- `nextCursor` (`String`, optional)

### PublishPlanDraftParamsChangesItem

- `subscriptionId` (`String`, required)
- `keepOnVersion` (`Object`, optional) — Leave this subscriber on its version.
- `billingInterval` (`String`, optional)
- `seatLimit` (`Object`, optional) — Lower its seats to the version's limit at renewal.
- `removeAddonIds` (`List<String>`, optional) — Add-ons it stops paying at renewal.

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

### SubscriberNeedingAChange

- `subscriptionId` (`String`, required)
- `moveId` (`String | null`, required) — The move it could not complete, or null for a single change.
- `fromVersionId` (`String`, required) — The version it stays on.
- `toVersionId` (`String`, required) — The version it could not move to.
- `code` (`String`, required) — Why it could not move.
- `message` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

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
- `hasPaymentMethod` (`Boolean`, required) — Whether Commet can charge this subscription on its own at its next charge (the trial end or the renewal). A trial that started without a payment method reports false until the customer adds one for this subscription; a payment method saved for another subscription does not count. A subscription on a free plan reports false.
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `planVersion` (`SubscriptionPlanVersion | null`, required) — The plan version whose terms the subscription has now. It keeps paying and receiving everything from this version until it is moved.
- `offerApplications` (`List<SubscriptionOfferApplication>`, required)
- `pause` (`SubscriptionPause | null`, required)
- `scheduledVersionChange` (`SubscriptionScheduledVersionChange | null`, required) — A move to another version of the plan pending for the next renewal.
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

### SubscriptionAutoTopUp

- `enabled` (`Boolean`, required) — Whether top-ups run automatically: credits bought on a credits plan, balance added on a balance plan. Always false when the plan does not sell credits or has balance top-ups turned off.
- `threshold` (`Long | null`, required) — The available amount at or below which a top-up runs, or null when never configured: credits (plan plus purchased) on a credits plan, minor units of the subscription currency (plan plus purchased balance) on a balance plan.
- `quantity` (`Long | null`, required) — Credits each top-up buys on a credits plan, or null when never configured or on a balance plan.
- `amount` (`Long | null`, required) — Minor units of the subscription currency each top-up adds on a balance plan, charged plus tax, or null when never configured or on a credits plan.
- `maxPerPeriod` (`Long | null`, required) — Maximum top-ups per renewal period, or null when never configured.
- `status` (`String`, required) — active tops up when the available amount reaches the threshold; paused stops after three consecutive failed top-ups, or after one whose charge could not be refunded, until the payment method changes, a credit purchase or balance top-up succeeds or it is saved enabled again; off tops up nothing.
- `topUpsThisPeriod` (`Long`, required) — Top-ups made in the current renewal period.
- `periodResetsAt` (`String | null`, required) — When the top-up count of the period resets, or null before the subscription starts its first period.
- `lastFailure` (`SubscriptionAutoTopUpLastFailure | null`, required) — The last top-up that failed, or null when none has failed.
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### SubscriptionAutoTopUpLastFailure

- `reason` (`String`, required)
- `at` (`String`, required)

### SubscriptionBalance

- `remaining` (`Double`, required) — Balance available in minor units of the subscription currency. Kept for compatibility; equal to `total`.
- `included` (`Double`, required)
- `currency` (`String`, required)
- `plan` (`Double`, required) — Plan balance left this period, in minor units. Spent first and replaced or rolled over at each reset; negative while overage is owed.
- `purchased` (`Double`, required) — Purchased balance in minor units: top-ups and manual adjustments. Spent after the plan balance and kept until the subscription ends.
- `total` (`Double`, required) — Balance available in minor units: `plan` plus `purchased`.

### SubscriptionCancellation

- `scheduledAt` (`String`, required)
- `reason` (`String | null`, required)
- `effectiveAt` (`String`, required)

### SubscriptionCredits

- `remaining` (`Double`, required) — Plan credits left. Kept for compatibility; equal to `plan`.
- `included` (`Double`, required)
- `purchased` (`Double`, required) — Purchased credits: purchases and manual adjustments. Spent after plan credits and kept until the subscription ends.
- `plan` (`Double`, required) — Plan credits left this period. Spent first and replaced or rolled over at each reset; negative while overage is owed.
- `total` (`Double`, required) — Credits available: `plan` plus `purchased`.

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

### SubscriptionPause

Variants:

- `SubscriptionPauseVariant1`
- `SubscriptionPauseVariant2`

Discriminator: `status`

- `"scheduled"` → `SubscriptionPauseVariant1`
- `"active"` → `SubscriptionPauseVariant2`

### SubscriptionPauseVariant1

- `status` (`String`, required)
- `mode` (`String`, required)
- `requestedAt` (`String`, required)
- `effectiveAt` (`String`, required)
- `resumeAt` (`String | null`, required)

### SubscriptionPauseVariant2

- `status` (`String`, required)
- `mode` (`String`, required)
- `requestedAt` (`String`, required)
- `effectiveAt` (`String`, required)
- `resumeAt` (`String | null`, required)

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

### SubscriptionPlanVersion

- `id` (`String`, required) — Public plan version ID.
- `label` (`String`, required) — Main versions are 1, 2, 3; an experiment's versions carry its own code, like price-test 2.

### SubscriptionResume

- `subscriptionId` (`String`, required)
- `invoiceId` (`String | null`, required)
- `status` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### SubscriptionScheduledPlanChange

- `changeType` (`String`, required)
- `newPlanId` (`String | null`, required)
- `newPlanName` (`String | null`, required)
- `newBillingInterval` (`String | null`, required)
- `scheduledFor` (`String`, required)

### SubscriptionScheduledVersionChange

- `planVersionId` (`String`, required)
- `label` (`String`, required)
- `effectiveAt` (`String`, required)

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
- `hasPaymentMethod` (`Boolean`, required) — Whether Commet can charge this subscription on its own at its next charge (the trial end or the renewal). A trial that started without a payment method reports false until the customer adds one for this subscription; a payment method saved for another subscription does not count. A subscription on a free plan reports false.
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `planVersion` (`SubscriptionSummaryPlanVersion | null`, required) — The plan version whose terms the subscription has now. It keeps paying and receiving everything from this version until it is moved.
- `offerApplications` (`List<SubscriptionOfferApplication>`, required)
- `pause` (`SubscriptionSummaryPause | null`, required)
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

### SubscriptionSummaryPause

Variants:

- `SubscriptionSummaryPauseVariant1`
- `SubscriptionSummaryPauseVariant2`

Discriminator: `status`

- `"scheduled"` → `SubscriptionSummaryPauseVariant1`
- `"active"` → `SubscriptionSummaryPauseVariant2`

### SubscriptionSummaryPauseVariant1

- `status` (`String`, required)
- `mode` (`String`, required)
- `requestedAt` (`String`, required)
- `effectiveAt` (`String`, required)
- `resumeAt` (`String | null`, required)

### SubscriptionSummaryPauseVariant2

- `status` (`String`, required)
- `mode` (`String`, required)
- `requestedAt` (`String`, required)
- `effectiveAt` (`String`, required)
- `resumeAt` (`String | null`, required)

### SubscriptionSummaryPlan

- `id` (`String`, required)
- `name` (`String`, required)

### SubscriptionSummaryPlanVersion

- `id` (`String`, required) — Public plan version ID.
- `label` (`String`, required) — Main versions are 1, 2, 3; an experiment's versions carry its own code, like price-test 2.

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

- `paymentContext` (`TransactionPaymentContext | null`, required) — Charge context captured for new payments. Null for historical payments with no captured context.
- `id` (`String`, required)
- `invoiceId` (`String | null`, required)
- `grossAmount` (`Long | null`, required) — Gross amount in USD cents. Null when the provider has not reported an honest USD figure; see presentmentAmount.
- `subtotal` (`Long | null`, required) — Subtotal in USD cents (gross minus tax). Null when grossAmount is null.
- `taxAmount` (`Long | null`, required)
- `presentmentAmount` (`Long | null`, required) — Amount in the charge currency's smallest unit, as presented to the customer. Set for non-USD charges; null when the charge was made in USD.
- `currency` (`String`, required)
- `provider` (`PaymentProvider`, required) — The payment provider the charge was routed to: stripe, commet, or dlocal.
- `paymentMethod` (`PaymentMethod | null`, required) — The method used for this charge: card, oxxo, or mercado_pago. Null when unknown.
- `subPaymentMethod` (`SubPaymentMethod | null`, required) — The source of funds for this charge, when reported by the provider. Null when unavailable or unknown.
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

- `paymentContext` (`TransactionListItemPaymentContext | null`, required) — Charge context captured for new payments. Null for historical payments with no captured context.
- `id` (`String`, required)
- `invoiceId` (`String | null`, required)
- `grossAmount` (`Long | null`, required) — Gross amount in USD cents. Null when the provider has not reported an honest USD figure; see presentmentAmount.
- `subtotal` (`Long | null`, required) — Subtotal in USD cents (gross minus tax). Null when grossAmount is null.
- `taxAmount` (`Long | null`, required)
- `presentmentAmount` (`Long | null`, required) — Amount in the charge currency's smallest unit, as presented to the customer. Set for non-USD charges; null when the charge was made in USD.
- `currency` (`String`, required)
- `provider` (`PaymentProvider`, required) — The payment provider the charge was routed to: stripe, commet, or dlocal.
- `paymentMethod` (`PaymentMethod | null`, required) — The method used for this charge: card, oxxo, or mercado_pago. Null when unknown.
- `subPaymentMethod` (`SubPaymentMethod | null`, required) — The source of funds for this charge, when reported by the provider. Null when unavailable or unknown.
- `status` (`TransactionStatus`, required)
- `customerEmail` (`String | null`, required)
- `customerName` (`String | null`, required)
- `paidAt` (`String | null`, required)
- `createdAt` (`String`, required)
- `updatedAt` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### TransactionListItemPaymentContext

- `reason` (`String`, required) — The original reason for the charge. Recovery never replaces this reason.
- `paymentLinkId` (`String | null`, required) — The public payment link ID, independently of the reason, or null when no payment link originated the charge.
- `recovery` (`TransactionListItemPaymentContextRecovery | null`, required)

### TransactionListItemPaymentContextRecovery

Variants:

- `TransactionListItemPaymentContextRecoveryVariant1`
- `TransactionListItemPaymentContextRecoveryVariant2`

Discriminator: `type`

- `"payment_recovery"` → `TransactionListItemPaymentContextRecoveryVariant1`
- `"dunning_retry"` → `TransactionListItemPaymentContextRecoveryVariant2`

### TransactionListItemPaymentContextRecoveryVariant1

- `type` (`String`, required)

### TransactionListItemPaymentContextRecoveryVariant2

- `type` (`String`, required)
- `attempt` (`Long`, required) — Current retry, starting at 1. The original decline is not a retry.
- `maxAttempts` (`Long`, required) — Total retries applicable to this charge's dunning schedule.

### TransactionPaymentContext

- `reason` (`String`, required) — The original reason for the charge. Recovery never replaces this reason.
- `paymentLinkId` (`String | null`, required) — The public payment link ID, independently of the reason, or null when no payment link originated the charge.
- `recovery` (`TransactionPaymentContextRecovery | null`, required)

### TransactionPaymentContextRecovery

Variants:

- `TransactionPaymentContextRecoveryVariant1`
- `TransactionPaymentContextRecoveryVariant2`

Discriminator: `type`

- `"payment_recovery"` → `TransactionPaymentContextRecoveryVariant1`
- `"dunning_retry"` → `TransactionPaymentContextRecoveryVariant2`

### TransactionPaymentContextRecoveryVariant1

- `type` (`String`, required)

### TransactionPaymentContextRecoveryVariant2

- `type` (`String`, required)
- `attempt` (`Long`, required) — Current retry, starting at 1. The original decline is not a retry.
- `maxAttempts` (`Long`, required) — Total retries applicable to this charge's dunning schedule.

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

Discriminator: `type`

- `"percentage"` → `UpdateOfferParamsPhasesItemVariant1`
- `"amount_off"` → `UpdateOfferParamsPhasesItemVariant2`
- `"fixed_price"` → `UpdateOfferParamsPhasesItemVariant3`

### UpdateOfferParamsPhasesItemVariant1

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, optional) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `percentage` (`Long`, required) — Discount in basis points. 5000 means 50%.

### UpdateOfferParamsPhasesItemVariant2

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, optional) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `amounts` (`List<UpdateOfferParamsPhasesItemVariant2AmountsItem>`, required)

### UpdateOfferParamsPhasesItemVariant2AmountsItem

- `currency` (`String`, required)
- `amount` (`Long`, required) — Amount in the currency's minor unit (for example, cents for USD).

### UpdateOfferParamsPhasesItemVariant3

- `type` (`String`, required)
- `durationCycles` (`Long | null`, required)
- `durationInterval` (`String | null`, optional) — Unit the phase duration is counted in. Only a fixed-price phase may set it, because its amount is declared rather than derived from the plan. Defaults to the plan's own billing interval.
- `prices` (`List<UpdateOfferParamsPhasesItemVariant3PricesItem>`, required)

### UpdateOfferParamsPhasesItemVariant3PricesItem

- `currency` (`String`, required)
- `amount` (`Long`, required) — Amount in the currency's minor unit (for example, cents for USD).

### UpdatePlanDraftParamsCountriesItem

- `country` (`String`, required) — ISO country code.
- `currency` (`String`, required) — The currency the country pays in, USD included.
- `exchangeRate` (`Double | null`, optional) — Local units per USD for prices that follow the USD base. USD defaults to 1.
- `prices` (`List<UpdatePlanDraftParamsCountriesItemPricesItem>`, required)
- `topUpMinimum` (`Long | null`, optional) — Smallest balance top-up in this country, in the currency's minor unit. Null follows the USD minimum at the exchange rate; left out keeps it.
- `maxPlanBalance` (`Long | null`, optional) — Most unused plan balance that rolls over in this country. Null follows the USD cap at the exchange rate; left out keeps it.
- `planBalanceLimit` (`Long | null`, optional) — Most plan balance spent per limit interval in this country. Null follows the USD limit at the exchange rate; left out keeps it.
- `addonPrices` (`List<UpdatePlanDraftParamsCountriesItemAddonPricesItem>`, optional) — What the country pays for each add-on the draft sells. Left out keeps the country's add-on prices; sent, it replaces them, and add-ons not listed follow the USD price.
- `creditPackPrices` (`List<UpdatePlanDraftParamsCountriesItemCreditPackPricesItem>`, optional) — What the country pays for each credit pack the draft sells. Left out keeps the country's pack prices; sent, it replaces them, and packs not listed follow the USD price.

### UpdatePlanDraftParamsCountriesItemAddonPricesItem

Variants:

- `UpdatePlanDraftParamsCountriesItemAddonPricesItemVariant1`
- `UpdatePlanDraftParamsCountriesItemAddonPricesItemVariant2`

### UpdatePlanDraftParamsCountriesItemAddonPricesItemVariant1

- `addonId` (`String`, required)
- `price` (`Long`, required) — The add-on's price set by hand, in the currency's minor unit.

### UpdatePlanDraftParamsCountriesItemAddonPricesItemVariant2

- `addonId` (`String`, required)
- `followBase` (`Object`, required) — Follow the add-on's USD price at the exchange rate.

### UpdatePlanDraftParamsCountriesItemCreditPackPricesItem

Variants:

- `UpdatePlanDraftParamsCountriesItemCreditPackPricesItemVariant1`
- `UpdatePlanDraftParamsCountriesItemCreditPackPricesItemVariant2`

### UpdatePlanDraftParamsCountriesItemCreditPackPricesItemVariant1

- `creditPackId` (`String`, required)
- `price` (`Long`, required) — The pack's price set by hand, in the currency's minor unit.

### UpdatePlanDraftParamsCountriesItemCreditPackPricesItemVariant2

- `creditPackId` (`String`, required)
- `followBase` (`Object`, required) — Follow the pack's USD price at the exchange rate.

### UpdatePlanDraftParamsCountriesItemPricesItem

Variants:

- `UpdatePlanDraftParamsCountriesItemPricesItemVariant1`
- `UpdatePlanDraftParamsCountriesItemPricesItemVariant2`

### UpdatePlanDraftParamsCountriesItemPricesItemVariant1

- `billingInterval` (`String`, required)
- `price` (`Long`, required) — The price set by hand, in the currency's minor unit.
- `includedBalance` (`Long`, optional) — The balance included each period in this country, in the currency's minor unit. Required when the plan's price includes a balance.

### UpdatePlanDraftParamsCountriesItemPricesItemVariant2

- `billingInterval` (`String`, required)
- `followBase` (`Object`, required) — Follow the USD base at the exchange rate.

### UpdatePlanDraftParamsPricesItem

- `billingInterval` (`String`, required)
- `price` (`Long`, required) — USD price in cents.
- `includedCredits` (`Long | null`, optional)
- `includedBalance` (`Long | null`, optional)
- `trialDays` (`Long | null`, optional) — Days of trial on this price. Null removes the trial.
- `trialRequiresPaymentMethod` (`Boolean`, optional)
- `isDefault` (`Boolean`, optional) — Show this interval first at checkout and in pricing tables.

### UpdatePlanDraftParamsRules

- `freeIncludedCredits` (`Long | null`, optional) — Credits a free plan includes each month.
- `freeIncludedBalance` (`Long | null`, optional) — Balance a free plan includes each month, in cents.
- `unusedPlanCredits` (`String`, optional)
- `maxPlanCredits` (`Long | null`, optional)
- `planCreditLimit` (`Long | null`, optional)
- `planCreditLimitInterval` (`String | null`, optional)
- `unusedPlanBalance` (`String`, optional)
- `maxPlanBalance` (`Long | null`, optional)
- `planBalanceLimit` (`Long | null`, optional)
- `planBalanceLimitInterval` (`String | null`, optional)
- `blockOnExhaustion` (`Boolean`, optional)
- `purchasesEnabled` (`Boolean`, optional)
- `creditPurchaseUnitPrice` (`Long | null`, optional)
- `creditPurchaseMinimum` (`Long | null`, optional)
- `topUpMinimum` (`Long | null`, optional)

### UpdatePlanFeatureParamsOverage

- `enabled` (`Boolean`, optional)
- `unitPrice` (`Long`, optional)

### UpdatePlanParamsPlanBalanceLimit

- `amount` (`Long`, required) — The most plan balance a subscription spends in one window, in USD cents. Other currencies convert it with the plan's exchange rate unless the dashboard sets a custom amount for that currency.
- `interval` (`String`, required) — The window length: `day` is 24 hours and `week` is 7 days, starting at the time of day of the subscription's billing anchor.

### UpdatePlanParamsPlanCreditLimit

- `credits` (`Long`, required) — The most plan credits a subscription spends in one window.
- `interval` (`String`, required) — The window length: `day` is 24 hours and `week` is 7 days, starting at the time of day of the subscription's billing anchor.

### UpdatePlanParamsUnusedPlanBalance

Variants:

- `UpdatePlanParamsUnusedPlanBalanceVariant1`
- `UpdatePlanParamsUnusedPlanBalanceVariant2`

Discriminator: `type`

- `"expire"` → `UpdatePlanParamsUnusedPlanBalanceVariant1`
- `"roll_over"` → `UpdatePlanParamsUnusedPlanBalanceVariant2`

### UpdatePlanParamsUnusedPlanBalanceVariant1

- `type` (`String`, required)

### UpdatePlanParamsUnusedPlanBalanceVariant2

- `type` (`String`, required)
- `maxPlanBalance` (`Long | null`, required) — The most plan balance a subscription holds after a reset, in USD cents, including the balance that reset grants; balance above it expires. At least the included balance of every price. Other currencies convert it with the plan's exchange rate unless the dashboard sets a custom amount for that currency. null means no limit other than the largest storable amount, 2,147,483,647 cents.

### UpdatePlanParamsUnusedPlanCredits

Variants:

- `UpdatePlanParamsUnusedPlanCreditsVariant1`
- `UpdatePlanParamsUnusedPlanCreditsVariant2`

Discriminator: `type`

- `"expire"` → `UpdatePlanParamsUnusedPlanCreditsVariant1`
- `"roll_over"` → `UpdatePlanParamsUnusedPlanCreditsVariant2`

### UpdatePlanParamsUnusedPlanCreditsVariant1

- `type` (`String`, required)

### UpdatePlanParamsUnusedPlanCreditsVariant2

- `type` (`String`, required)
- `maxPlanCredits` (`Long | null`, required) — The most plan credits a subscription holds after a reset, including the credits that reset grants; credits above it expire. At least the included credits of every price. null means no limit other than the largest storable balance, 2,147,483,647 plan credits.

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
- `planCreditLimit` (`UsageCheckVariant2PlanCreditLimit | null`, required)
- `blockOnExhaustion` (`Boolean`, required) — Whether usage stops when plan and purchased credits run out. False only when the plan allows overage, which is billed at its price per credit; trials and free plans always stop.
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### UsageCheckVariant2PlanCreditLimit

- `credits` (`Long`, required) — The most plan credits the subscription spends per window.
- `interval` (`String`, required) — The window length: 24 hours for `day`, 7 days for `week`.
- `spent` (`Long`, required) — Plan credits spent in the current window.
- `remaining` (`Long`, required) — Plan credits the subscription can still spend in the current window. Purchased credits are not limited.
- `resetsAt` (`String`, required) — When the next window starts and spending resets.

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
- `currentBalance` (`Double`, required) — The available balance, plan plus purchased, in rate scale (10000 = 1.00 of the subscription currency). Equal to totalBalance.
- `planBalance` (`Double`, required) — The plan part of the balance in rate scale. Consumed first, replaced or rolled over at each reset, and negative while overage is owed.
- `purchasedBalance` (`Double`, required) — The purchased part of the balance in rate scale: top-ups and adjustments. Consumed after the plan part and kept until the subscription ends.
- `totalBalance` (`Double`, required) — planBalance plus purchasedBalance, in rate scale.
- `planBalanceLimit` (`UsageCheckVariant3PlanBalanceLimit | null`, required)
- `blockOnExhaustion` (`Boolean`, required)
- `currency` (`String`, required)
- `object` (`String`, required)
- `livemode` (`Boolean`, required)

### UsageCheckVariant3PlanBalanceLimit

- `amount` (`Long`, required) — The most plan balance the subscription spends per window, in rate scale (10000 = 1.00 of the subscription currency).
- `interval` (`String`, required) — The window length: 24 hours for `day`, 7 days for `week`.
- `spent` (`Long`, required) — Plan balance spent in the current window, in rate scale.
- `remaining` (`Long`, required) — Plan balance the subscription can still spend in the current window, in rate scale. Purchased balance is not limited.
- `resetsAt` (`String`, required) — When the next window starts and spending resets.

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
- `planCreditLimit` (`UsageEventConsumptionPlanCreditLimit | null`, optional) — Credits consumption only, omitted for balance. The plan credit limit after this event; null when the plan has no limit.
- `planBalanceLimit` (`UsageEventConsumptionPlanBalanceLimit | null`, optional) — Balance consumption on a plan with a plan balance limit: the limit after this event. Omitted for credits and for plans without a limit.

### UsageEventConsumptionPlanBalanceLimit

- `amount` (`Long`, required) — The most plan balance the subscription spends per window, in rate scale (10000 = 1.00 of the subscription currency).
- `interval` (`String`, required) — The window length: 24 hours for `day`, 7 days for `week`.
- `spent` (`Long`, required) — Plan balance spent in the current window, in rate scale.
- `remaining` (`Long`, required) — Plan balance the subscription can still spend in the current window, in rate scale. Purchased balance is not limited.
- `resetsAt` (`String`, required) — When the next window starts and spending resets.

### UsageEventConsumptionPlanCreditLimit

- `credits` (`Long`, required) — The most plan credits the subscription spends per window.
- `interval` (`String`, required) — The window length: 24 hours for `day`, 7 days for `week`.
- `spent` (`Long`, required) — Plan credits spent in the current window.
- `remaining` (`Long`, required) — Plan credits the subscription can still spend in the current window. Purchased credits are not limited.
- `resetsAt` (`String`, required) — When the next window starts and spending resets.

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

- `currentBalance` (`Double`, required) — The available balance, plan plus purchased, in rate scale. Equal to totalBalance.
- `planBalance` (`Double`, required) — The plan part in rate scale: spent first, replaced or rolled over at each reset, negative while overage is owed.
- `purchasedBalance` (`Double`, required) — The purchased part in rate scale: top-ups and manual adjustments, spent after the plan part and kept until the subscription ends.
- `totalBalance` (`Double`, required) — planBalance plus purchasedBalance, in rate scale.

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
