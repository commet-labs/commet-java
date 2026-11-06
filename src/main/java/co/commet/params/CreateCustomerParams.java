package co.commet.params;

import co.commet.models.CreateCustomerParamsAddress;
import co.commet.models.Timezone;
import java.util.Map;

public final class CreateCustomerParams {

    private final String email;
    private final String id;
    private final String externalId;
    private final String fullName;
    private final String taxDocument;
    private final String businessTaxId;
    private final CreateCustomerParamsAddress address;
    private final String addressId;
    private final Timezone timezone;
    private final Map<String, Object> metadata;
    private final String planGroupId;
    private final String idempotencyKey;

    private CreateCustomerParams(Builder builder) {
        this.email = builder.email;
        this.id = builder.id;
        this.externalId = builder.externalId;
        this.fullName = builder.fullName;
        this.taxDocument = builder.taxDocument;
        this.businessTaxId = builder.businessTaxId;
        this.address = builder.address;
        this.addressId = builder.addressId;
        this.timezone = builder.timezone;
        this.metadata = builder.metadata;
        this.planGroupId = builder.planGroupId;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String email) {
        return new Builder(email);
    }

    public String getEmail() { return email; }
    public String getId() { return id; }
    public String getExternalId() { return externalId; }
    public String getFullName() { return fullName; }
    public String getTaxDocument() { return taxDocument; }
    public String getBusinessTaxId() { return businessTaxId; }
    public CreateCustomerParamsAddress getAddress() { return address; }
    public String getAddressId() { return addressId; }
    public Timezone getTimezone() { return timezone; }
    public Map<String, Object> getMetadata() { return metadata; }
    public String getPlanGroupId() { return planGroupId; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String email;
        private String id;
        private String externalId;
        private String fullName;
        private String taxDocument;
        private String businessTaxId;
        private CreateCustomerParamsAddress address;
        private String addressId;
        private Timezone timezone;
        private Map<String, Object> metadata;
        private String planGroupId;
        private String idempotencyKey;

        private Builder(String email) {
            this.email = email;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder externalId(String externalId) {
            this.externalId = externalId;
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

        public Builder businessTaxId(String businessTaxId) {
            this.businessTaxId = businessTaxId;
            return this;
        }

        public Builder address(CreateCustomerParamsAddress address) {
            this.address = address;
            return this;
        }

        public Builder addressId(String addressId) {
            this.addressId = addressId;
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

        public Builder planGroupId(String planGroupId) {
            this.planGroupId = planGroupId;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CreateCustomerParams build() {
            return new CreateCustomerParams(this);
        }
    }
}
