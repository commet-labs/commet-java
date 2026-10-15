package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentMethod {
    CARD("card"),
    OXXO("oxxo"),
    MERCADO_PAGO("mercado_pago"),
    GOOGLE_PAY("google_pay"),
    SMARTPIX("smartpix"),
    /** A value added to the API after this SDK version. Read it from the model's matching AsString accessor. */
    UNKNOWN_TO_SDK_VERSION(null);

    private final String value;

    PaymentMethod(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static PaymentMethod fromValue(String value) {
        if (value == null) return null;
        for (PaymentMethod type : values()) {
            if (value.equals(type.value)) return type;
        }
        return UNKNOWN_TO_SDK_VERSION;
    }
}
