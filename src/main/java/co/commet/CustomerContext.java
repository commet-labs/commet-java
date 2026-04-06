package co.commet;

import co.commet.resources.FeaturesResource;
import co.commet.resources.PortalResource;
import co.commet.resources.SeatsResource;
import co.commet.resources.SubscriptionsResource;
import co.commet.resources.UsageResource;

import java.util.Map;

public class CustomerContext {

    private final String externalId;
    private final CustomerFeatures features;
    private final CustomerSeats seats;
    private final CustomerUsage usage;
    private final CustomerSubscription subscription;
    private final CustomerPortal portal;

    public CustomerContext(String externalId, FeaturesResource features, SeatsResource seats,
                           UsageResource usage, SubscriptionsResource subscriptions,
                           PortalResource portal) {
        this.externalId = externalId;
        this.features = new CustomerFeatures(externalId, features);
        this.seats = new CustomerSeats(externalId, seats);
        this.usage = new CustomerUsage(externalId, usage);
        this.subscription = new CustomerSubscription(externalId, subscriptions);
        this.portal = new CustomerPortal(externalId, portal);
    }

    public CustomerFeatures features() {
        return features;
    }

    public CustomerSeats seats() {
        return seats;
    }

    public CustomerUsage usage() {
        return usage;
    }

    public CustomerSubscription subscription() {
        return subscription;
    }

    public CustomerPortal portal() {
        return portal;
    }

    public static class CustomerFeatures {

        private final String externalId;
        private final FeaturesResource resource;

        CustomerFeatures(String externalId, FeaturesResource resource) {
            this.externalId = externalId;
            this.resource = resource;
        }

        public ApiResponse get(String code) {
            return resource.get(code, externalId);
        }

        public ApiResponse check(String code) {
            return resource.check(code, externalId);
        }

        public ApiResponse canUse(String code) {
            return resource.canUse(code, externalId);
        }

        public ApiResponse list() {
            return resource.list(externalId);
        }
    }

    public static class CustomerSeats {

        private final String externalId;
        private final SeatsResource resource;

        CustomerSeats(String externalId, SeatsResource resource) {
            this.externalId = externalId;
            this.resource = resource;
        }

        public ApiResponse add(String seatType) {
            return add(seatType, 1);
        }

        public ApiResponse add(String seatType, int count) {
            return resource.add(seatType, count, null, externalId, null);
        }

        public ApiResponse remove(String seatType) {
            return remove(seatType, 1);
        }

        public ApiResponse remove(String seatType, int count) {
            return resource.remove(seatType, count, null, externalId, null);
        }

        public ApiResponse set(String seatType, int count) {
            return resource.set(seatType, count, null, externalId, null);
        }

        public ApiResponse getBalance(String seatType) {
            return resource.getBalance(seatType, null, externalId);
        }
    }

    public static class CustomerUsage {

        private final String externalId;
        private final UsageResource resource;

        CustomerUsage(String externalId, UsageResource resource) {
            this.externalId = externalId;
            this.resource = resource;
        }

        public ApiResponse track(String feature) {
            return track(feature, null, null);
        }

        public ApiResponse track(String feature, Integer value, Map<String, String> properties) {
            return resource.track(feature, null, externalId, value, null, null, null, null, null, null, null, properties);
        }
    }

    public static class CustomerSubscription {

        private final String externalId;
        private final SubscriptionsResource resource;

        CustomerSubscription(String externalId, SubscriptionsResource resource) {
            this.externalId = externalId;
            this.resource = resource;
        }

        public ApiResponse get() {
            return resource.get(externalId);
        }
    }

    public static class CustomerPortal {

        private final String externalId;
        private final PortalResource resource;

        CustomerPortal(String externalId, PortalResource resource) {
            this.externalId = externalId;
            this.resource = resource;
        }

        public ApiResponse getUrl() {
            return resource.getUrl(null, externalId, null, null);
        }
    }
}
