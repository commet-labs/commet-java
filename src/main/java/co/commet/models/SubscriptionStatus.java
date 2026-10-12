package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SubscriptionStatus {
    DRAFT("draft"),
    PENDING_PAYMENT("pending_payment"),
    TRIALING("trialing"),
    ACTIVE("active"),
    PAST_DUE("past_due"),
    PAUSED("paused"),
    CANCELED("canceled"),
    /** A value added to the API after this SDK version. Read it from the model's matching AsString accessor. */
    UNKNOWN_TO_SDK_VERSION(null);

    private final String value;

    SubscriptionStatus(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static SubscriptionStatus fromValue(String value) {
        if (value == null) return null;
        for (SubscriptionStatus type : values()) {
            if (value.equals(type.value)) return type;
        }
        return UNKNOWN_TO_SDK_VERSION;
    }
}
