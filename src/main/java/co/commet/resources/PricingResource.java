package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.DeletedObject;
import co.commet.models.MarketGroup;
import co.commet.models.PricingListMarketGroupsResult;
import co.commet.params.CreateMarketGroupParams;
import co.commet.params.UpdateMarketGroupParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class PricingResource {

    private final CommetHttpClient http;

    public PricingResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Get one reusable pricing market group.
     */
    public MarketGroup getMarketGroup(String id) {
        return http.get("/pricing/market-groups/" + id, new TypeReference<MarketGroup>() {}).getData();
    }

    /**
     * Replace the name, countries, and metadata of a pricing market group.
     */
    public MarketGroup updateMarketGroup(String id, UpdateMarketGroupParams params) {
        return http.patch("/pricing/market-groups/" + id, buildBody(
                "name", params.getName(),
                "country_codes", params.getCountryCodes(),
                "metadata", params.getMetadata()
        ), params.getIdempotencyKey(), new TypeReference<MarketGroup>() {}).getData();
    }

    /**
     * Delete an unused pricing market group. Groups referenced by prices or subscriptions cannot be deleted.
     */
    public DeletedObject deleteMarketGroup(String id) {
        return http.delete("/pricing/market-groups/" + id, null, new TypeReference<DeletedObject>() {}).getData();
    }

    /**
     * List reusable country groups used to resolve market-specific prices independently from currency.
     */
    public PricingListMarketGroupsResult listMarketGroups() {
        return http.get("/pricing/market-groups", new TypeReference<PricingListMarketGroupsResult>() {}).getData();
    }

    /**
     * Create a reusable country group. Countries can belong to only one active group; each price chooses its currency independently.
     */
    public MarketGroup createMarketGroup(CreateMarketGroupParams params) {
        return http.post("/pricing/market-groups", buildBody(
                "name", params.getName(),
                "country_codes", params.getCountryCodes(),
                "metadata", params.getMetadata()
        ), params.getIdempotencyKey(), new TypeReference<MarketGroup>() {}).getData();
    }
}
