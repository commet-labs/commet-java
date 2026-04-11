package co.commet.params;

import java.util.Map;

public final class UpdateCustomerParams {

    private final String email;
    private final String fullName;
    private final String domain;
    private final String website;
    private final String timezone;
    private final String language;
    private final String industry;
    private final Map<String, Object> metadata;
    private final Map<String, String> address;
    private final String idempotencyKey;

    private UpdateCustomerParams(Builder builder) {
        this.email = builder.email;
        this.fullName = builder.fullName;
        this.domain = builder.domain;
        this.website = builder.website;
        this.timezone = builder.timezone;
        this.language = builder.language;
        this.industry = builder.industry;
        this.metadata = builder.metadata;
        this.address = builder.address;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getEmail() { return email; }
    public String getFullName() { return fullName; }
    public String getDomain() { return domain; }
    public String getWebsite() { return website; }
    public String getTimezone() { return timezone; }
    public String getLanguage() { return language; }
    public String getIndustry() { return industry; }
    public Map<String, Object> getMetadata() { return metadata; }
    public Map<String, String> getAddress() { return address; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String email;
        private String fullName;
        private String domain;
        private String website;
        private String timezone;
        private String language;
        private String industry;
        private Map<String, Object> metadata;
        private Map<String, String> address;
        private String idempotencyKey;

        private Builder() {}

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder domain(String domain) {
            this.domain = domain;
            return this;
        }

        public Builder website(String website) {
            this.website = website;
            return this;
        }

        public Builder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public Builder industry(String industry) {
            this.industry = industry;
            return this;
        }

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder address(Map<String, String> address) {
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
