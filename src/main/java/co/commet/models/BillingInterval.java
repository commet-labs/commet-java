package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BillingInterval {
    WEEKLY("weekly"),
    MONTHLY("monthly"),
    QUARTERLY("quarterly"),
    YEARLY("yearly"),
    ONE_TIME("one_time"),
    /** A value added to the API after this SDK version. Read it from the model's matching AsString accessor. */
    UNKNOWN_TO_SDK_VERSION(null);

    private final String value;

    BillingInterval(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static BillingInterval fromValue(String value) {
        if (value == null) return null;
        for (BillingInterval type : values()) {
            if (value.equals(type.value)) return type;
        }
        return UNKNOWN_TO_SDK_VERSION;
    }
}
