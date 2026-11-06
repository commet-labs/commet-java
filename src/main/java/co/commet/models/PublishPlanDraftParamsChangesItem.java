package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PublishPlanDraftParamsChangesItem(
        @JsonProperty("subscription_id") String subscriptionId,
        @JsonProperty("keep_on_version") Object keepOnVersion,
        @JsonProperty("billing_interval") String billingInterval,
        @JsonProperty("seat_limit") Object seatLimit,
        @JsonProperty("remove_addon_ids") List<String> removeAddonIds
) {}
