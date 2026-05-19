package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OverageModel {
    PER_UNIT("per_unit"),
    TIERED("tiered");

    private final String value;

    OverageModel(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static OverageModel fromValue(String value) {
        for (OverageModel type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown OverageModel: " + value);
    }
}
