package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentProvider {
    STRIPE("stripe"),
    COMMET("commet"),
    DLOCAL("dlocal");

    private final String value;

    PaymentProvider(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static PaymentProvider fromValue(String value) {
        for (PaymentProvider type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown PaymentProvider: " + value);
    }
}
