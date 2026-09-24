package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SubPaymentMethod {
    CREDIT_CARD("credit_card"),
    DEBIT_CARD("debit_card"),
    PREPAID_CARD("prepaid_card"),
    BANK_TRANSFER("bank_transfer"),
    ACCOUNT_MONEY("account_money");

    private final String value;

    SubPaymentMethod(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static SubPaymentMethod fromValue(String value) {
        for (SubPaymentMethod type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown SubPaymentMethod: " + value);
    }
}
