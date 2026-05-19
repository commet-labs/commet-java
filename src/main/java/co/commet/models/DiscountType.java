package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DiscountType {
    PERCENTAGE("percentage"),
    AMOUNT("amount");

    private final String value;

    DiscountType(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static DiscountType fromValue(String value) {
        for (DiscountType type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown DiscountType: " + value);
    }
}
