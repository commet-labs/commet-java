package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InvoiceType {
    RECURRING("recurring"),
    OVERAGE("overage"),
    PLAN_CHANGE("plan_change"),
    ADJUSTMENT("adjustment"),
    CREDIT_PURCHASE("credit_purchase"),
    BALANCE_TOPUP("balance_topup"),
    ADDON_ACTIVATION("addon_activation");

    private final String value;

    InvoiceType(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static InvoiceType fromValue(String value) {
        for (InvoiceType type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown InvoiceType: " + value);
    }
}
