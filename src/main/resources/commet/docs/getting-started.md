# Getting started

Install the SDK:

```bash
implementation("co.commet:commet-java:9.3.0")
```

Create one server-side client. Never expose an API key to browser code.

```java
Commet commet = Commet.builder()
    .apiKey("ck_xxx")
    .build();
```

Every resource and method in this release is generated from the versioned OpenAPI contract. Use the installed API reference instead of relying on remembered method names.
