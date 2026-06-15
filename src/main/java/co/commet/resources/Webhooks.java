package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.WebhookEvent;
import co.commet.models.DeleteResult;
import co.commet.models.WebhookEndpoint;
import co.commet.models.WebhookTestResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class Webhooks {

    private static final String HMAC_SHA256 = "HmacSHA256";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final CommetHttpClient http;

    public Webhooks() {
        this.http = null;
    }

    public Webhooks(CommetHttpClient http) {
        this.http = http;
    }

    public boolean verify(String payload, String signature, String secret) {
        if (payload == null || payload.isEmpty()
                || signature == null || signature.isEmpty()
                || secret == null || secret.isEmpty()) {
            return false;
        }

        String expected = sign(payload, secret);
        return constantTimeEquals(signature, expected);
    }

    public WebhookEvent verifyAndParse(String rawBody, String signature, String secret) {
        if (!verify(rawBody, signature, secret)) {
            return null;
        }

        try {
            return objectMapper.readValue(rawBody, WebhookEvent.class);
        } catch (Exception e) {
            return null;
        }
    }

    public ApiResponse<List<WebhookEndpoint>> list() {
        return list(null, null);
    }

    public ApiResponse<List<WebhookEndpoint>> list(Integer limit, String cursor) {
        return http.get("/webhooks", buildBody(
                "limit", limit,
                "cursor", cursor
        ), new TypeReference<>() {});
    }

    public ApiResponse<WebhookEndpoint> create(String url, List<String> events) {
        return create(url, events, null);
    }

    public ApiResponse<WebhookEndpoint> create(String url, List<String> events, String description) {
        return http.post("/webhooks", buildBody(
                "url", url,
                "events", events,
                "description", description
        ), new TypeReference<>() {});
    }

    public ApiResponse<WebhookEndpoint> get(String id) {
        return http.get("/webhooks/" + id, new TypeReference<>() {});
    }

    public ApiResponse<WebhookEndpoint> update(String id, String url, List<String> events,
                                               String description, Boolean isActive, String apiVersion) {
        return http.put("/webhooks/" + id, buildBody(
                "url", url,
                "events", events,
                "description", description,
                "isActive", isActive,
                "apiVersion", apiVersion
        ), new TypeReference<>() {});
    }

    public ApiResponse<DeleteResult> delete(String id) {
        return http.delete("/webhooks/" + id, null, new TypeReference<>() {});
    }

    public ApiResponse<WebhookTestResult> test(String id) {
        return http.post("/webhooks/" + id + "/test", Map.of(), new TypeReference<>() {});
    }

    private String sign(String payload, String secret) {
        try {
            Mac mac = Mac.getInstance(HMAC_SHA256);
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), HMAC_SHA256));
            byte[] hash = mac.doFinal(payload.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("Failed to compute HMAC-SHA256", e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private static boolean constantTimeEquals(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            result |= a.charAt(i) ^ b.charAt(i);
        }
        return result == 0;
    }
}
