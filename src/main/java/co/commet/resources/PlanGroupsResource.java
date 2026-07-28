package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.AddedPlanToGroup;
import co.commet.models.DeletedObject;
import co.commet.models.PlanGroup;
import co.commet.models.PlanGroupDetail;
import co.commet.models.PlanGroupsListResult;
import co.commet.models.RemovedPlanFromGroup;
import co.commet.models.ReorderedPlans;
import co.commet.params.AddPlanToGroupParams;
import co.commet.params.CreatePlanGroupParams;
import co.commet.params.ListPlanGroupsParams;
import co.commet.params.ReorderPlansInGroupParams;
import co.commet.params.UpdatePlanGroupParams;
import com.fasterxml.jackson.core.type.TypeReference;

import static co.commet.CommetHttpClient.buildBody;

public class PlanGroupsResource {

    private final CommetHttpClient http;

    public PlanGroupsResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Remove a plan from a plan group.
     */
    public RemovedPlanFromGroup removePlan(String id, String planId) {
        return http.delete("/plan-groups/" + id + "/plans/" + planId, null, new TypeReference<RemovedPlanFromGroup>() {}).getData();
    }

    /**
     * Set the display order of plans within a group. All plan IDs in the group must be provided.
     */
    public ReorderedPlans reorderPlans(String id, ReorderPlansInGroupParams params) {
        return http.put("/plan-groups/" + id + "/plans/reorder", buildBody(
                "plan_ids", params.getPlanIds()
        ), params.getIdempotencyKey(), new TypeReference<ReorderedPlans>() {}).getData();
    }

    /**
     * Add an existing plan to a plan group with optional sort order.
     */
    public AddedPlanToGroup addPlan(String id, AddPlanToGroupParams params) {
        return http.post("/plan-groups/" + id + "/plans", buildBody(
                "plan_id", params.getPlanId(),
                "sort_order", params.getSortOrder()
        ), params.getIdempotencyKey(), new TypeReference<AddedPlanToGroup>() {}).getData();
    }

    /**
     * Retrieve a plan group by ID, including its plans ordered by sortOrder.
     */
    public PlanGroupDetail get(String id) {
        return http.get("/plan-groups/" + id, new TypeReference<PlanGroupDetail>() {}).getData();
    }

    /**
     * Update a plan group's name, description, or visibility.
     */
    public PlanGroup update(String id, UpdatePlanGroupParams params) {
        return http.patch("/plan-groups/" + id, buildBody(
                "name", params.getName(),
                "description", params.getDescription(),
                "is_public", params.getIsPublic()
        ), params.getIdempotencyKey(), new TypeReference<PlanGroup>() {}).getData();
    }

    /**
     * Delete a plan group. Plans in the group are unlinked, not deleted.
     */
    public DeletedObject delete(String id) {
        return http.delete("/plan-groups/" + id, null, new TypeReference<DeletedObject>() {}).getData();
    }

    /**
     * List plan groups with cursor-based pagination.
     */
    public PlanGroupsListResult list(ListPlanGroupsParams params) {
        return http.get("/plan-groups", buildBody(
                "cursor", params.getCursor(),
                "limit", params.getLimit()
        ), new TypeReference<PlanGroupsListResult>() {}).getData();
    }

    /**
     * Create a new plan group for organizing plans.
     */
    public PlanGroup create(CreatePlanGroupParams params) {
        return http.post("/plan-groups", buildBody(
                "name", params.getName(),
                "description", params.getDescription(),
                "is_public", params.getIsPublic()
        ), params.getIdempotencyKey(), new TypeReference<PlanGroup>() {}).getData();
    }
}
