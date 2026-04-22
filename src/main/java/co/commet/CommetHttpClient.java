package co.commet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class CommetHttpClient implements AutoCloseable {

    private static final Logger logger = Logger.getLogger("co.commet");

    private static final String BASE_URL = "https://commet.co";

    private static final int[] RETRYABLE_STATUS_CODES = {408, 429, 500, 502, 503, 504};

    private static final MediaType JSON_MEDIA_TYPE = MediaType.get("application/json");
    private static final Pattern UPPER_AFTER_LOWER = Pattern.compile("(.)([A-Z][a-z]+)");
    private static final Pattern LOWER_BEFORE_UPPER = Pattern.compile("([a-z0-9])([A-Z])");
    private static final String VERSION = loadVersion();

    private final OkHttpClient httpClient;
    private final String baseUrl;
    private final String apiKey;
    private final int maxRetries;
    private final ObjectMapper objectMapper;

    public CommetHttpClient(String apiKey, Duration timeout, int retries) {
        this.apiKey = apiKey;
        this.baseUrl = BASE_URL + "/api";
        this.maxRetries = retries;
        this.objectMapper = new ObjectMapper();
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(timeout)
                .readTimeout(timeout)
                .writeTimeout(timeout)
                .build();
    }

    @Override
    public void close() {
        httpClient.dispatcher().executorService().shutdown();
        httpClient.connectionPool().evictAll();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public <T> ApiResponse<T> get(String endpoint, TypeReference<T> typeRef) {
        return get(endpoint, null, null, typeRef);
    }

    public <T> ApiResponse<T> get(String endpoint, Map<String, Object> params, TypeReference<T> typeRef) {
        return get(endpoint, params, null, typeRef);
    }

    public <T> ApiResponse<T> get(String endpoint, Map<String, Object> params, String idempotencyKey,
                                  TypeReference<T> typeRef) {
        Map<String, Object> camelParams = convertParamKeys(params);
        return request("GET", endpoint, null, camelParams, idempotencyKey, typeRef);
    }

    public <T> ApiResponse<T> post(String endpoint, Map<String, Object> body, TypeReference<T> typeRef) {
        return post(endpoint, body, null, typeRef);
    }

    public <T> ApiResponse<T> post(String endpoint, Map<String, Object> body, String idempotencyKey,
                                   TypeReference<T> typeRef) {
        return request("POST", endpoint, body, null, idempotencyKey, typeRef);
    }

    public <T> ApiResponse<T> put(String endpoint, Map<String, Object> body, TypeReference<T> typeRef) {
        return put(endpoint, body, null, typeRef);
    }

    public <T> ApiResponse<T> put(String endpoint, Map<String, Object> body, String idempotencyKey,
                                  TypeReference<T> typeRef) {
        return request("PUT", endpoint, body, null, idempotencyKey, typeRef);
    }

    public <T> ApiResponse<T> delete(String endpoint, Map<String, Object> body, TypeReference<T> typeRef) {
        return delete(endpoint, body, null, typeRef);
    }

    public <T> ApiResponse<T> delete(String endpoint, Map<String, Object> body, String idempotencyKey,
                                     TypeReference<T> typeRef) {
        return request("DELETE", endpoint, body, null, idempotencyKey, typeRef);
    }

    private Map<String, Object> convertParamKeys(Map<String, Object> params) {
        if (params == null) {
            return null;
        }
        Map<String, Object> camelParams = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                camelParams.put(toCamel(entry.getKey()), entry.getValue());
            }
        }
        return camelParams;
    }

    private <T> ApiResponse<T> request(String method, String endpoint, Map<String, Object> body,
                                       Map<String, Object> params, String idempotencyKey,
                                       TypeReference<T> typeRef) {
        Map<String, String> headers = new LinkedHashMap<>();
        if ("POST".equals(method)) {
            headers.put("Idempotency-Key",
                    idempotencyKey != null ? idempotencyKey : "sdk_" + UUID.randomUUID().toString().replace("-", ""));
        }

        Object jsonBody = body != null ? convertKeys(body, true) : null;

        logger.fine(method + " " + endpoint);

        return execute(method, endpoint, jsonBody, params, headers, 1, typeRef);
    }

    @SuppressWarnings("unchecked")
    private <T> ApiResponse<T> execute(String method, String endpoint, Object jsonBody,
                                       Map<String, Object> params, Map<String, String> extraHeaders,
                                       int attempt, TypeReference<T> typeRef) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl + endpoint).newBuilder();
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                urlBuilder.addQueryParameter(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }

        Request.Builder requestBuilder = new Request.Builder()
                .url(urlBuilder.build())
                .header("x-api-key", apiKey)
                .header("Content-Type", "application/json")
                .header("User-Agent", "commet-java/" + VERSION);

        if (extraHeaders != null) {
            for (Map.Entry<String, String> header : extraHeaders.entrySet()) {
                requestBuilder.header(header.getKey(), header.getValue());
            }
        }

        RequestBody requestBody = null;
        if (jsonBody != null) {
            try {
                requestBody = RequestBody.create(objectMapper.writeValueAsString(jsonBody), JSON_MEDIA_TYPE);
            } catch (IOException e) {
                throw new CommetException("Failed to serialize request body");
            }
        }

        switch (method) {
            case "GET" -> requestBuilder.get();
            case "POST" -> requestBuilder.post(requestBody != null ? requestBody : RequestBody.create("", JSON_MEDIA_TYPE));
            case "PUT" -> requestBuilder.put(requestBody != null ? requestBody : RequestBody.create("", JSON_MEDIA_TYPE));
            case "DELETE" -> {
                if (requestBody != null) {
                    requestBuilder.delete(requestBody);
                } else {
                    requestBuilder.delete();
                }
            }
        }

        Response response;
        try {
            response = httpClient.newCall(requestBuilder.build()).execute();
        } catch (SocketTimeoutException e) {
            if (attempt <= maxRetries) {
                wait(attempt);
                return execute(method, endpoint, jsonBody, params, extraHeaders, attempt + 1, typeRef);
            }
            throw new CommetException("Request timed out after " + maxRetries + " retries");
        } catch (IOException e) {
            throw new CommetException("Request failed: " + e.getMessage());
        }

        logger.fine("Response: " + response.code());

        if (isRetryable(response.code()) && attempt <= maxRetries) {
            response.close();
            wait(attempt);
            return execute(method, endpoint, jsonBody, params, extraHeaders, attempt + 1, typeRef);
        }

        try {
            String responseBody = response.body() != null ? response.body().string() : "";

            Map<String, Object> rawData;
            try {
                rawData = objectMapper.readValue(responseBody, new TypeReference<>() {});
            } catch (Exception e) {
                throw new CommetApiException(
                        "Invalid JSON response: " + response.code(), response.code(), "INVALID_JSON", null);
            }

            if (!response.isSuccessful()) {
                handleError(response.code(), rawData);
            }

            T typedData = null;
            Object dataField = rawData.get("data");
            if (dataField != null && typeRef != null) {
                JavaType javaType = objectMapper.getTypeFactory().constructType(typeRef.getType());
                typedData = objectMapper.convertValue(dataField, javaType);
            }

            return new ApiResponse<>(
                    rawData.containsKey("success") ? (Boolean) rawData.get("success") : true,
                    typedData,
                    (String) rawData.get("code"),
                    (String) rawData.get("message"),
                    (Boolean) rawData.get("has_more"),
                    (String) rawData.get("next_cursor")
            );
        } catch (CommetException e) {
            throw e;
        } catch (IOException e) {
            throw new CommetException("Failed to read response body: " + e.getMessage());
        } finally {
            response.close();
        }
    }

    @SuppressWarnings("unchecked")
    private void handleError(int statusCode, Map<String, Object> data) {
        if ("validation_error".equals(data.get("code")) && data.get("details") instanceof List) {
            Map<String, List<String>> errors = new LinkedHashMap<>();
            List<Map<String, Object>> details = (List<Map<String, Object>>) data.get("details");
            for (Map<String, Object> detail : details) {
                String field = detail.getOrDefault("field", "unknown").toString();
                errors.computeIfAbsent(field, k -> new ArrayList<>())
                        .add(detail.getOrDefault("message", "").toString());
            }
            throw new CommetValidationException(
                    data.getOrDefault("message", "Validation failed").toString(), errors);
        }

        throw new CommetApiException(
                data.getOrDefault("message", "Request failed with status " + statusCode).toString(),
                statusCode,
                data.get("code") != null ? data.get("code").toString() : null,
                data.get("details")
        );
    }

    private void wait(int attempt) {
        long delay = Math.min((long) (1000 * Math.pow(2, attempt - 1)), 8000);
        logger.fine("Retrying in " + delay + "ms (attempt " + attempt + "/" + maxRetries + ")");
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CommetException("Retry interrupted");
        }
    }

    private boolean isRetryable(int statusCode) {
        for (int code : RETRYABLE_STATUS_CODES) {
            if (code == statusCode) return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private Object convertKeys(Object obj, boolean toCamelCase) {
        if (obj instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) obj;
            Map<String, Object> result = new LinkedHashMap<>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = toCamelCase ? toCamel(entry.getKey()) : toSnake(entry.getKey());
                result.put(key, convertKeys(entry.getValue(), toCamelCase));
            }
            return result;
        }
        if (obj instanceof List) {
            List<Object> list = (List<Object>) obj;
            List<Object> result = new ArrayList<>();
            for (Object item : list) {
                result.add(convertKeys(item, toCamelCase));
            }
            return result;
        }
        return obj;
    }

    static String toSnake(String name) {
        String result = UPPER_AFTER_LOWER.matcher(name).replaceAll("$1_$2");
        result = LOWER_BEFORE_UPPER.matcher(result).replaceAll("$1_$2");
        return result.toLowerCase();
    }

    static String toCamel(String name) {
        String[] parts = name.split("_");
        if (parts.length == 1) return name;
        StringBuilder sb = new StringBuilder(parts[0]);
        for (int i = 1; i < parts.length; i++) {
            if (!parts[i].isEmpty()) {
                sb.append(Character.toUpperCase(parts[i].charAt(0)));
                sb.append(parts[i].substring(1));
            }
        }
        return sb.toString();
    }

    private static String loadVersion() {
        try (InputStream input = CommetHttpClient.class.getClassLoader()
                .getResourceAsStream("commet-version.properties")) {
            if (input != null) {
                Properties props = new Properties();
                props.load(input);
                return props.getProperty("version", "unknown");
            }
        } catch (IOException ignored) {
        }
        return "unknown";
    }

    public static Map<String, Object> buildBody(Object... keyValues) {
        Map<String, Object> body = new LinkedHashMap<>();
        for (int i = 0; i < keyValues.length; i += 2) {
            String key = (String) keyValues[i];
            Object value = keyValues[i + 1];
            if (value != null) {
                body.put(key, value);
            }
        }
        return body;
    }
}
