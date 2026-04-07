package co.commet;

import co.commet.resources.CreditPacksResource;
import co.commet.resources.CustomersResource;
import co.commet.resources.FeaturesResource;
import co.commet.resources.PlansResource;
import co.commet.resources.PortalResource;
import co.commet.resources.SeatsResource;
import co.commet.resources.SubscriptionsResource;
import co.commet.resources.UsageResource;
import co.commet.resources.Webhooks;

import java.time.Duration;
import java.util.logging.Logger;

public class Commet implements AutoCloseable {

    private static final Logger logger = Logger.getLogger("co.commet");

    private final Environment environment;
    private final CommetHttpClient httpClient;

    private final CustomersResource customers;
    private final PlansResource plans;
    private final SubscriptionsResource subscriptions;
    private final UsageResource usage;
    private final SeatsResource seats;
    private final FeaturesResource features;
    private final PortalResource portal;
    private final CreditPacksResource creditPacks;
    private final Webhooks webhooks;

    private Commet(String apiKey, Environment environment, Duration timeout, int retries) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("Commet SDK: API key is required");
        }
        if (!apiKey.startsWith("ck_")) {
            throw new IllegalArgumentException("Commet SDK: Invalid API key format. Expected format: ck_xxx...");
        }

        this.environment = environment;
        this.httpClient = new CommetHttpClient(apiKey, environment.getValue(), timeout, retries);

        this.customers = new CustomersResource(httpClient);
        this.plans = new PlansResource(httpClient);
        this.subscriptions = new SubscriptionsResource(httpClient);
        this.usage = new UsageResource(httpClient);
        this.seats = new SeatsResource(httpClient);
        this.features = new FeaturesResource(httpClient);
        this.portal = new PortalResource(httpClient);
        this.creditPacks = new CreditPacksResource(httpClient);
        this.webhooks = new Webhooks();

        logger.fine("Initialized in " + environment.getValue() + " mode");
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

    public FeaturesResource features() {
        return features;
    }

    public PortalResource portal() {
        return portal;
    }

    public CreditPacksResource creditPacks() {
        return creditPacks;
    }

    public Webhooks webhooks() {
        return webhooks;
    }

    public CustomerContext customer(String customerId) {
        return new CustomerContext(customerId, features, seats, usage, subscriptions, portal);
    }

    public Environment getEnvironment() {
        return environment;
    }

    public boolean isSandbox() {
        return environment == Environment.SANDBOX;
    }

    public boolean isProduction() {
        return environment == Environment.PRODUCTION;
    }

    public static class Builder {

        private String apiKey;
        private Environment environment = Environment.SANDBOX;
        private Duration timeout = Duration.ofSeconds(30);
        private int retries = 3;

        private Builder() {}

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder environment(Environment environment) {
            this.environment = environment;
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

        public Commet build() {
            return new Commet(apiKey, environment, timeout, retries);
        }
    }
}
