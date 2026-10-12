package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SubPaymentMethod {
    CREDIT_CARD("credit_card"),
    DEBIT_CARD("debit_card"),
    PREPAID_CARD("prepaid_card"),
    BANK_TRANSFER("bank_transfer"),
    ACCOUNT_MONEY("account_money"),
    /** A value added to the API after this SDK version. Read it from the model's matching AsString accessor. */
    UNKNOWN_TO_SDK_VERSION(null);

    private final String value;

    SubPaymentMethod(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static SubPaymentMethod fromValue(String value) {
        if (value == null) return null;
        for (SubPaymentMethod type : values()) {
            if (value.equals(type.value)) return type;
        }
        return UNKNOWN_TO_SDK_VERSION;
    }
}
