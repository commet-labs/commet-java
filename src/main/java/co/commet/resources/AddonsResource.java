package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Addon;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

public class AddonsResource {

    private final CommetHttpClient http;

    public AddonsResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<List<Addon>> getActive(String customerId) {
        return http.get("/addons/active", Map.of("customer_id", customerId),
                new TypeReference<>() {});
    }
}
