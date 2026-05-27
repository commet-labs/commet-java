package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SubscriptionListItem(
        @JsonProperty("id") String id,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode,
        @JsonProperty("customer_id") String customerId,
        @JsonProperty("plan_id") String planId,
        @JsonProperty("plan_name") String planName,
        @JsonProperty("name") String name,
        @JsonProperty("status") SubscriptionStatus status,
        @JsonProperty("start_date") String startDate,
        @JsonProperty("end_date") String endDate,
        @JsonProperty("billing_day_of_month") Integer billingDayOfMonth,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt
) {}
