package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionStatus {
    PENDING("pending"),
    SUCCEEDED("succeeded"),
    FAILED("failed"),
    REFUNDED("refunded"),
    DISPUTED("disputed");

    private final String value;

    TransactionStatus(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static TransactionStatus fromValue(String value) {
        for (TransactionStatus type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown TransactionStatus: " + value);
    }
}
