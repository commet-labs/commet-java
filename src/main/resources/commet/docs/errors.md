# Errors and request IDs

```java
try {
    commet.customers().get("cus_123");
} catch (CommetApiException error) {
    System.out.println(error.getCode());
    System.out.println(error.getRequestId());
    System.out.println(error.getDocUrl());
}
```

API errors expose type, code, message, status, parameter, details, the exact server request ID, and a versioned documentation URL. The installed error reference describes retry behavior. A request ID is absent when Platform did not return one and is never fabricated locally.

Preserve the same idempotency key when retrying an allowed write.
