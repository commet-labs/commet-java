package co.commet;

import co.commet.resources.AddonsResource;
import co.commet.resources.ApiKeysResource;
import co.commet.resources.CreditPacksResource;
import co.commet.resources.CustomersResource;
import co.commet.resources.FeaturesResource;
import co.commet.resources.InvoicesResource;
import co.commet.resources.PlanGroupsResource;
import co.commet.resources.PlansResource;
import co.commet.resources.PortalResource;
import co.commet.resources.PromoCodesResource;
import co.commet.resources.QuotaResource;
import co.commet.resources.SeatsResource;
import co.commet.resources.SubscriptionsResource;
import co.commet.resources.TransactionsResource;
import co.commet.resources.UsageResource;
import co.commet.resources.Webhooks;

import java.time.Duration;
import java.util.logging.Logger;

public class Commet implements AutoCloseable {

    private static final Logger logger = Logger.getLogger("co.commet");

    private final CommetHttpClient httpClient;

    private final CustomersResource customers;
    private final PlansResource plans;
    private final SubscriptionsResource subscriptions;
    private final UsageResource usage;
    private final SeatsResource seats;
    private final QuotaResource quota;
    private final FeaturesResource features;
    private final PortalResource portal;
    private final CreditPacksResource creditPacks;
    private final AddonsResource addons;
    private final Webhooks webhooks;
    private final ApiKeysResource apiKeys;
    private final InvoicesResource invoices;
    private final TransactionsResource transactions;
    private final PromoCodesResource promoCodes;
    private final PlanGroupsResource planGroups;

    private Commet(String apiKey, Duration timeout, int retries, boolean telemetry, String apiVersion,
                   boolean debug) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("Commet SDK: API key is required");
        }
        if (!apiKey.startsWith("ck_")) {
            throw new IllegalArgumentException("Commet SDK: Invalid API key format. Expected format: ck_xxx...");
        }

        this.httpClient = new CommetHttpClient(apiKey, timeout, retries, telemetry, apiVersion, debug);

        this.customers = new CustomersResource(httpClient);
        this.plans = new PlansResource(httpClient);
        this.subscriptions = new SubscriptionsResource(httpClient);
        this.usage = new UsageResource(httpClient);
        this.seats = new SeatsResource(httpClient);
        this.quota = new QuotaResource(httpClient);
        this.features = new FeaturesResource(httpClient);
        this.portal = new PortalResource(httpClient);
        this.creditPacks = new CreditPacksResource(httpClient);
        this.addons = new AddonsResource(httpClient);
        this.webhooks = new Webhooks(httpClient);
        this.apiKeys = new ApiKeysResource(httpClient);
        this.invoices = new InvoicesResource(httpClient);
        this.transactions = new TransactionsResource(httpClient);
        this.promoCodes = new PromoCodesResource(httpClient);
        this.planGroups = new PlanGroupsResource(httpClient);

        logger.fine("Commet client initialized");
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void close() {
        httpClient.close();
    }

    public CustomersResource customers() {
        return customers;
    }

    public PlansResource plans() {
        return plans;
    }

    public SubscriptionsResource subscriptions() {
        return subscriptions;
    }

    public UsageResource usage() {
        return usage;
    }

    public SeatsResource seats() {
        return seats;
    }

    public QuotaResource quota() {
        return quota;
    }

    public FeaturesResource features() {
        return features;
    }

    public PortalResource portal() {
        return portal;
    }

    public CreditPacksResource creditPacks() {
        return creditPacks;
    }

    public AddonsResource addons() {
        return addons;
    }

    public Webhooks webhooks() {
        return webhooks;
    }

    public ApiKeysResource apiKeys() {
        return apiKeys;
    }

    public InvoicesResource invoices() {
        return invoices;
    }

    public TransactionsResource transactions() {
        return transactions;
    }

    public PromoCodesResource promoCodes() {
        return promoCodes;
    }

    public PlanGroupsResource planGroups() {
        return planGroups;
    }

    public static class Builder {

        private String apiKey;
        private String apiVersion;
        private Duration timeout = Duration.ofSeconds(30);
        private int retries = 3;
        private boolean telemetry = true;
        private boolean debug = false;

        private Builder() {}

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder timeout(Duration timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder retries(int retries) {
            this.retries = retries;
            return this;
        }

        public Builder telemetry(boolean telemetry) {
            this.telemetry = telemetry;
            return this;
        }

        public Builder apiVersion(String apiVersion) {
            this.apiVersion = apiVersion;
            return this;
        }

        public Builder debug(boolean debug) {
            this.debug = debug;
            return this;
        }

        public Commet build() {
            return new Commet(apiKey, timeout, retries, telemetry, apiVersion, debug);
        }
    }
}
