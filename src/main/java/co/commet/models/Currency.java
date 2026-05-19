package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Currency {
    USD("USD"),
    EUR("EUR"),
    GBP("GBP"),
    CAD("CAD"),
    AUD("AUD"),
    JPY("JPY"),
    ARS("ARS"),
    BRL("BRL"),
    MXN("MXN"),
    CLP("CLP");

    private final String value;

    Currency(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static Currency fromValue(String value) {
        for (Currency type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown Currency: " + value);
    }
}
