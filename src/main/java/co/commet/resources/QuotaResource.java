package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.QuotaAllowance;
import co.commet.models.QuotaEvent;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

import static co.commet.CommetHttpClient.buildBody;

public class QuotaResource {

    private final CommetHttpClient http;

    public QuotaResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<QuotaEvent> add(String featureCode) {
        return add(featureCode, 1);
    }

    public ApiResponse<QuotaEvent> add(String featureCode, int count) {
        return add(featureCode, count, null, null);
    }

    public ApiResponse<QuotaEvent> add(String featureCode, int count, String customerId,
                           String idempotencyKey) {
        return http.post("/usage/quota", buildBody(
                "feature_code", featureCode,
                "count", count,
                "customer_id", customerId
        ), idempotencyKey, new TypeReference<>() {});
    }

    public ApiResponse<QuotaEvent> set(String featureCode, int count) {
        return set(featureCode, count, null, null);
    }

    public ApiResponse<QuotaEvent> set(String featureCode, int count, String customerId,
                           String idempotencyKey) {
        return http.put("/usage/quota", buildBody(
                "feature_code", featureCode,
                "count", count,
                "customer_id", customerId
        ), idempotencyKey, new TypeReference<>() {});
    }

    public ApiResponse<QuotaEvent> remove(String featureCode) {
        return remove(featureCode, 1);
    }

    public ApiResponse<QuotaEvent> remove(String featureCode, int count) {
        return remove(featureCode, count, null, null);
    }

    public ApiResponse<QuotaEvent> remove(String featureCode, int count, String customerId,
                              String idempotencyKey) {
        return http.delete("/usage/quota", buildBody(
                "feature_code", featureCode,
                "count", count,
                "customer_id", customerId
        ), idempotencyKey, new TypeReference<>() {});
    }

    public ApiResponse<QuotaAllowance> get(String featureCode) {
        return get(featureCode, null);
    }

    public ApiResponse<QuotaAllowance> get(String featureCode, String customerId) {
        return http.get("/usage/quota", buildBody(
                "feature_code", featureCode,
                "customer_id", customerId
        ), new TypeReference<>() {});
    }

    public ApiResponse<List<QuotaAllowance>> getAll() {
        return getAll(null);
    }

    public ApiResponse<List<QuotaAllowance>> getAll(String customerId) {
        return http.get("/usage/quota/all", buildBody(
                "customer_id", customerId
        ), new TypeReference<>() {});
    }
}
