# Payouts

API version: `2026-07-31`

## addBankAccount

`commet.payouts().addBankAccount(...)`

`POST /payouts/bank-accounts` · operation `add-payout-bank-account`

Add an additional destination bank account to the organization's existing payout account. Country and currency are resolved from the organization. The full account number is never returned — only `last4`.

### Parameters

- `accountNumber` (`String`, required)
- `accountHolderName` (`String`, required)
- `routingNumber` (`String`, optional)
- `accountType` (`String`, optional)
- `setDefault` (`Boolean`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`PayoutBankAccount`

## request

`commet.payouts().request(...)`

`POST /payouts` · operation `request-payout`

Withdraw available balance to the organization's verified payout account. `amount` is in cents (USD, minimum 1000 = $10). The payout is created in `pending` and settles to `paid` asynchronously as provider webhooks arrive.

### Parameters

- `amount` (`Long`, required)
- `description` (`String`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`Payout`

## completeVerification

`commet.payouts().completeVerification(...)`

`POST /payouts/verification` · operation `complete-payout-verification`

Deprecated. Complete business and identity verification in the Commet dashboard. This endpoint no longer accepts or processes KYC data.

Deprecated.

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`void`
