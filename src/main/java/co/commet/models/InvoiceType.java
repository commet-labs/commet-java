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
    ADDON_ACTIVATION("addon_activation"),
    ONE_TIME_PAYMENT("one_time_payment"),
    REACTIVATION("reactivation"),
    RESUME("resume"),
    /** A value added to the API after this SDK version. Read it from the model's matching AsString accessor. */
    UNKNOWN_TO_SDK_VERSION(null);

    private final String value;

    InvoiceType(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static InvoiceType fromValue(String value) {
        if (value == null) return null;
        for (InvoiceType type : values()) {
            if (value.equals(type.value)) return type;
        }
        return UNKNOWN_TO_SDK_VERSION;
    }
}
