package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.SeatBalance;
import co.commet.models.SeatEvent;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class SeatsResource {

    private final CommetHttpClient http;

    public SeatsResource(CommetHttpClient http) {
        this.http = http;
    }

    // --- add ---

    public ApiResponse<SeatEvent> add(String featureCode) {
        return add(featureCode, 1);
    }

    public ApiResponse<SeatEvent> add(String featureCode, int count) {
        return add(featureCode, count, null, null);
    }

    public ApiResponse<SeatEvent> add(String featureCode, int count, String customerId,
                           String idempotencyKey) {
        return http.post("/seats", buildBody(
                "feature_code", featureCode,
                "count", count,
                "customer_id", customerId
        ), idempotencyKey, new TypeReference<>() {});
    }

    // --- remove ---

    public ApiResponse<SeatEvent> remove(String featureCode) {
        return remove(featureCode, 1);
    }

    public ApiResponse<SeatEvent> remove(String featureCode, int count) {
        return remove(featureCode, count, null, null);
    }

    public ApiResponse<SeatEvent> remove(String featureCode, int count, String customerId,
                              String idempotencyKey) {
        return http.delete("/seats", buildBody(
                "feature_code", featureCode,
                "count", count,
                "customer_id", customerId
        ), idempotencyKey, new TypeReference<>() {});
    }

    // --- set ---

    public ApiResponse<SeatEvent> set(String featureCode, int count) {
        return set(featureCode, count, null, null);
    }

    public ApiResponse<SeatEvent> set(String featureCode, int count, String customerId,
                           String idempotencyKey) {
        return http.put("/seats", buildBody(
                "feature_code", featureCode,
                "count", count,
                "customer_id", customerId
        ), idempotencyKey, new TypeReference<>() {});
    }

    // --- setAll ---

    public ApiResponse<List<SeatEvent>> setAll(Map<String, Integer> seats) {
        return setAll(seats, null, null);
    }

    public ApiResponse<List<SeatEvent>> setAll(Map<String, Integer> seats, String customerId,
                              String idempotencyKey) {
        return http.put("/seats/bulk", buildBody(
                "seats", seats,
                "customer_id", customerId
        ), idempotencyKey, new TypeReference<>() {});
    }

    // --- getBalance ---

    public ApiResponse<SeatBalance> getBalance(String featureCode) {
        return getBalance(featureCode, null);
    }

    public ApiResponse<SeatBalance> getBalance(String featureCode, String customerId) {
        return http.get("/seats/balance", buildBody(
                "feature_code", featureCode,
                "customer_id", customerId
        ), new TypeReference<>() {});
    }

    // --- getAllBalances ---

    public ApiResponse<Map<String, SeatBalance>> getAllBalances() {
        return getAllBalances(null);
    }

    public ApiResponse<Map<String, SeatBalance>> getAllBalances(String customerId) {
        return http.get("/seats/balances", buildBody(
                "customer_id", customerId
        ), new TypeReference<>() {});
    }
}
