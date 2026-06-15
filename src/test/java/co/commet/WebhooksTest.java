package co.commet;

import co.commet.models.CustomerCreatedData;
import co.commet.models.WebhookEventType;
import co.commet.resources.Webhooks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class WebhooksTest {

    private Webhooks webhooks;
    private static final String SECRET = "whsec_test_secret_key_12345";

    @BeforeEach
    void setUp() {
        webhooks = new Webhooks();
    }

    @Test
    void validSignaturePasses() {
        String payload = "{\"event\":\"subscription.created\",\"data\":{\"id\":\"sub_123\"}}";
        String signature = computeHmac(payload, SECRET);

        assertTrue(webhooks.verify(payload, signature, SECRET));
    }

    @Test
    void validSignatureReturnsTypedEventOnVerifyAndParse() {
        String payload = "{\"event\":\"subscription.created\",\"timestamp\":\"2026-01-01T00:00:00Z\","
                + "\"organizationId\":\"org_1\",\"mode\":\"live\",\"apiVersion\":\"2025-01-01\","
                + "\"data\":{\"subscriptionId\":\"sub_123\"}}";
        String signature = computeHmac(payload, SECRET);

        WebhookEvent event = webhooks.verifyAndParse(payload, signature, SECRET);

        assertNotNull(event);
        assertEquals(WebhookEventType.SUBSCRIPTION_CREATED, event.event());
        assertEquals("org_1", event.organizationId());
    }

    @Test
    void verifyAndParseNarrowsToTypedPayloadRecord() {
        String payload = "{\"event\":\"customer.created\",\"timestamp\":\"2026-01-01T00:00:00Z\","
                + "\"organizationId\":\"org_1\",\"mode\":\"live\",\"apiVersion\":\"2025-01-01\","
                + "\"data\":{\"id\":\"cus_123\",\"email\":\"ada@example.com\","
                + "\"createdAt\":\"2026-01-01T00:00:00Z\",\"updatedAt\":\"2026-01-01T00:00:00Z\"}}";
        String signature = computeHmac(payload, SECRET);

        WebhookEvent event = webhooks.verifyAndParse(payload, signature, SECRET);

        assertNotNull(event);
        assertEquals(WebhookEventType.CUSTOMER_CREATED, event.event());

        CustomerCreatedData data = event.asCustomerCreated();
        assertEquals("cus_123", data.id());
        assertEquals("ada@example.com", data.email());
    }

    @Test
    void invalidSignatureFails() {
        String payload = "{\"event\":\"subscription.created\",\"data\":{\"id\":\"sub_123\"}}";
        String wrongSignature = "deadbeef0000111122223333444455556666777788889999aaaabbbbccccddddeee";

        assertFalse(webhooks.verify(payload, wrongSignature, SECRET));
    }

    @Test
    void invalidSignatureReturnsNullOnVerifyAndParse() {
        String payload = "{\"event\":\"subscription.created\"}";
        String wrongSignature = "invalid_signature";

        assertNull(webhooks.verifyAndParse(payload, wrongSignature, SECRET));
    }

    @Test
    void tamperedPayloadDetected() {
        String originalPayload = "{\"event\":\"subscription.created\",\"data\":{\"id\":\"sub_123\"}}";
        String signature = computeHmac(originalPayload, SECRET);

        String tamperedPayload = "{\"event\":\"subscription.created\",\"data\":{\"id\":\"sub_999\"}}";

        assertFalse(webhooks.verify(tamperedPayload, signature, SECRET));
    }

    @Test
    void wrongSecretFails() {
        String payload = "{\"event\":\"invoice.paid\",\"data\":{\"amount\":100}}";
        String signature = computeHmac(payload, SECRET);

        assertFalse(webhooks.verify(payload, signature, "wrong_secret"));
    }

    @Test
    void nullInputsReturnFalse() {
        assertFalse(webhooks.verify(null, "sig", SECRET));
        assertFalse(webhooks.verify("payload", null, SECRET));
        assertFalse(webhooks.verify("payload", "sig", null));
    }

    @Test
    void emptyInputsReturnFalse() {
        assertFalse(webhooks.verify("", "sig", SECRET));
        assertFalse(webhooks.verify("payload", "", SECRET));
        assertFalse(webhooks.verify("payload", "sig", ""));
    }

    private static String computeHmac(String payload, String secret) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] hash = mac.doFinal(payload.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(hash.length * 2);
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
