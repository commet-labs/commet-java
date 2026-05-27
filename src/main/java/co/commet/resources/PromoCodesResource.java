package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.PromoCode;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class PromoCodesResource {

    private final CommetHttpClient http;

    public PromoCodesResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<List<PromoCode>> list() {
        return list(null, null);
    }

    public ApiResponse<List<PromoCode>> list(Integer limit, String cursor) {
        return http.get("/promo-codes", buildBody(
                "limit", limit,
                "cursor", cursor
        ), new TypeReference<>() {});
    }

    public ApiResponse<PromoCode> get(String id) {
        return http.get("/promo-codes/" + id, new TypeReference<>() {});
    }

    public ApiResponse<PromoCode> create(String code, String discountType, long discountValue) {
        return create(code, discountType, discountValue, null, null, null, null);
    }

    public ApiResponse<PromoCode> create(String code, String discountType, long discountValue,
                                         Integer durationCycles, Integer maxRedemptions,
                                         String expiresAt, List<String> planIds) {
        return http.post("/promo-codes", buildBody(
                "code", code,
                "discount_type", discountType,
                "discount_value", discountValue,
                "duration_cycles", durationCycles,
                "max_redemptions", maxRedemptions,
                "expires_at", expiresAt,
                "plan_ids", planIds
        ), new TypeReference<>() {});
    }

    public ApiResponse<PromoCode> update(String id, Integer maxRedemptions, String expiresAt,
                                         Boolean active, List<String> planIds) {
        return http.put("/promo-codes/" + id, buildBody(
                "max_redemptions", maxRedemptions,
                "expires_at", expiresAt,
                "active", active,
                "plan_ids", planIds
        ), new TypeReference<>() {});
    }
}
