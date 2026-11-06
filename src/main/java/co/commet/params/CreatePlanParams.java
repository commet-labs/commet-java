package co.commet.params;

import co.commet.models.CreatePlanParamsPlanBalanceLimit;
import co.commet.models.CreatePlanParamsPlanCreditLimit;
import co.commet.models.CreatePlanParamsUnusedPlanBalance;
import co.commet.models.CreatePlanParamsUnusedPlanCredits;
import java.util.Map;

public final class CreatePlanParams {

    private final String name;
    private final String code;
    private final String description;
    private final String consumptionModel;
    private final Boolean isPublic;
    private final Boolean isFree;
    private final Boolean blockOnExhaustion;
    private final CreatePlanParamsUnusedPlanCredits unusedPlanCredits;
    private final CreatePlanParamsPlanCreditLimit planCreditLimit;
    private final CreatePlanParamsUnusedPlanBalance unusedPlanBalance;
    private final CreatePlanParamsPlanBalanceLimit planBalanceLimit;
    private final String planGroupId;
    private final Boolean isDefault;
    private final Map<String, Object> metadata;
    private final String idempotencyKey;

    private CreatePlanParams(Builder builder) {
        this.name = builder.name;
        this.code = builder.code;
        this.description = builder.description;
        this.consumptionModel = builder.consumptionModel;
        this.isPublic = builder.isPublic;
        this.isFree = builder.isFree;
        this.blockOnExhaustion = builder.blockOnExhaustion;
        this.unusedPlanCredits = builder.unusedPlanCredits;
        this.planCreditLimit = builder.planCreditLimit;
        this.unusedPlanBalance = builder.unusedPlanBalance;
        this.planBalanceLimit = builder.planBalanceLimit;
        this.planGroupId = builder.planGroupId;
        this.isDefault = builder.isDefault;
        this.metadata = builder.metadata;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String name, String code) {
        return new Builder(name, code);
    }

    public String getName() { return name; }
    public String getCode() { return code; }
    public String getDescription() { return description; }
    public String getConsumptionModel() { return consumptionModel; }
    public Boolean getIsPublic() { return isPublic; }
    public Boolean getIsFree() { return isFree; }
    public Boolean getBlockOnExhaustion() { return blockOnExhaustion; }
    public CreatePlanParamsUnusedPlanCredits getUnusedPlanCredits() { return unusedPlanCredits; }
    public CreatePlanParamsPlanCreditLimit getPlanCreditLimit() { return planCreditLimit; }
    public CreatePlanParamsUnusedPlanBalance getUnusedPlanBalance() { return unusedPlanBalance; }
    public CreatePlanParamsPlanBalanceLimit getPlanBalanceLimit() { return planBalanceLimit; }
    public String getPlanGroupId() { return planGroupId; }
    public Boolean getIsDefault() { return isDefault; }
    public Map<String, Object> getMetadata() { return metadata; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String name;
        private final String code;
        private String description;
        private String consumptionModel;
        private Boolean isPublic;
        private Boolean isFree;
        private Boolean blockOnExhaustion;
        private CreatePlanParamsUnusedPlanCredits unusedPlanCredits;
        private CreatePlanParamsPlanCreditLimit planCreditLimit;
        private CreatePlanParamsUnusedPlanBalance unusedPlanBalance;
        private CreatePlanParamsPlanBalanceLimit planBalanceLimit;
        private String planGroupId;
        private Boolean isDefault;
        private Map<String, Object> metadata;
        private String idempotencyKey;

        private Builder(String name, String code) {
            this.name = name;
            this.code = code;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder consumptionModel(String consumptionModel) {
            this.consumptionModel = consumptionModel;
            return this;
        }

        public Builder isPublic(Boolean isPublic) {
            this.isPublic = isPublic;
            return this;
        }

        public Builder isFree(Boolean isFree) {
            this.isFree = isFree;
            return this;
        }

        public Builder blockOnExhaustion(Boolean blockOnExhaustion) {
            this.blockOnExhaustion = blockOnExhaustion;
            return this;
        }

        public Builder unusedPlanCredits(CreatePlanParamsUnusedPlanCredits unusedPlanCredits) {
            this.unusedPlanCredits = unusedPlanCredits;
            return this;
        }

        public Builder planCreditLimit(CreatePlanParamsPlanCreditLimit planCreditLimit) {
            this.planCreditLimit = planCreditLimit;
            return this;
        }

        public Builder unusedPlanBalance(CreatePlanParamsUnusedPlanBalance unusedPlanBalance) {
            this.unusedPlanBalance = unusedPlanBalance;
            return this;
        }

        public Builder planBalanceLimit(CreatePlanParamsPlanBalanceLimit planBalanceLimit) {
            this.planBalanceLimit = planBalanceLimit;
            return this;
        }

        public Builder planGroupId(String planGroupId) {
            this.planGroupId = planGroupId;
            return this;
        }

        public Builder isDefault(Boolean isDefault) {
            this.isDefault = isDefault;
            return this;
        }

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CreatePlanParams build() {
            return new CreatePlanParams(this);
        }
    }
}
