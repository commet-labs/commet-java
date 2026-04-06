package co.commet.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class Webhooks {

    private static final String HMAC_SHA256 = "HmacSHA256";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public boolean verify(String payload, String signature, String secret) {
        if (payload == null || payload.isEmpty()
                || signature == null || signature.isEmpty()
                || secret == null || secret.isEmpty()) {
            return false;
        }

        String expected = sign(payload, secret);
        return constantTimeEquals(signature, expected);
    }

    public Map<String, Object> verifyAndParse(String rawBody, String signature, String secret) {
        if (!verify(rawBody, signature, secret)) {
            return null;
        }

        try {
            return objectMapper.readValue(rawBody, new TypeReference<>() {});
        } catch (Exception e) {
            return null;
        }
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
