package co.commet;

public enum Environment {
    SANDBOX("sandbox"),
    PRODUCTION("production");

    private final String value;

    Environment(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
