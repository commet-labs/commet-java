package co.commet;

import co.commet.resources.FeaturesResource;
import co.commet.resources.PortalResource;
import co.commet.resources.SeatsResource;
import co.commet.resources.SubscriptionsResource;
import co.commet.resources.UsageResource;

import java.util.Map;

public class CustomerContext {

    private final String customerId;
    private final CustomerFeatures features;
    private final CustomerSeats seats;
    private final CustomerUsage usage;
    private final CustomerSubscription subscription;
    private final CustomerPortal portal;

    public CustomerContext(String customerId, FeaturesResource features, SeatsResource seats,
                           UsageResource usage, SubscriptionsResource subscriptions,
                           PortalResource portal) {
        this.customerId = customerId;
        this.features = new CustomerFeatures(customerId, features);
        this.seats = new CustomerSeats(customerId, seats);
        this.usage = new CustomerUsage(customerId, usage);
        this.subscription = new CustomerSubscription(customerId, subscriptions);
        this.portal = new CustomerPortal(customerId, portal);
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

        private final String customerId;
        private final FeaturesResource resource;

        CustomerFeatures(String customerId, FeaturesResource resource) {
            this.customerId = customerId;
            this.resource = resource;
        }

        public ApiResponse get(String code) {
            return resource.get(code, customerId);
        }

        public ApiResponse check(String code) {
            return resource.check(code, customerId);
        }

        public ApiResponse canUse(String code) {
            return resource.canUse(code, customerId);
        }

        public ApiResponse list() {
            return resource.list(customerId);
        }
    }

    public static class CustomerSeats {

        private final String customerId;
        private final SeatsResource resource;

        CustomerSeats(String customerId, SeatsResource resource) {
            this.customerId = customerId;
            this.resource = resource;
        }

        public ApiResponse add(String seatType) {
            return add(seatType, 1);
        }

        public ApiResponse add(String seatType, int count) {
            return resource.add(seatType, count, customerId, null);
        }

        public ApiResponse remove(String seatType) {
            return remove(seatType, 1);
        }

        public ApiResponse remove(String seatType, int count) {
            return resource.remove(seatType, count, customerId, null);
        }

        public ApiResponse set(String seatType, int count) {
            return resource.set(seatType, count, customerId, null);
        }

        public ApiResponse getBalance(String seatType) {
            return resource.getBalance(seatType, customerId);
        }
    }

    public static class CustomerUsage {

        private final String customerId;
        private final UsageResource resource;

        CustomerUsage(String customerId, UsageResource resource) {
            this.customerId = customerId;
            this.resource = resource;
        }

        public ApiResponse track(String feature) {
            return track(feature, null, null);
        }

        public ApiResponse track(String feature, Integer value, Map<String, String> properties) {
            return resource.track(feature, customerId, value, null, null, null, null, null, null, null, properties);
        }
    }

    public static class CustomerSubscription {

        private final String customerId;
        private final SubscriptionsResource resource;

        CustomerSubscription(String customerId, SubscriptionsResource resource) {
            this.customerId = customerId;
            this.resource = resource;
        }

        public ApiResponse get() {
            return resource.get(customerId);
        }
    }

    public static class CustomerPortal {

        private final String customerId;
        private final PortalResource resource;

        CustomerPortal(String customerId, PortalResource resource) {
            this.customerId = customerId;
            this.resource = resource;
        }

        public ApiResponse getUrl() {
            return resource.getUrl(customerId, null, null);
        }
    }
}
