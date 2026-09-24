package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentMethod {
    CARD("card"),
    OXXO("oxxo"),
    MERCADO_PAGO("mercado_pago");

    private final String value;

    PaymentMethod(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static PaymentMethod fromValue(String value) {
        for (PaymentMethod type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown PaymentMethod: " + value);
    }
}
