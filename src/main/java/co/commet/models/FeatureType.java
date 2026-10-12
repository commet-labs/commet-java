package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FeatureType {
    BOOLEAN("boolean"),
    USAGE("usage"),
    SEATS("seats"),
    QUOTA("quota"),
    /** A value added to the API after this SDK version. Read it from the model's matching AsString accessor. */
    UNKNOWN_TO_SDK_VERSION(null);

    private final String value;

    FeatureType(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static FeatureType fromValue(String value) {
        if (value == null) return null;
        for (FeatureType type : values()) {
            if (value.equals(type.value)) return type;
        }
        return UNKNOWN_TO_SDK_VERSION;
    }
}
