package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FeatureType {
    BOOLEAN("boolean"),
    USAGE("usage"),
    SEATS("seats"),
    QUOTA("quota");

    private final String value;

    FeatureType(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static FeatureType fromValue(String value) {
        for (FeatureType type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown FeatureType: " + value);
    }
}
