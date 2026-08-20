# Portal

API version: `2026-07-31`

## getUrl

`commet.portal().getUrl(...)`

`POST /portal/sessions` · operation `request-portal-access`

Generate a customer portal URL. Exactly one identifier (email or customerId) is required.

### Parameters

- `email` (`String`, optional)
- `returnUrl` (`String`, optional)
- `customerId` (`String`, optional)

### Request options

- `idempotencyKey` (`String`, optional) — Unique key used to safely retry this write for 24 hours without applying it twice.

### Returns

`PortalAccess`
