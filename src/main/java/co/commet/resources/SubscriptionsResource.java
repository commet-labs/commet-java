package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.Subscription;
import co.commet.params.CancelSubscriptionParams;
import co.commet.params.CreateSubscriptionParams;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class SubscriptionsResource {

    private final CommetHttpClient http;

    public SubscriptionsResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<Subscription> create(String customerId, String planCode) {
        return create(CreateSubscriptionParams.builder(customerId, planCode).build());
    }

    public ApiResponse<Subscription> create(CreateSubscriptionParams params) {
        return http.post("/subscriptions", buildBody(
                "customer_id", params.getCustomerId(),
                "plan_code", params.getPlanCode(),
                "plan_id", params.getPlanId(),
                "billing_interval", params.getBillingInterval(),
                "initial_seats", params.getInitialSeats(),
                "skip_trial", params.getSkipTrial(),
                "name", params.getName(),
                "start_date", params.getStartDate(),
                "success_url", params.getSuccessUrl()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }

    public ApiResponse<Subscription> get(String customerId) {
        return http.get("/subscriptions/active", Map.of("customer_id", customerId),
                new TypeReference<>() {});
    }

    public ApiResponse<Subscription> cancel(String subscriptionId) {
        return cancel(CancelSubscriptionParams.builder(subscriptionId).build());
    }

    public ApiResponse<Subscription> cancel(CancelSubscriptionParams params) {
        return http.post("/subscriptions/" + params.getSubscriptionId() + "/cancel", buildBody(
                "reason", params.getReason(),
                "immediate", params.getImmediate()
        ), params.getIdempotencyKey(), new TypeReference<>() {});
    }
}
