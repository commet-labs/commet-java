# Commet Java SDK

Billing and usage tracking for SaaS applications.

## Installation

### Gradle

```kotlin
implementation("co.commet:commet-java:0.1.0")
```

### Maven

```xml
<dependency>
    <groupId>co.commet</groupId>
    <artifactId>commet-java</artifactId>
    <version>0.1.0</version>
</dependency>
```

## Quick start

```java
import co.commet.Commet;

Commet commet = Commet.builder()
    .apiKey("ck_xxx")
    .build();

// Create a customer
commet.customers().create("user@example.com", "user_123");

// Create a subscription
commet.subscriptions().create("user_123", "pro");

// Track usage
commet.usage().track("api_calls", "user_123");

// Track AI token usage
commet.usage().track("ai_generation", null, "user_123",
    null, "claude-sonnet-4-20250514", 1000, 500,
    null, null, null, null, null);
```

## Customer context

Scope all operations to a customer to avoid repeating `externalId`:

```java
CustomerContext customer = commet.customer("user_123");

customer.usage().track("api_calls");
customer.features().check("custom_branding");
customer.seats().add("editor", 3);
customer.portal().getUrl();
```

## Webhook verification

```java
import co.commet.resources.Webhooks;

Webhooks webhooks = new Webhooks();

Map<String, Object> payload = webhooks.verifyAndParse(
    requestBody,
    request.getHeader("x-commet-signature"),
    "whsec_xxx"
);

if (payload == null) {
    throw new RuntimeException("Invalid webhook signature");
}

if ("subscription.activated".equals(payload.get("event"))) {
    // handle activation
}
```

## AutoCloseable

```java
try (Commet commet = Commet.builder().apiKey("ck_xxx").build()) {
    commet.usage().track("api_calls", "user_123");
}
// HTTP client is automatically closed
```

## License

MIT
