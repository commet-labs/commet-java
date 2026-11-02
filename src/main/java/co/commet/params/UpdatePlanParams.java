package co.commet.params;

import co.commet.models.UpdatePlanParamsPlanCreditLimit;
import co.commet.models.UpdatePlanParamsUnusedPlanCredits;
import java.util.Map;

public final class UpdatePlanParams {

    private final String name;
    private final String description;
    private final Map<String, Object> metadata;
    private final Boolean isPublic;
    private final UpdatePlanParamsUnusedPlanCredits unusedPlanCredits;
    private final UpdatePlanParamsPlanCreditLimit planCreditLimit;
    private final Boolean isDefault;
    private final String idempotencyKey;

    private UpdatePlanParams(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.metadata = builder.metadata;
        this.isPublic = builder.isPublic;
        this.unusedPlanCredits = builder.unusedPlanCredits;
        this.planCreditLimit = builder.planCreditLimit;
        this.isDefault = builder.isDefault;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Map<String, Object> getMetadata() { return metadata; }
    public Boolean getIsPublic() { return isPublic; }
    public UpdatePlanParamsUnusedPlanCredits getUnusedPlanCredits() { return unusedPlanCredits; }
    public UpdatePlanParamsPlanCreditLimit getPlanCreditLimit() { return planCreditLimit; }
    public Boolean getIsDefault() { return isDefault; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String name;
        private String description;
        private Map<String, Object> metadata;
        private Boolean isPublic;
        private UpdatePlanParamsUnusedPlanCredits unusedPlanCredits;
        private UpdatePlanParamsPlanCreditLimit planCreditLimit;
        private Boolean isDefault;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder isPublic(Boolean isPublic) {
            this.isPublic = isPublic;
            return this;
        }

        public Builder unusedPlanCredits(UpdatePlanParamsUnusedPlanCredits unusedPlanCredits) {
            this.unusedPlanCredits = unusedPlanCredits;
            return this;
        }

        public Builder planCreditLimit(UpdatePlanParamsPlanCreditLimit planCreditLimit) {
            this.planCreditLimit = planCreditLimit;
            return this;
        }

        public Builder isDefault(Boolean isDefault) {
            this.isDefault = isDefault;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdatePlanParams build() {
            return new UpdatePlanParams(this);
        }
    }
}
