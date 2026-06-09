package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SubscriptionStatus {
    DRAFT("draft"),
    PENDING_PAYMENT("pending_payment"),
    TRIALING("trialing"),
    ACTIVE("active"),
    PAST_DUE("past_due"),
    CANCELED("canceled");

    private final String value;

    SubscriptionStatus(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static SubscriptionStatus fromValue(String value) {
        for (SubscriptionStatus type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown SubscriptionStatus: " + value);
    }
}
