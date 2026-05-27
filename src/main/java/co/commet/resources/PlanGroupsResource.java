package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.PlanGroup;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class PlanGroupsResource {

    private final CommetHttpClient http;

    public PlanGroupsResource(CommetHttpClient http) {
        this.http = http;
    }

    public ApiResponse<List<PlanGroup>> list() {
        return list(null, null);
    }

    public ApiResponse<List<PlanGroup>> list(Integer limit, String cursor) {
        return http.get("/plan-groups", buildBody(
                "limit", limit,
                "cursor", cursor
        ), new TypeReference<>() {});
    }

    public ApiResponse<PlanGroup> get(String id) {
        return http.get("/plan-groups/" + id, new TypeReference<>() {});
    }

    public ApiResponse<PlanGroup> create(String name) {
        return create(name, null, null);
    }

    public ApiResponse<PlanGroup> create(String name, String description, Boolean isPublic) {
        return http.post("/plan-groups", buildBody(
                "name", name,
                "description", description,
                "is_public", isPublic
        ), new TypeReference<>() {});
    }

    public ApiResponse<PlanGroup> update(String id, String name, String description, Boolean isPublic) {
        return http.put("/plan-groups/" + id, buildBody(
                "name", name,
                "description", description,
                "is_public", isPublic
        ), new TypeReference<>() {});
    }

    public ApiResponse<Void> delete(String id) {
        return http.delete("/plan-groups/" + id, null, new TypeReference<>() {});
    }

    public ApiResponse<PlanGroup> addPlan(String id, String planId) {
        return addPlan(id, planId, null);
    }

    public ApiResponse<PlanGroup> addPlan(String id, String planId, Integer sortOrder) {
        return http.post("/plan-groups/" + id + "/plans", buildBody(
                "plan_id", planId,
                "sort_order", sortOrder
        ), new TypeReference<>() {});
    }

    public ApiResponse<Void> removePlan(String id, String planId) {
        return http.delete("/plan-groups/" + id + "/plans/" + planId, null, new TypeReference<>() {});
    }

    public ApiResponse<PlanGroup> reorderPlans(String id, List<String> planIds) {
        return http.put("/plan-groups/" + id + "/plans/reorder", buildBody(
                "plan_ids", planIds
        ), new TypeReference<>() {});
    }
}
