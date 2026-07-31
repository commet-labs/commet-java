package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.DeletedObject;
import co.commet.models.Market;
import co.commet.models.MarketsListResult;
import co.commet.params.CreateMarketParams;
import co.commet.params.UpdateMarketParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class MarketsResource {

    private final CommetHttpClient http;

    public MarketsResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Get one reusable market.
     */
    public Market get(String id) {
        return http.get("/markets/" + id, new TypeReference<Market>() {}).getData();
    }

    /**
     * Replace the name, countries, and metadata of a market.
     */
    public Market update(String id, UpdateMarketParams params) {
        return http.patch("/markets/" + id, buildBody(
                "name", params.getName(),
                "country_codes", params.getCountryCodes(),
                "metadata", params.getMetadata()
        ), params.getIdempotencyKey(), new TypeReference<Market>() {}).getData();
    }

    /**
     * Delete an unused market. Markets referenced by prices or subscriptions cannot be deleted.
     */
    public DeletedObject delete(String id) {
        return http.delete("/markets/" + id, null, new TypeReference<DeletedObject>() {}).getData();
    }

    /**
     * List reusable country groups that resolve market-specific prices independently from currency.
     */
    public MarketsListResult list() {
        return http.get("/markets", new TypeReference<MarketsListResult>() {}).getData();
    }

    /**
     * Create a reusable market without attaching it to a plan or price. Countries can belong to only one active market.
     */
    public Market create(CreateMarketParams params) {
        return http.post("/markets", buildBody(
                "name", params.getName(),
                "country_codes", params.getCountryCodes(),
                "metadata", params.getMetadata()
        ), params.getIdempotencyKey(), new TypeReference<Market>() {}).getData();
    }
}
