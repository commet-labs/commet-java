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

    public ApiResponse<SeatEvent> add(String seatType, int count) {
        return add(seatType, count, null, null);
    }

    public ApiResponse<SeatEvent> add(String seatType, int count, String customerId,
                           String idempotencyKey) {
        return http.post("/seats", buildBody(
                "seat_type", seatType,
                "count", count,
                "customer_id", customerId
        ), idempotencyKey, new TypeReference<>() {});
    }

    public ApiResponse<SeatEvent> remove(String seatType, int count) {
        return remove(seatType, count, null, null);
    }

    public ApiResponse<SeatEvent> remove(String seatType, int count, String customerId,
                              String idempotencyKey) {
        return http.delete("/seats", buildBody(
                "seat_type", seatType,
                "count", count,
                "customer_id", customerId
        ), idempotencyKey, new TypeReference<>() {});
    }

    public ApiResponse<SeatEvent> set(String seatType, int count) {
        return set(seatType, count, null, null);
    }

    public ApiResponse<SeatEvent> set(String seatType, int count, String customerId,
                           String idempotencyKey) {
        return http.put("/seats", buildBody(
                "seat_type", seatType,
                "count", count,
                "customer_id", customerId
        ), idempotencyKey, new TypeReference<>() {});
    }

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

    public ApiResponse<SeatBalance> getBalance(String seatType) {
        return getBalance(seatType, null);
    }

    public ApiResponse<SeatBalance> getBalance(String seatType, String customerId) {
        return http.get("/seats/balance", buildBody(
                "seat_type", seatType,
                "customer_id", customerId
        ), new TypeReference<>() {});
    }

    public ApiResponse<Map<String, SeatBalance>> getAllBalances() {
        return getAllBalances(null);
    }

    public ApiResponse<Map<String, SeatBalance>> getAllBalances(String customerId) {
        return http.get("/seats/balances", buildBody(
                "customer_id", customerId
        ), new TypeReference<>() {});
    }
}
