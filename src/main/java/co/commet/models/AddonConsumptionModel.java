package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AddonConsumptionModel {
    BOOLEAN("boolean"),
    METERED("metered"),
    CREDITS("credits"),
    BALANCE("balance");

    private final String value;

    AddonConsumptionModel(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static AddonConsumptionModel fromValue(String value) {
        for (AddonConsumptionModel type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown AddonConsumptionModel: " + value);
    }
}
