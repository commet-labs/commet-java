package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanGroup(
        @JsonProperty("id") String id,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("is_public") boolean isPublic,
        @JsonProperty("plans") List<PlanGroupPlan> plans,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record PlanGroupPlan(
            @JsonProperty("id") String id,
            @JsonProperty("code") String code,
            @JsonProperty("name") String name,
            @JsonProperty("sort_order") int sortOrder
    ) {}
}
