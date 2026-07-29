# Commet Java SDK

Billing and usage tracking for SaaS applications.

## Installation

### Gradle

```kotlin
implementation("co.commet:commet-java:8.0.1")
```

### Maven

```xml
<dependency>
    <groupId>co.commet</groupId>
    <artifactId>commet-java</artifactId>
    <version>8.0.1</version>
</dependency>
```

## Quick start

```java
import co.commet.Commet;
import co.commet.params.CreateCustomerParams;
import co.commet.params.CreateSubscriptionParams;
import co.commet.params.AddQuotaParams;
import co.commet.params.GetAllQuotaAllowancesParams;
import co.commet.params.GetQuotaAllowanceParams;
import co.commet.params.RemoveQuotaParams;
import co.commet.params.SetQuotaParams;
import co.commet.params.TrackUsageParams;

Commet commet = Commet.builder()
    .apiKey("ck_xxx")
    .build();

// Create a customer
var customer = commet.customers().create(
    CreateCustomerParams.builder("user@example.com").build()
);

// Create a subscription
commet.subscriptions().create(
    CreateSubscriptionParams.builder(customer.id()).planCode("pro").build()
);

// Track usage
commet.usage().track(
    TrackUsageParams.builder("api_calls", customer.id())
        .value(1.0)
        .build()
);

// Track AI token usage
commet.usage().track(
    TrackUsageParams.builder("ai_generation", customer.id())
        .model("claude-sonnet-4-20250514")
        .inputTokens(1000L)
        .outputTokens(500L)
        .build()
);
```

## Offers and pricing Markets

SDK v8 exposes reusable Offers, country Market Groups, and selectable `priceId` variants:

```java
import co.commet.models.CreateOfferParamsPhasesItemVariant1;
import co.commet.params.CreateMarketGroupParams;
import co.commet.params.CreateOfferParams;
import java.util.List;

var market = commet.pricing().createMarketGroup(
    CreateMarketGroupParams.builder("Argentina", List.of("AR")).build()
);

var offer = commet.offers().create(
    CreateOfferParams.builder(
        "30-day trial",
        "introductory",
        List.of("pp_monthly"),
        List.of(new CreateOfferParamsPhasesItemVariant1("free_trial", 30L))
    ).build()
);
```

Promo Codes reference Promotional Offers. Omitting `priceId` during subscription creation keeps normal default-price resolution.

## Quota

Add to, set, or remove from a customer's quota balance, and read allowances. `count` defaults to `1` for `add` and `remove`.

```java
commet.quota().add(
    AddQuotaParams.builder("projects").customerId(customer.id()).count(5L).build()
);
commet.quota().set(
    SetQuotaParams.builder("projects", 100).customerId(customer.id()).build()
);
commet.quota().remove(
    RemoveQuotaParams.builder("projects").customerId(customer.id()).count(2L).build()
);
commet.quota().get(
    GetQuotaAllowanceParams.builder(customer.id(), "projects").build()
);
commet.quota().getAll(
    GetAllQuotaAllowancesParams.builder(customer.id()).build()
);
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
    commet.usage().track(
        TrackUsageParams.builder("api_calls", "cus_123")
            .value(1.0)
            .build()
    );
}
// HTTP client is automatically closed
```

## License

MIT
