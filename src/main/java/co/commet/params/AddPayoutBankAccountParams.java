package co.commet.params;

public final class AddPayoutBankAccountParams {

    private final String accountNumber;
    private final String accountHolderName;
    private final String routingNumber;
    private final String accountType;
    private final Boolean setDefault;
    private final String idempotencyKey;

    private AddPayoutBankAccountParams(Builder builder) {
        this.accountNumber = builder.accountNumber;
        this.accountHolderName = builder.accountHolderName;
        this.routingNumber = builder.routingNumber;
        this.accountType = builder.accountType;
        this.setDefault = builder.setDefault;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String accountNumber, String accountHolderName) {
        return new Builder(accountNumber, accountHolderName);
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public String getRoutingNumber() { return routingNumber; }
    public String getAccountType() { return accountType; }
    public Boolean getSetDefault() { return setDefault; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String accountNumber;
        private final String accountHolderName;
        private String routingNumber;
        private String accountType;
        private Boolean setDefault;
        private String idempotencyKey;

        private Builder(String accountNumber, String accountHolderName) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
        }

        public Builder routingNumber(String routingNumber) {
            this.routingNumber = routingNumber;
            return this;
        }

        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder setDefault(Boolean setDefault) {
            this.setDefault = setDefault;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public AddPayoutBankAccountParams build() {
            return new AddPayoutBankAccountParams(this);
        }
    }
}
