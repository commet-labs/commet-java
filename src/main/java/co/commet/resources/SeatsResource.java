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

    private static String resolveCode(String featureCode, String seatType) {
        if (featureCode != null && !featureCode.isEmpty()) {
            return featureCode;
        }
        return seatType;
    }

    // --- add ---

    public ApiResponse<SeatEvent> add(String featureCode, int count) {
        return add(featureCode, count, null, null);
    }

    public ApiResponse<SeatEvent> add(String featureCode, int count, String customerId,
                           String idempotencyKey) {
        return http.post("/seats", buildBody(
                "seat_type", featureCode,
                "count", count,
                "customer_id", customerId
        ), idempotencyKey, new TypeReference<>() {});
    }

    /** @deprecated Use {@link #add(String, int)} with featureCode instead. */
    @Deprecated
    public ApiResponse<SeatEvent> addBySeatType(String seatType, int count) {
        return add(seatType, count, null, null);
    }

    /** @deprecated Use {@link #add(String, int, String, String)} with featureCode instead. */
    @Deprecated
    public ApiResponse<SeatEvent> addBySeatType(String seatType, int count, String customerId,
                           String idempotencyKey) {
        return add(seatType, count, customerId, idempotencyKey);
    }

    // --- remove ---

    public ApiResponse<SeatEvent> remove(String featureCode, int count) {
        return remove(featureCode, count, null, null);
    }

    public ApiResponse<SeatEvent> remove(String featureCode, int count, String customerId,
                              String idempotencyKey) {
        return http.delete("/seats", buildBody(
                "seat_type", featureCode,
                "count", count,
                "customer_id", customerId
        ), idempotencyKey, new TypeReference<>() {});
    }

    /** @deprecated Use {@link #remove(String, int)} with featureCode instead. */
    @Deprecated
    public ApiResponse<SeatEvent> removeBySeatType(String seatType, int count) {
        return remove(seatType, count, null, null);
    }

    /** @deprecated Use {@link #remove(String, int, String, String)} with featureCode instead. */
    @Deprecated
    public ApiResponse<SeatEvent> removeBySeatType(String seatType, int count, String customerId,
                              String idempotencyKey) {
        return remove(seatType, count, customerId, idempotencyKey);
    }

    // --- set ---

    public ApiResponse<SeatEvent> set(String featureCode, int count) {
        return set(featureCode, count, null, null);
    }

    public ApiResponse<SeatEvent> set(String featureCode, int count, String customerId,
                           String idempotencyKey) {
        return http.put("/seats", buildBody(
                "seat_type", featureCode,
                "count", count,
                "customer_id", customerId
        ), idempotencyKey, new TypeReference<>() {});
    }

    /** @deprecated Use {@link #set(String, int)} with featureCode instead. */
    @Deprecated
    public ApiResponse<SeatEvent> setBySeatType(String seatType, int count) {
        return set(seatType, count, null, null);
    }

    /** @deprecated Use {@link #set(String, int, String, String)} with featureCode instead. */
    @Deprecated
    public ApiResponse<SeatEvent> setBySeatType(String seatType, int count, String customerId,
                           String idempotencyKey) {
        return set(seatType, count, customerId, idempotencyKey);
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
                "seat_type", featureCode,
                "customer_id", customerId
        ), new TypeReference<>() {});
    }

    /** @deprecated Use {@link #getBalance(String)} with featureCode instead. */
    @Deprecated
    public ApiResponse<SeatBalance> getBalanceBySeatType(String seatType) {
        return getBalance(seatType, null);
    }

    /** @deprecated Use {@link #getBalance(String, String)} with featureCode instead. */
    @Deprecated
    public ApiResponse<SeatBalance> getBalanceBySeatType(String seatType, String customerId) {
        return getBalance(seatType, customerId);
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
