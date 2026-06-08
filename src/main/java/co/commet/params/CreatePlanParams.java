package co.commet.params;

import co.commet.models.ConsumptionModel;
import java.util.Map;

public final class CreatePlanParams {

    private final String name;
    private final String code;
    private final String description;
    private final ConsumptionModel consumptionModel;
    private final Boolean isPublic;
    private final Boolean isFree;
    private final Boolean blockOnExhaustion;
    private final String planGroupId;
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
        this.planGroupId = builder.planGroupId;
        this.metadata = builder.metadata;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String name, String code) {
        return new Builder(name, code);
    }

    public String getName() { return name; }
    public String getCode() { return code; }
    public String getDescription() { return description; }
    public ConsumptionModel getConsumptionModel() { return consumptionModel; }
    public Boolean getIsPublic() { return isPublic; }
    public Boolean getIsFree() { return isFree; }
    public Boolean getBlockOnExhaustion() { return blockOnExhaustion; }
    public String getPlanGroupId() { return planGroupId; }
    public Map<String, Object> getMetadata() { return metadata; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String name;
        private final String code;
        private String description;
        private ConsumptionModel consumptionModel;
        private Boolean isPublic;
        private Boolean isFree;
        private Boolean blockOnExhaustion;
        private String planGroupId;
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

        public Builder consumptionModel(ConsumptionModel consumptionModel) {
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

        public Builder planGroupId(String planGroupId) {
            this.planGroupId = planGroupId;
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
