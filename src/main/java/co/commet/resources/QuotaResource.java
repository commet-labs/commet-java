package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.QuotaGetAllResult;
import co.commet.models.UsageQuota;
import co.commet.models.UsageQuotaEvent;
import co.commet.params.AddQuotaParams;
import co.commet.params.GetAllQuotaAllowancesParams;
import co.commet.params.GetQuotaAllowanceParams;
import co.commet.params.RemoveQuotaParams;
import co.commet.params.SetQuotaParams;
import com.fasterxml.jackson.core.type.TypeReference;

import static co.commet.CommetHttpClient.buildBody;

public class QuotaResource {

    private final CommetHttpClient http;

    public QuotaResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Get all quota allowances for a customer across every quota feature in their plan.
     */
    public QuotaGetAllResult getAll(GetAllQuotaAllowancesParams params) {
        return http.get("/usage/quota/all", buildBody(
                "customer_id", params.getCustomerId()
        ), new TypeReference<QuotaGetAllResult>() {}).getData();
    }

    /**
     * Remove from a customer's quota allowance for a feature. Defaults to 1 if count is omitted. Returns 400 insufficient_balance if the balance would go negative.
     */
    public UsageQuotaEvent remove(RemoveQuotaParams params) {
        return http.post("/usage/quota/remove", buildBody(
                "feature_code", params.getFeatureCode(),
                "count", params.getCount(),
                "customer_id", params.getCustomerId(),
                "external_id", params.getExternalId()
        ), params.getIdempotencyKey(), new TypeReference<UsageQuotaEvent>() {}).getData();
    }

    /**
     * Get the current quota allowance (used vs included) for a specific feature.
     */
    public UsageQuota get(GetQuotaAllowanceParams params) {
        return http.get("/usage/quota", buildBody(
                "customer_id", params.getCustomerId(),
                "feature_code", params.getFeatureCode()
        ), new TypeReference<UsageQuota>() {}).getData();
    }

    /**
     * Add to a customer's quota allowance for a feature. Defaults to 1 if count is omitted.
     */
    public UsageQuotaEvent add(AddQuotaParams params) {
        return http.post("/usage/quota", buildBody(
                "feature_code", params.getFeatureCode(),
                "count", params.getCount(),
                "customer_id", params.getCustomerId(),
                "external_id", params.getExternalId()
        ), params.getIdempotencyKey(), new TypeReference<UsageQuotaEvent>() {}).getData();
    }

    /**
     * Set a customer's quota allowance for a feature to an exact value.
     */
    public UsageQuotaEvent set(SetQuotaParams params) {
        return http.put("/usage/quota", buildBody(
                "feature_code", params.getFeatureCode(),
                "count", params.getCount(),
                "customer_id", params.getCustomerId(),
                "external_id", params.getExternalId()
        ), params.getIdempotencyKey(), new TypeReference<UsageQuotaEvent>() {}).getData();
    }
}
