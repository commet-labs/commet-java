package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;

import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class SubscriptionsResource {

    private final CommetHttpClient http;

    public SubscriptionsResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse create(String customerId, String planCode) {
        return create(customerId, planCode, null, null, null, null, null, null, null, null);
    }

    public ApiResponse create(String customerId, String planCode,
                              String planId, String billingInterval,
                              Map<String, Integer> initialSeats, Boolean skipTrial,
                              String name, String startDate, String successUrl,
                              String idempotencyKey) {
        return http.post("/subscriptions", buildBody(
                "customer_id", customerId,
                "plan_code", planCode,
                "plan_id", planId,
                "billing_interval", billingInterval,
                "initial_seats", initialSeats,
                "skip_trial", skipTrial,
                "name", name,
                "start_date", startDate,
                "success_url", successUrl
        ), idempotencyKey);
    }

    public ApiResponse get(String customerId) {
        return http.get("/subscriptions/active", Map.of("customer_id", customerId));
    }

    public ApiResponse cancel(String subscriptionId) {
        return cancel(subscriptionId, null, null, null);
    }

    public ApiResponse cancel(String subscriptionId, String reason, Boolean immediate,
                              String idempotencyKey) {
        return http.post("/subscriptions/" + subscriptionId + "/cancel", buildBody(
                "reason", reason,
                "immediate", immediate
        ), idempotencyKey);
    }
}
