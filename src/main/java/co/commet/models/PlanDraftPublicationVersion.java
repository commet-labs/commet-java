package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanDraftPublicationVersion(
        @JsonProperty("id") String id,
        @JsonProperty("label") String label,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("number") Long number,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("experiment") PlanDraftPublicationVersionExperiment experiment,
        @JsonProperty("is_current") boolean isCurrent,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("parent_version_id") String parentVersionId,
        @JsonProperty("subscription_count") long subscriptionCount,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("max_plan_credits") Long maxPlanCredits,
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonProperty("max_plan_balance") Long maxPlanBalance,
        @JsonProperty("prices") List<PlanDraftPublicationVersionPricesItem> prices,
        @JsonProperty("created_at") String createdAt
) {}
