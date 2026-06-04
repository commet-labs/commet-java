package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InvoiceLineType {
    PLAN_BASE("plan_base"),
    FEATURE_OVERAGE("feature_overage"),
    FEATURE_SEATS("feature_seats"),
    FEATURE_QUOTA("feature_quota"),
    DISCOUNT("discount"),
    CREDIT("credit"),
    ADDON_BASE("addon_base");

    private final String value;

    InvoiceLineType(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static InvoiceLineType fromValue(String value) {
        for (InvoiceLineType type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown InvoiceLineType: " + value);
    }
}
