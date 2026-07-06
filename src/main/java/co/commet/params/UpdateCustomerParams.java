package co.commet.params;

import co.commet.models.Timezone;
import co.commet.models.UpdateCustomerParamsAddress;
import java.util.Map;

public final class UpdateCustomerParams {

    private final String email;
    private final String fullName;
    private final String taxDocument;
    private final String externalId;
    private final Timezone timezone;
    private final Map<String, Object> metadata;
    private final UpdateCustomerParamsAddress address;
    private final String idempotencyKey;

    private UpdateCustomerParams(Builder builder) {
        this.email = builder.email;
        this.fullName = builder.fullName;
        this.taxDocument = builder.taxDocument;
        this.externalId = builder.externalId;
        this.timezone = builder.timezone;
        this.metadata = builder.metadata;
        this.address = builder.address;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getEmail() { return email; }
    public String getFullName() { return fullName; }
    public String getTaxDocument() { return taxDocument; }
    public String getExternalId() { return externalId; }
    public Timezone getTimezone() { return timezone; }
    public Map<String, Object> getMetadata() { return metadata; }
    public UpdateCustomerParamsAddress getAddress() { return address; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String email;
        private String fullName;
        private String taxDocument;
        private String externalId;
        private Timezone timezone;
        private Map<String, Object> metadata;
        private UpdateCustomerParamsAddress address;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder taxDocument(String taxDocument) {
            this.taxDocument = taxDocument;
            return this;
        }

        public Builder externalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public Builder timezone(Timezone timezone) {
            this.timezone = timezone;
            return this;
        }

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder address(UpdateCustomerParamsAddress address) {
            this.address = address;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdateCustomerParams build() {
            return new UpdateCustomerParams(this);
        }
    }
}
