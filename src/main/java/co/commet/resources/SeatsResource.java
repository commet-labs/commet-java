package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;

import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class SeatsResource {

    private final CommetHttpClient http;

    public SeatsResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse add(String seatType, int count) {
        return add(seatType, count, null, null, null);
    }

    public ApiResponse add(String seatType, int count, String customerId, String externalId,
                           String idempotencyKey) {
        return http.post("/seats", buildBody(
                "seat_type", seatType,
                "count", count,
                "customer_id", customerId,
                "external_id", externalId
        ), idempotencyKey);
    }

    public ApiResponse remove(String seatType, int count) {
        return remove(seatType, count, null, null, null);
    }

    public ApiResponse remove(String seatType, int count, String customerId, String externalId,
                              String idempotencyKey) {
        return http.delete("/seats", buildBody(
                "seat_type", seatType,
                "count", count,
                "customer_id", customerId,
                "external_id", externalId
        ), idempotencyKey);
    }

    public ApiResponse set(String seatType, int count) {
        return set(seatType, count, null, null, null);
    }

    public ApiResponse set(String seatType, int count, String customerId, String externalId,
                           String idempotencyKey) {
        return http.put("/seats", buildBody(
                "seat_type", seatType,
                "count", count,
                "customer_id", customerId,
                "external_id", externalId
        ), idempotencyKey);
    }

    public ApiResponse setAll(Map<String, Integer> seats) {
        return setAll(seats, null, null, null);
    }

    public ApiResponse setAll(Map<String, Integer> seats, String customerId, String externalId,
                              String idempotencyKey) {
        return http.put("/seats/bulk", buildBody(
                "seats", seats,
                "customer_id", customerId,
                "external_id", externalId
        ), idempotencyKey);
    }

    public ApiResponse getBalance(String seatType) {
        return getBalance(seatType, null, null);
    }

    public ApiResponse getBalance(String seatType, String customerId, String externalId) {
        return http.get("/seats/balance", buildBody(
                "seat_type", seatType,
                "customer_id", customerId,
                "external_id", externalId
        ));
    }

    public ApiResponse getAllBalances() {
        return getAllBalances(null, null);
    }

    public ApiResponse getAllBalances(String customerId, String externalId) {
        return http.get("/seats/balances", buildBody(
                "customer_id", customerId,
                "external_id", externalId
        ));
    }
}
