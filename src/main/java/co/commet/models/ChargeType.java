package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ChargeType {
    STANDARD("standard"),
    ADVANCE("advance"),
    TRUE_UP("true_up");

    private final String value;

    ChargeType(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static ChargeType fromValue(String value) {
        for (ChargeType type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown ChargeType: " + value);
    }
}
