package co.commet.resources;

import co.commet.ApiResponse;
import co.commet.CommetHttpClient;
import co.commet.models.DeletedObject;
import co.commet.models.DeletedPlanRegionalPricing;
import co.commet.models.KeptOnVersion;
import co.commet.models.Plan;
import co.commet.models.PlanDraft;
import co.commet.models.PlanDraftPublication;
import co.commet.models.PlanExperiment;
import co.commet.models.PlanExperimentArchive;
import co.commet.models.PlanFeature;
import co.commet.models.PlanMove;
import co.commet.models.PlanPrice;
import co.commet.models.PlanRegionalPricing;
import co.commet.models.PlanRegionalPricingResult;
import co.commet.models.PlanVersion;
import co.commet.models.PlanVersionComparison;
import co.commet.models.PlansListDraftsResult;
import co.commet.models.PlansListExperimentsResult;
import co.commet.models.PlansListMovesResult;
import co.commet.models.PlansListResult;
import co.commet.models.PlansListSubscribersNeedingAChangeResult;
import co.commet.models.PlansListVersionsResult;
import co.commet.models.RemovedPlanFeature;
import co.commet.params.AddPlanFeatureParams;
import co.commet.params.AddPlanPriceParams;
import co.commet.params.ArchivePlanExperimentParams;
import co.commet.params.CancelPlanMoveParams;
import co.commet.params.CancelPlanMoveSubscriptionParams;
import co.commet.params.ComparePlanVersionsParams;
import co.commet.params.CreatePlanDraftParams;
import co.commet.params.CreatePlanExperimentParams;
import co.commet.params.CreatePlanExperimentVersionParams;
import co.commet.params.CreatePlanMoveParams;
import co.commet.params.CreatePlanParams;
import co.commet.params.CreatePlanVersionParams;
import co.commet.params.KeepPlanSubscriberOnVersionParams;
import co.commet.params.ListPlanVersionsParams;
import co.commet.params.ListPlansParams;
import co.commet.params.MakePlanExperimentCurrentParams;
import co.commet.params.PublishPlanDraftParams;
import co.commet.params.SetDefaultPlanPriceParams;
import co.commet.params.SetPlanRegionalPricingParams;
import co.commet.params.SetPlanVisibilityParams;
import co.commet.params.UpdatePlanDraftParams;
import co.commet.params.UpdatePlanFeatureParams;
import co.commet.params.UpdatePlanParams;
import co.commet.params.UpdatePlanPriceParams;
import co.commet.params.UpsertRegionalPricesParams;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

import static co.commet.CommetHttpClient.buildBody;

public class PlansResource {

    private final CommetHttpClient http;

    public PlansResource(CommetHttpClient http) {
        this.http = http;
    }

    /**
     * Publish a draft as the plan's current version, as a new experiment with its own code, or as the next version of the experiment it started from. A country missing a price, or removing the signup trial of the plan's group from the current version, stops the publication. With move, subscribers of earlier versions move at their renewal or now; if any of them does not fit the new version, nothing is published and the response lists each one with what would make it fit, to send back in changes. Paused subscribers stay where they are. Send preview to check without publishing.
     */
    public PlanDraftPublication publishDraft(String id, String draftId, PublishPlanDraftParams params) {
        return http.post("/plans/" + id + "/drafts/" + draftId + "/publish", buildBody(
                "publish_as", params.getPublishAs(),
                "move", params.getMove(),
                "changes", params.getChanges(),
                "preview", params.getPreview(),
                "experiment_code", params.getExperimentCode()
        ), params.getIdempotencyKey(), new TypeReference<PlanDraftPublication>() {}).getData();
    }

    /**
     * Retrieve a draft with the version it started from and what it changes.
     */
    public PlanDraft getDraft(String id, String draftId) {
        return http.get("/plans/" + id + "/drafts/" + draftId, new TypeReference<PlanDraft>() {}).getData();
    }

    /**
     * Change a draft's prices per interval, trials, the interval shown first, countries with their currency and prices, and credit or balance rules, or undo single changes. Each block sent replaces that block; blocks left out stay as they are. Buyers and subscribers see nothing until the draft is published.
     */
    public PlanDraft updateDraft(String id, String draftId, UpdatePlanDraftParams params) {
        return http.patch("/plans/" + id + "/drafts/" + draftId, buildBody(
                "prices", params.getPrices(),
                "countries", params.getCountries(),
                "rules", params.getRules(),
                "undo", params.getUndo()
        ), params.getIdempotencyKey(), new TypeReference<PlanDraft>() {}).getData();
    }

    /**
     * Discard a draft. Nothing it changed was ever sold.
     */
    public DeletedObject deleteDraft(String id, String draftId) {
        return http.delete("/plans/" + id + "/drafts/" + draftId, null, new TypeReference<DeletedObject>() {}).getData();
    }

    /**
     * List the plan's open drafts, oldest first, each with the version it started from and what it changes. Drafts sell nothing until published.
     */
    public PlansListDraftsResult listDrafts(String id) {
        return http.get("/plans/" + id + "/drafts", new TypeReference<PlansListDraftsResult>() {}).getData();
    }

    /**
     * Start a draft from a version of the plan: the current one, an experiment's version or an older one. A plan can have any number of drafts. Edit it, then publish it as the current version, as an experiment or as an experiment's next version; nothing changes for buyers or subscribers until then.
     */
    public PlanDraft createDraft(String id, CreatePlanDraftParams params) {
        return http.post("/plans/" + id + "/drafts", buildBody(
                "from_version_id", params.getFromVersionId()
        ), params.getIdempotencyKey(), new TypeReference<PlanDraft>() {}).getData();
    }

    /**
     * Stop selling the experiment. Its code sells the plan's current version from then on, so links already shared keep working. Choose what happens to its subscribers: keep them on its versions, or move them to the current version at their renewal or now. If any of them does not fit, nothing changes and the response lists each one with what would make it fit, to send back in changes.
     */
    public PlanExperimentArchive archiveExperiment(String id, String code, ArchivePlanExperimentParams params) {
        return http.post("/plans/" + id + "/experiments/" + code + "/archive", buildBody(
                "subscribers", params.getSubscribers(),
                "changes", params.getChanges(),
                "preview", params.getPreview()
        ), params.getIdempotencyKey(), new TypeReference<PlanExperimentArchive>() {}).getData();
    }

    /**
     * Make the experiment's latest version the plan's current version, with exactly its content and the next version number. New buyers get it; its subscribers are already on it. The experiment closes, and its code sells the plan's current version from then on. Nobody else moves.
     */
    public PlanVersion makeExperimentCurrent(String id, String code, MakePlanExperimentCurrentParams params) {
        return http.post("/plans/" + id + "/experiments/" + code + "/make-current", Map.of(), params.getIdempotencyKey(), new TypeReference<PlanVersion>() {}).getData();
    }

    /**
     * Get one experiment of a plan by its own code, with the version it sells and how many subscriptions are on it.
     */
    public PlanExperiment getExperiment(String id, String code) {
        return http.get("/plans/" + id + "/experiments/" + code, new TypeReference<PlanExperiment>() {}).getData();
    }

    /**
     * Publish the experiment's next version from its latest version with the changes given. Its code sells the new version from now on; subscribers on its earlier versions stay where they are until moved.
     */
    public PlanVersion createExperimentVersion(String id, String code, CreatePlanExperimentVersionParams params) {
        return http.post("/plans/" + id + "/experiments/" + code + "/versions", buildBody(
                "prices", params.getPrices(),
                "currencies", params.getCurrencies(),
                "max_plan_credits", params.getMaxPlanCredits(),
                "max_plan_balance", params.getMaxPlanBalance()
        ), params.getIdempotencyKey(), new TypeReference<PlanVersion>() {}).getData();
    }

    /**
     * List a plan's experiments, newest first, with the version each one sells and how many subscriptions are on them.
     */
    public PlansListExperimentsResult listExperiments(String id) {
        return http.get("/plans/" + id + "/experiments", new TypeReference<PlansListExperimentsResult>() {}).getData();
    }

    /**
     * Start an experiment from the plan's current version with the changes given. It is sold only through its code (planCode `&lt;plan code&gt;:&lt;code&gt;`); new buyers of the plan keep getting the current version.
     */
    public PlanExperiment createExperiment(String id, CreatePlanExperimentParams params) {
        return http.post("/plans/" + id + "/experiments", buildBody(
                "prices", params.getPrices(),
                "currencies", params.getCurrencies(),
                "max_plan_credits", params.getMaxPlanCredits(),
                "max_plan_balance", params.getMaxPlanBalance(),
                "code", params.getCode()
        ), params.getIdempotencyKey(), new TypeReference<PlanExperiment>() {}).getData();
    }

    /**
     * Update limits, overage, or enabled status of a feature on a plan.
     */
    public PlanFeature updateFeature(String id, String featureId, UpdatePlanFeatureParams params) {
        return http.patch("/plans/" + id + "/features/" + featureId, buildBody(
                "enabled", params.getEnabled(),
                "included_amount", params.getIncludedAmount(),
                "unlimited", params.getUnlimited(),
                "overage", params.getOverage(),
                "credits_per_unit", params.getCreditsPerUnit()
        ), params.getIdempotencyKey(), new TypeReference<PlanFeature>() {}).getData();
    }

    /**
     * Detach a feature from a plan.
     */
    public RemovedPlanFeature removeFeature(String id, String featureId) {
        return http.delete("/plans/" + id + "/features/" + featureId, null, new TypeReference<RemovedPlanFeature>() {}).getData();
    }

    /**
     * Attach a feature to a plan with limits, overage, and credits configuration.
     */
    public PlanFeature addFeature(String id, AddPlanFeatureParams params) {
        return http.post("/plans/" + id + "/features", buildBody(
                "feature_id", params.getFeatureId(),
                "enabled", params.getEnabled(),
                "included_amount", params.getIncludedAmount(),
                "unlimited", params.getUnlimited(),
                "overage", params.getOverage(),
                "credits_per_unit", params.getCreditsPerUnit(),
                "pricing_mode", params.getPricingMode(),
                "margin", params.getMargin()
        ), params.getIdempotencyKey(), new TypeReference<PlanFeature>() {}).getData();
    }

    /**
     * Cancel a move for every subscriber who has not moved yet. They stay on their version; those already moved stay moved.
     */
    public PlanMove cancelMove(String id, String moveId, CancelPlanMoveParams params) {
        return http.post("/plans/" + id + "/moves/" + moveId + "/cancel", Map.of(), params.getIdempotencyKey(), new TypeReference<PlanMove>() {}).getData();
    }

    /**
     * Read a move of subscribers between plan versions with each subscriber's status: moving, moved, needs a change, left out, canceled or kept on its version.
     */
    public PlanMove getMove(String id, String moveId) {
        return http.get("/plans/" + id + "/moves/" + moveId, new TypeReference<PlanMove>() {}).getData();
    }

    /**
     * Cancel a move for one subscriber who has not moved yet. It stays on its version; the rest of the move continues.
     */
    public PlanMove cancelMoveSubscription(String id, String moveId, String subscriptionId, CancelPlanMoveSubscriptionParams params) {
        return http.post("/plans/" + id + "/moves/" + moveId + "/subscriptions/" + subscriptionId + "/cancel", Map.of(), params.getIdempotencyKey(), new TypeReference<PlanMove>() {}).getData();
    }

    /**
     * List a plan's latest moves of subscribers between versions, newest first, including the change of a single subscription, with how many are moving, moved, need a change, were left out, canceled or kept on their version.
     */
    public PlansListMovesResult listMoves(String id) {
        return http.get("/plans/" + id + "/moves", new TypeReference<PlansListMovesResult>() {}).getData();
    }

    /**
     * Move a list of subscriptions, or every subscription of another version, to a newer version of the plan, at their next renewal or now. Nobody moves unless every one of them fits or has a change in changes; otherwise the response lists each one with what would make it fit. Only active, trialing and past due subscriptions move. Paused ones, and listed subscriptions in another status or already on the destination, are left out. Send preview to check without moving anyone.
     */
    public PlanMove createMove(String id, CreatePlanMoveParams params) {
        return http.post("/plans/" + id + "/moves", buildBody(
                "subscription_ids", params.getSubscriptionIds(),
                "to_version_id", params.getToVersionId(),
                "effective", params.getEffective(),
                "changes", params.getChanges(),
                "preview", params.getPreview(),
                "from_version_id", params.getFromVersionId()
        ), params.getIdempotencyKey(), new TypeReference<PlanMove>() {}).getData();
    }

    /**
     * Leave a subscriber that needs a change on its version. It stops appearing among the subscribers that need a change; move it later like any other subscriber.
     */
    public KeptOnVersion keepSubscriberOnVersion(String id, String subscriptionId, KeepPlanSubscriberOnVersionParams params) {
        return http.post("/plans/" + id + "/needs-a-change/" + subscriptionId + "/keep", Map.of(), params.getIdempotencyKey(), new TypeReference<KeptOnVersion>() {}).getData();
    }

    /**
     * List the plan's subscribers whose move could not complete, with the version they stay on, the one they could not move to and why. Move them again with a change, or keep them on their version so they leave this list.
     */
    public PlansListSubscribersNeedingAChangeResult listSubscribersNeedingAChange(String id) {
        return http.get("/plans/" + id + "/needs-a-change", new TypeReference<PlansListSubscribersNeedingAChangeResult>() {}).getData();
    }

    /**
     * Set a specific price as the default and return the updated plan price.
     */
    public PlanPrice setDefaultPrice(String id, String priceId, SetDefaultPlanPriceParams params) {
        return http.put("/plans/" + id + "/prices/" + priceId + "/default", Map.of(), params.getIdempotencyKey(), new TypeReference<PlanPrice>() {}).getData();
    }

    /**
     * Create or update regional currency price overrides for a plan price.
     */
    public PlanRegionalPricing setRegionalPrices(String id, String priceId, UpsertRegionalPricesParams params) {
        return http.put("/plans/" + id + "/prices/" + priceId + "/regional", buildBody(
                "overrides", params.getOverrides()
        ), params.getIdempotencyKey(), new TypeReference<PlanRegionalPricing>() {}).getData();
    }

    /**
     * Remove all regional currency overrides for a plan price. The request is rejected while billable subscriptions depend on an override.
     */
    public DeletedPlanRegionalPricing deleteRegionalPrices(String id, String priceId) {
        return http.delete("/plans/" + id + "/prices/" + priceId + "/regional", null, new TypeReference<DeletedPlanRegionalPricing>() {}).getData();
    }

    /**
     * Update a base price or market price variant. Removing a base market override is rejected while a variant depends on it. Offer terms are managed through Offers.
     */
    public PlanPrice updatePrice(String id, String priceId, UpdatePlanPriceParams params) {
        return http.patch("/plans/" + id + "/prices/" + priceId, buildBody(
                "price", params.getPrice(),
                "is_default", params.getIsDefault(),
                "trial_days", params.getTrialDays(),
                "trial_requires_payment_method", params.getTrialRequiresPaymentMethod(),
                "included_balance", params.getIncludedBalance(),
                "included_credits", params.getIncludedCredits(),
                "metadata", params.getMetadata(),
                "market_prices", params.getMarketPrices()
        ), params.getIdempotencyKey(), new TypeReference<PlanPrice>() {}).getData();
    }

    /**
     * Archive a price for new subscriptions. This publishes a new version of the plan; existing subscriptions that selected the price keep paying it on their version until moved.
     */
    public DeletedObject deletePrice(String id, String priceId) {
        return http.delete("/plans/" + id + "/prices/" + priceId, null, new TypeReference<DeletedObject>() {}).getData();
    }

    /**
     * Add a base price or a selectable market price variant. Variants inherit their base price outside the markets they override. Configure introductory and promotional benefits through Offers.
     */
    public PlanPrice addPrice(String id, AddPlanPriceParams params) {
        return http.post("/plans/" + id + "/prices", buildBody(
                "billing_interval", params.getBillingInterval(),
                "metadata", params.getMetadata(),
                "price", params.getPrice(),
                "trial_days", params.getTrialDays(),
                "trial_requires_payment_method", params.getTrialRequiresPaymentMethod(),
                "is_default", params.getIsDefault(),
                "included_balance", params.getIncludedBalance(),
                "included_credits", params.getIncludedCredits(),
                "market_prices", params.getMarketPrices(),
                "inherits_from_price_id", params.getInheritsFromPriceId()
        ), params.getIdempotencyKey(), new TypeReference<PlanPrice>() {}).getData();
    }

    /**
     * Configure regional prices and feature overage values for one currency. Currency-specific offer terms are managed through Offers.
     */
    public PlanRegionalPricingResult setRegionalPricing(String id, SetPlanRegionalPricingParams params) {
        return http.put("/plans/" + id + "/regional", buildBody(
                "currency", params.getCurrency(),
                "exchange_rate", params.getExchangeRate(),
                "prices", params.getPrices(),
                "features", params.getFeatures()
        ), params.getIdempotencyKey(), new TypeReference<PlanRegionalPricingResult>() {}).getData();
    }

    /**
     * Get a plan with public price IDs and their automatic introductory offer IDs.
     */
    public Plan get(String id) {
        return http.get("/plans/" + id, new TypeReference<Plan>() {}).getData();
    }

    /**
     * Update a plan's name, description, visibility, default status, metadata, overage behavior, what happens to its unused plan credits or plan balance, or its plan credit or plan balance limit.
     */
    public Plan update(String id, UpdatePlanParams params) {
        return http.patch("/plans/" + id, buildBody(
                "name", params.getName(),
                "description", params.getDescription(),
                "metadata", params.getMetadata(),
                "is_public", params.getIsPublic(),
                "unused_plan_credits", params.getUnusedPlanCredits(),
                "plan_credit_limit", params.getPlanCreditLimit(),
                "unused_plan_balance", params.getUnusedPlanBalance(),
                "plan_balance_limit", params.getPlanBalanceLimit(),
                "block_on_exhaustion", params.getBlockOnExhaustion(),
                "is_default", params.getIsDefault()
        ), params.getIdempotencyKey(), new TypeReference<Plan>() {}).getData();
    }

    /**
     * Soft-delete a plan.
     */
    public DeletedObject delete(String id) {
        return http.delete("/plans/" + id, null, new TypeReference<DeletedObject>() {}).getData();
    }

    /**
     * List what changes from one version of a plan to another: prices, trials, features, rules, add-ons, credit packs and countries.
     */
    public PlanVersionComparison compareVersions(String id, String versionId, ComparePlanVersionsParams params) {
        return http.get("/plans/" + id + "/versions/" + versionId + "/changes", buildBody(
                "against", params.getAgainst()
        ), new TypeReference<PlanVersionComparison>() {}).getData();
    }

    /**
     * Get one published version of a plan with its prices and how many subscriptions are on it.
     */
    public PlanVersion getVersion(String id, String versionId) {
        return http.get("/plans/" + id + "/versions/" + versionId, new TypeReference<PlanVersion>() {}).getData();
    }

    /**
     * List a plan's published versions, newest first, with their prices and how many subscriptions are on each. Versions published before Commet recorded every term are not listed.
     */
    public PlansListVersionsResult listVersions(String id, ListPlanVersionsParams params) {
        return http.get("/plans/" + id + "/versions", buildBody(
                "cursor", params.getCursor(),
                "limit", params.getLimit()
        ), new TypeReference<PlansListVersionsResult>() {}).getData();
    }

    /**
     * Publish a new current version of the plan from its current version, changing prices per interval, included credits or balance, per-currency amounts and the rollover cap. New buyers get it; every subscriber stays on its version until moved. To try changes without selling them to everyone, create an experiment instead.
     */
    public PlanVersion createVersion(String id, CreatePlanVersionParams params) {
        return http.post("/plans/" + id + "/versions", buildBody(
                "prices", params.getPrices(),
                "currencies", params.getCurrencies(),
                "max_plan_credits", params.getMaxPlanCredits(),
                "max_plan_balance", params.getMaxPlanBalance()
        ), params.getIdempotencyKey(), new TypeReference<PlanVersion>() {}).getData();
    }

    /**
     * Set a plan's public visibility and return the updated plan.
     */
    public Plan setVisibility(String id, SetPlanVisibilityParams params) {
        return http.put("/plans/" + id + "/visibility", buildBody(
                "is_public", params.isIsPublic()
        ), params.getIdempotencyKey(), new TypeReference<Plan>() {}).getData();
    }

    /**
     * List plans with public price IDs and their automatic introductory offer IDs.
     */
    public PlansListResult list(ListPlansParams params) {
        return http.get("/plans", buildBody(
                "include_private", params.getIncludePrivate()
        ), new TypeReference<PlansListResult>() {}).getData();
    }

    /**
     * Create a new plan with optional consumption model, visibility, plan group assignment, overage behavior, and the rollover and spend limit of its plan credits or plan balance.
     */
    public Plan create(CreatePlanParams params) {
        return http.post("/plans", buildBody(
                "name", params.getName(),
                "code", params.getCode(),
                "description", params.getDescription(),
                "consumption_model", params.getConsumptionModel(),
                "is_public", params.getIsPublic(),
                "is_free", params.getIsFree(),
                "block_on_exhaustion", params.getBlockOnExhaustion(),
                "unused_plan_credits", params.getUnusedPlanCredits(),
                "plan_credit_limit", params.getPlanCreditLimit(),
                "unused_plan_balance", params.getUnusedPlanBalance(),
                "plan_balance_limit", params.getPlanBalanceLimit(),
                "plan_group_id", params.getPlanGroupId(),
                "is_default", params.getIsDefault(),
                "metadata", params.getMetadata()
        ), params.getIdempotencyKey(), new TypeReference<Plan>() {}).getData();
    }
}
