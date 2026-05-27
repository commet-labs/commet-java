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
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class CommetHttpClient implements AutoCloseable {

    private static final Logger logger = Logger.getLogger("co.commet");

    private static final String BASE_URL = "https://commet.co";

    public static final String API_VERSION = "2026-05-25";

    private static final int[] RETRYABLE_STATUS_CODES = {408, 429, 500, 502, 503, 504};

    private static final Set<String> BODY_METHODS = Set.of("POST", "PUT", "PATCH");

    private static final MediaType JSON_MEDIA_TYPE = MediaType.get("application/json");
    private static final Pattern UPPER_AFTER_LOWER = Pattern.compile("(.)([A-Z][a-z]+)");
    private static final Pattern LOWER_BEFORE_UPPER = Pattern.compile("([a-z0-9])([A-Z])");
    private static final String VERSION = loadVersion();

    private final OkHttpClient httpClient;
    private final String baseUrl;
    private final String apiKey;
    private final String apiVersion;
    private final int maxRetries;
    private final boolean debug;
    private final ObjectMapper objectMapper;
    private final boolean telemetryEnabled;
    private final String userAgent;
    private final String clientInfoHeader;
    private volatile String lastTelemetryHeader;

    public CommetHttpClient(String apiKey, Duration timeout, int retries) {
        this(apiKey, timeout, retries, true, null, false);
    }

    public CommetHttpClient(String apiKey, Duration timeout, int retries, boolean telemetry) {
        this(apiKey, timeout, retries, telemetry, null, false);
    }

    public CommetHttpClient(String apiKey, Duration timeout, int retries, boolean telemetry,
                            String apiVersion) {
        this(apiKey, timeout, retries, telemetry, apiVersion, false);
    }

    public CommetHttpClient(String apiKey, Duration timeout, int retries, boolean telemetry,
                            String apiVersion, boolean debug) {
        this.apiKey = apiKey;
        this.apiVersion = apiVersion;
        this.baseUrl = BASE_URL + "/api/v1";
        this.maxRetries = retries;
        this.debug = debug;
        this.telemetryEnabled = telemetry;
        this.objectMapper = new ObjectMapper();
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(timeout)
                .readTimeout(timeout)
                .writeTimeout(timeout)
                .build();

        String osName = System.getProperty("os.name", "unknown").toLowerCase().replace(" ", "");
        String osArch = System.getProperty("os.arch", "unknown");
        String javaVersion = System.getProperty("java.version", "unknown");
        String vmName = System.getProperty("java.vm.name", "unknown").toLowerCase();

        this.userAgent = "commet-java/" + VERSION + " java/" + javaVersion + " " + osName + "/" + osArch;

        if (telemetry) {
            String runtime = vmName.contains("graal") ? "graalvm" : "jvm";
            this.clientInfoHeader = String.format(
                "{\"sdk\":\"commet-java\",\"sdk_version\":\"%s\",\"lang\":\"java\",\"lang_version\":\"%s\","
                + "\"platform\":\"%s\",\"arch\":\"%s\",\"runtime\":\"%s\",\"runtime_version\":\"%s\"}",
                VERSION, javaVersion, osName, osArch, runtime, javaVersion
            );
        } else {
            this.clientInfoHeader = null;
        }
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
        return request("GET", endpoint, null, null, null, typeRef);
    }

    public <T> ApiResponse<T> get(String endpoint, Map<String, Object> params, TypeReference<T> typeRef) {
        Map<String, Object> camelParams = convertParamKeys(params);
        return request("GET", endpoint, null, camelParams, null, typeRef);
    }

    public <T> ApiResponse<T> get(String endpoint, Map<String, Object> params, String idempotencyKey,
                                  TypeReference<T> typeRef) {
        Map<String, Object> camelParams = convertParamKeys(params);
        RequestOptions options = idempotencyKey != null
                ? RequestOptions.builder().idempotencyKey(idempotencyKey).build()
                : null;
        return request("GET", endpoint, null, camelParams, options, typeRef);
    }

    public <T> ApiResponse<T> get(String endpoint, Map<String, Object> params, RequestOptions options,
                                  TypeReference<T> typeRef) {
        Map<String, Object> camelParams = convertParamKeys(params);
        return request("GET", endpoint, null, camelParams, options, typeRef);
    }

    public <T> ApiResponse<T> post(String endpoint, Map<String, Object> body, TypeReference<T> typeRef) {
        return request("POST", endpoint, body, null, null, typeRef);
    }

    public <T> ApiResponse<T> post(String endpoint, Map<String, Object> body, String idempotencyKey,
                                   TypeReference<T> typeRef) {
        RequestOptions options = idempotencyKey != null
                ? RequestOptions.builder().idempotencyKey(idempotencyKey).build()
                : null;
        return request("POST", endpoint, body, null, options, typeRef);
    }

    public <T> ApiResponse<T> post(String endpoint, Map<String, Object> body, RequestOptions options,
                                   TypeReference<T> typeRef) {
        return request("POST", endpoint, body, null, options, typeRef);
    }

    public <T> ApiResponse<T> put(String endpoint, Map<String, Object> body, TypeReference<T> typeRef) {
        return request("PUT", endpoint, body, null, null, typeRef);
    }

    public <T> ApiResponse<T> put(String endpoint, Map<String, Object> body, String idempotencyKey,
                                  TypeReference<T> typeRef) {
        RequestOptions options = idempotencyKey != null
                ? RequestOptions.builder().idempotencyKey(idempotencyKey).build()
                : null;
        return request("PUT", endpoint, body, null, options, typeRef);
    }

    public <T> ApiResponse<T> put(String endpoint, Map<String, Object> body, RequestOptions options,
                                  TypeReference<T> typeRef) {
        return request("PUT", endpoint, body, null, options, typeRef);
    }

    public <T> ApiResponse<T> delete(String endpoint, Map<String, Object> body, TypeReference<T> typeRef) {
        return request("DELETE", endpoint, body, null, null, typeRef);
    }

    public <T> ApiResponse<T> delete(String endpoint, Map<String, Object> body, String idempotencyKey,
                                     TypeReference<T> typeRef) {
        RequestOptions options = idempotencyKey != null
                ? RequestOptions.builder().idempotencyKey(idempotencyKey).build()
                : null;
        return request("DELETE", endpoint, body, null, options, typeRef);
    }

    public <T> ApiResponse<T> delete(String endpoint, Map<String, Object> body, RequestOptions options,
                                     TypeReference<T> typeRef) {
        return request("DELETE", endpoint, body, null, options, typeRef);
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
                                       Map<String, Object> params, RequestOptions options,
                                       TypeReference<T> typeRef) {
        if (BODY_METHODS.contains(method)
                && maxRetries > 0
                && (options == null || options.getIdempotencyKey() == null)) {
            options = options != null
                    ? RequestOptions.builder()
                        .apiVersion(options.getApiVersion())
                        .idempotencyKey(generateIdempotencyKey())
                        .timeout(options.getTimeout())
                        .build()
                    : RequestOptions.builder()
                        .idempotencyKey(generateIdempotencyKey())
                        .build();
        }

        Map<String, String> headers = new LinkedHashMap<>();
        if (options != null && options.getIdempotencyKey() != null) {
            headers.put("Idempotency-Key", options.getIdempotencyKey());
        }

        Object jsonBody = body != null ? convertKeys(body, true) : null;

        if (debug) {
            logger.info("[Commet SDK] " + method + " " + baseUrl + endpoint);
            if (jsonBody != null) {
                try {
                    logger.info("[Commet SDK] Request body: " + objectMapper.writeValueAsString(jsonBody));
                } catch (IOException ignored) {
                }
            }
        }

        return execute(method, endpoint, jsonBody, params, headers, options, 1, typeRef);
    }

    @SuppressWarnings("unchecked")
    private <T> ApiResponse<T> execute(String method, String endpoint, Object jsonBody,
                                       Map<String, Object> params, Map<String, String> extraHeaders,
                                       RequestOptions options, int attempt, TypeReference<T> typeRef) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl + endpoint).newBuilder();
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                urlBuilder.addQueryParameter(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }

        Request.Builder requestBuilder = new Request.Builder()
                .url(urlBuilder.build())
                .header("x-api-key", apiKey)
                .header("commet-version", resolveApiVersion(options))
                .header("Content-Type", "application/json")
                .header("User-Agent", userAgent);

        if (telemetryEnabled) {
            requestBuilder.header("commet-client-info", clientInfoHeader);
            String telemetryHeader = lastTelemetryHeader;
            if (telemetryHeader != null) {
                requestBuilder.header("commet-client-telemetry", telemetryHeader);
                lastTelemetryHeader = null;
            }
        }

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
            case "PATCH" -> requestBuilder.patch(requestBody != null ? requestBody : RequestBody.create("", JSON_MEDIA_TYPE));
            case "DELETE" -> {
                if (requestBody != null) {
                    requestBuilder.delete(requestBody);
                } else {
                    requestBuilder.delete();
                }
            }
        }

        OkHttpClient clientForRequest = resolveClientForRequest(options);

        long requestStart = System.currentTimeMillis();
        Response response;
        try {
            response = clientForRequest.newCall(requestBuilder.build()).execute();
        } catch (SocketTimeoutException e) {
            if (attempt <= maxRetries) {
                long delay = retryDelay(attempt);
                if (debug) {
                    logger.info("[Commet SDK] Timeout, retrying in " + delay + "ms (attempt " + attempt + "/" + maxRetries + ")");
                }
                sleep(delay);
                return execute(method, endpoint, jsonBody, params, extraHeaders, options, attempt + 1, typeRef);
            }
            throw new CommetException("Request timed out after " + maxRetries + " retries");
        } catch (IOException e) {
            if (attempt <= maxRetries) {
                long delay = retryDelay(attempt);
                if (debug) {
                    logger.info("[Commet SDK] Network error, retrying in " + delay + "ms (attempt " + attempt + "/" + maxRetries + ")");
                }
                sleep(delay);
                return execute(method, endpoint, jsonBody, params, extraHeaders, options, attempt + 1, typeRef);
            }
            throw new CommetException("Request failed: " + e.getMessage());
        }

        if (debug) {
            logger.info("[Commet SDK] Response status: " + response.code());
        }

        if (isRetryable(response.code()) && attempt <= maxRetries) {
            response.close();
            long delay = retryDelay(attempt);
            if (debug) {
                logger.info("[Commet SDK] Retrying in " + delay + "ms (attempt " + attempt + "/" + maxRetries + ")");
            }
            sleep(delay);
            return execute(method, endpoint, jsonBody, params, extraHeaders, options, attempt + 1, typeRef);
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

            if (telemetryEnabled) {
                long durationMs = System.currentTimeMillis() - requestStart;
                String requestId = response.header("x-request-id");
                if (requestId == null) {
                    requestId = "req_" + System.currentTimeMillis();
                }
                lastTelemetryHeader = String.format(
                    "{\"last_request_metrics\":{\"request_id\":\"%s\",\"duration_ms\":%d}}",
                    requestId, durationMs
                );
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
        Map<String, Object> errorObj = data;
        if (data.get("error") instanceof Map) {
            errorObj = (Map<String, Object>) data.get("error");
        }

        String type = errorObj.get("type") != null ? errorObj.get("type").toString() : "api_error";
        String code = errorObj.get("code") != null ? errorObj.get("code").toString() : "unknown";
        String message = errorObj.get("message") != null
                ? errorObj.get("message").toString()
                : "Request failed with status " + statusCode;
        String param = errorObj.get("param") != null ? errorObj.get("param").toString() : null;
        Object details = errorObj.get("details");
        String docUrl = errorObj.get("doc_url") != null ? errorObj.get("doc_url").toString() : null;

        if ("validation_error".equals(code) && details instanceof List) {
            Map<String, List<String>> errors = new LinkedHashMap<>();
            List<Map<String, Object>> detailList = (List<Map<String, Object>>) details;
            for (Map<String, Object> detail : detailList) {
                String field = detail.getOrDefault("field", "unknown").toString();
                errors.computeIfAbsent(field, k -> new ArrayList<>())
                        .add(detail.getOrDefault("message", "").toString());
            }
            throw new CommetValidationException(message, errors);
        }

        throw new CommetApiException(message, statusCode, code, details, type, param, docUrl);
    }

    private long retryDelay(int attempt) {
        return Math.min((long) (1000 * Math.pow(2, attempt - 1)), 8000);
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CommetException("Retry interrupted");
        }
    }

    private String resolveApiVersion(RequestOptions options) {
        if (options != null && options.getApiVersion() != null) {
            return options.getApiVersion();
        }
        if (apiVersion != null) {
            return apiVersion;
        }
        return API_VERSION;
    }

    private OkHttpClient resolveClientForRequest(RequestOptions options) {
        if (options == null || options.getTimeout() == null) {
            return httpClient;
        }
        return httpClient.newBuilder()
                .connectTimeout(options.getTimeout())
                .readTimeout(options.getTimeout())
                .writeTimeout(options.getTimeout())
                .build();
    }

    private String generateIdempotencyKey() {
        return "commet-java-retry-" + UUID.randomUUID();
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
