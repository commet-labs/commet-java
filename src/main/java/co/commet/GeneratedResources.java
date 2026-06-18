package co.commet;

import co.commet.resources.AddonsResource;
import co.commet.resources.ApiKeysResource;
import co.commet.resources.CreditPacksResource;
import co.commet.resources.CustomersResource;
import co.commet.resources.FeatureAccessResource;
import co.commet.resources.FeaturesResource;
import co.commet.resources.InvoicesResource;
import co.commet.resources.PaymentsResource;
import co.commet.resources.PayoutsResource;
import co.commet.resources.PlanGroupsResource;
import co.commet.resources.PlansResource;
import co.commet.resources.PortalResource;
import co.commet.resources.PromoCodesResource;
import co.commet.resources.QuotaResource;
import co.commet.resources.SeatsResource;
import co.commet.resources.SubscriptionsResource;
import co.commet.resources.TestClockResource;
import co.commet.resources.TransactionsResource;

public abstract class GeneratedResources {

    protected final CommetHttpClient httpClient;

    protected final AddonsResource addons;
    protected final ApiKeysResource apiKeys;
    protected final CreditPacksResource creditPacks;
    protected final CustomersResource customers;
    protected final FeatureAccessResource featureAccess;
    protected final FeaturesResource features;
    protected final InvoicesResource invoices;
    protected final PaymentsResource payments;
    protected final PayoutsResource payouts;
    protected final PlanGroupsResource planGroups;
    protected final PlansResource plans;
    protected final PortalResource portal;
    protected final PromoCodesResource promoCodes;
    protected final QuotaResource quota;
    protected final SeatsResource seats;
    protected final SubscriptionsResource subscriptions;
    protected final TestClockResource testClock;
    protected final TransactionsResource transactions;

    protected GeneratedResources(CommetHttpClient httpClient) {
        this.httpClient = httpClient;
        this.addons = new AddonsResource(httpClient);
        this.apiKeys = new ApiKeysResource(httpClient);
        this.creditPacks = new CreditPacksResource(httpClient);
        this.customers = new CustomersResource(httpClient);
        this.featureAccess = new FeatureAccessResource(httpClient);
        this.features = new FeaturesResource(httpClient);
        this.invoices = new InvoicesResource(httpClient);
        this.payments = new PaymentsResource(httpClient);
        this.payouts = new PayoutsResource(httpClient);
        this.planGroups = new PlanGroupsResource(httpClient);
        this.plans = new PlansResource(httpClient);
        this.portal = new PortalResource(httpClient);
        this.promoCodes = new PromoCodesResource(httpClient);
        this.quota = new QuotaResource(httpClient);
        this.seats = new SeatsResource(httpClient);
        this.subscriptions = new SubscriptionsResource(httpClient);
        this.testClock = new TestClockResource(httpClient);
        this.transactions = new TransactionsResource(httpClient);
    }

    public AddonsResource addons() { return addons; }
    public ApiKeysResource apiKeys() { return apiKeys; }
    public CreditPacksResource creditPacks() { return creditPacks; }
    public CustomersResource customers() { return customers; }
    public FeatureAccessResource featureAccess() { return featureAccess; }
    public FeaturesResource features() { return features; }
    public InvoicesResource invoices() { return invoices; }
    public PaymentsResource payments() { return payments; }
    public PayoutsResource payouts() { return payouts; }
    public PlanGroupsResource planGroups() { return planGroups; }
    public PlansResource plans() { return plans; }
    public PortalResource portal() { return portal; }
    public PromoCodesResource promoCodes() { return promoCodes; }
    public QuotaResource quota() { return quota; }
    public SeatsResource seats() { return seats; }
    public SubscriptionsResource subscriptions() { return subscriptions; }
    public TestClockResource testClock() { return testClock; }
    public TransactionsResource transactions() { return transactions; }
}
