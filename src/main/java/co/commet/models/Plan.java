package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Plan(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("code") String code,
        @JsonProperty("description") String description,
        @JsonProperty("consumption_model") ConsumptionModel consumptionModel,
        @JsonProperty("is_public") boolean isPublic,
        @JsonProperty("is_default") boolean isDefault,
        @JsonProperty("is_free") boolean isFree,
        @JsonProperty("block_on_exhaustion") Boolean blockOnExhaustion,
        @JsonProperty("sort_order") long sortOrder,
        @JsonProperty("plan_group_id") String planGroupId,
        @JsonProperty("metadata") Map<String, Object> metadata,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("features") List<PlanFeaturesItem> features,
        @JsonProperty("prices") List<PlanPricesItem> prices,
        @JsonProperty("exchange_rates") List<PlanExchangeRatesItem> exchangeRates,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
