package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ConsumptionModel {
    METERED("metered"),
    CREDITS("credits"),
    BALANCE("balance");

    private final String value;

    ConsumptionModel(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static ConsumptionModel fromValue(String value) {
        for (ConsumptionModel type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown ConsumptionModel: " + value);
    }
}
