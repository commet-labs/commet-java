package co.commet;

import co.commet.resources.UsageResource;
import co.commet.resources.Webhooks;

import java.time.Duration;
import java.util.logging.Logger;

public class Commet extends GeneratedResources implements AutoCloseable {

    private static final Logger logger = Logger.getLogger("co.commet");

    private final UsageResource usage;
    private final Webhooks webhooks;

    private Commet(String apiKey, Duration timeout, int retries, boolean telemetry, String apiVersion,
                   boolean debug) {
        super(buildHttpClient(apiKey, timeout, retries, telemetry, apiVersion, debug));

        this.usage = new UsageResource(httpClient);
        this.webhooks = new Webhooks(httpClient);

        logger.fine("Commet client initialized");
    }

    private static CommetHttpClient buildHttpClient(String apiKey, Duration timeout, int retries,
                                                    boolean telemetry, String apiVersion, boolean debug) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("Commet SDK: API key is required");
        }
        if (!apiKey.startsWith("ck_")) {
            throw new IllegalArgumentException("Commet SDK: Invalid API key format. Expected format: ck_xxx...");
        }
        return new CommetHttpClient(apiKey, timeout, retries, telemetry, apiVersion, debug);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void close() {
        httpClient.close();
    }

    public UsageResource usage() {
        return usage;
    }

    public Webhooks webhooks() {
        return webhooks;
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
