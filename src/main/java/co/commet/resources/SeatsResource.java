package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.BulkSeatUpdate;
import co.commet.models.SeatBalance;
import co.commet.models.SeatBalanceListItem;
import co.commet.models.SeatEvent;
import co.commet.params.AddSeatsParams;
import co.commet.params.BulkSetSeatsParams;
import co.commet.params.GetAllSeatBalancesParams;
import co.commet.params.GetSeatBalanceParams;
import co.commet.params.RemoveSeatsParams;
import co.commet.params.SetSeatsParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

import static co.commet.CommetHttpClient.buildBody;

public class SeatsResource {

    private final CommetHttpClient http;

    public SeatsResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Add seats to a customer's subscription. Prorates charges for the current billing period.
     */
    public ApiResponse<SeatEvent> add(AddSeatsParams params) {
        return http.post("/seats", buildBody(
                "customer_id", params.getCustomerId(),
                "feature_code", params.getFeatureCode(),
                "count", params.getCount()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Set seats to an exact count.
     */
    public ApiResponse<SeatEvent> set(SetSeatsParams params) {
        return http.put("/seats", buildBody(
                "customer_id", params.getCustomerId(),
                "feature_code", params.getFeatureCode(),
                "count", params.getCount()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Remove seats from a customer's subscription. Takes effect at the end of the billing period.
     */
    public ApiResponse<SeatEvent> remove(RemoveSeatsParams params) {
        return http.delete("/seats", buildBody(
                "customer_id", params.getCustomerId(),
                "feature_code", params.getFeatureCode(),
                "count", params.getCount()
        ), new TypeReference<>() {});
    }

    /**
     * Set all seat types at once.
     */
    public ApiResponse<List<BulkSeatUpdate>> setAll(BulkSetSeatsParams params) {
        return http.put("/seats/bulk", buildBody(
                "customer_id", params.getCustomerId(),
                "seats", params.getSeats()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    /**
     * Get current balance for a specific seat type.
     */
    public ApiResponse<SeatBalance> getBalance(GetSeatBalanceParams params) {
        return http.get("/seats/balance", buildBody(
                "customer_id", params.getCustomerId(),
                "feature_code", params.getFeatureCode()
        ), new TypeReference<>() {});
    }

    /**
     * Get the current balance for all seat types in a customer's subscription.
     */
    public ApiResponse<SeatBalanceListItem> getAllBalances(GetAllSeatBalancesParams params) {
        return http.get("/seats/balances", buildBody(
                "customer_id", params.getCustomerId()
        ), new TypeReference<>() {});
    }
}
