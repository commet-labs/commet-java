package co.commet.params;

import co.commet.models.CompletePayoutVerificationParamsBank;
import co.commet.models.CompletePayoutVerificationParamsCompany;
import co.commet.models.CompletePayoutVerificationParamsIndividual;

public final class CompletePayoutVerificationParams {

    private final String email;
    private final String businessType;
    private final String businessUrl;
    private final String documentUrl;
    private final CompletePayoutVerificationParamsBank bank;
    private final CompletePayoutVerificationParamsIndividual individual;
    private final CompletePayoutVerificationParamsCompany company;
    private final String idempotencyKey;

    private CompletePayoutVerificationParams(Builder builder) {
        this.email = builder.email;
        this.businessType = builder.businessType;
        this.businessUrl = builder.businessUrl;
        this.documentUrl = builder.documentUrl;
        this.bank = builder.bank;
        this.individual = builder.individual;
        this.company = builder.company;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String email, String businessType, String businessUrl, String documentUrl, CompletePayoutVerificationParamsBank bank) {
        return new Builder(email, businessType, businessUrl, documentUrl, bank);
    }

    public String getEmail() { return email; }
    public String getBusinessType() { return businessType; }
    public String getBusinessUrl() { return businessUrl; }
    public String getDocumentUrl() { return documentUrl; }
    public CompletePayoutVerificationParamsBank getBank() { return bank; }
    public CompletePayoutVerificationParamsIndividual getIndividual() { return individual; }
    public CompletePayoutVerificationParamsCompany getCompany() { return company; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String email;
        private final String businessType;
        private final String businessUrl;
        private final String documentUrl;
        private final CompletePayoutVerificationParamsBank bank;
        private CompletePayoutVerificationParamsIndividual individual;
        private CompletePayoutVerificationParamsCompany company;
        private String idempotencyKey;

        private Builder(String email, String businessType, String businessUrl, String documentUrl, CompletePayoutVerificationParamsBank bank) {
            this.email = email;
            this.businessType = businessType;
            this.businessUrl = businessUrl;
            this.documentUrl = documentUrl;
            this.bank = bank;
        }

        public Builder individual(CompletePayoutVerificationParamsIndividual individual) {
            this.individual = individual;
            return this;
        }

        public Builder company(CompletePayoutVerificationParamsCompany company) {
            this.company = company;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CompletePayoutVerificationParams build() {
            return new CompletePayoutVerificationParams(this);
        }
    }
}
