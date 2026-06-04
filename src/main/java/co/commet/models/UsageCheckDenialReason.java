package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UsageCheckDenialReason {
    INCLUDED_LIMIT_REACHED("included_limit_reached"),
    INSUFFICIENT_CREDITS("insufficient_credits"),
    INSUFFICIENT_BALANCE("insufficient_balance");

    private final String value;

    UsageCheckDenialReason(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static UsageCheckDenialReason fromValue(String value) {
        for (UsageCheckDenialReason type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown UsageCheckDenialReason: " + value);
    }
}
