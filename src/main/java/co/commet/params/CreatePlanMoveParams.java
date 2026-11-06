package co.commet.params;

import co.commet.models.CreatePlanMoveParamsChangesItem;
import java.util.List;

public final class CreatePlanMoveParams {

    private final String toVersionId;
    private final String effective;
    private final List<String> subscriptionIds;
    private final List<CreatePlanMoveParamsChangesItem> changes;
    private final Boolean preview;
    private final String fromVersionId;
    private final String idempotencyKey;

    private CreatePlanMoveParams(Builder builder) {
        this.toVersionId = builder.toVersionId;
        this.effective = builder.effective;
        this.subscriptionIds = builder.subscriptionIds;
        this.changes = builder.changes;
        this.preview = builder.preview;
        this.fromVersionId = builder.fromVersionId;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String toVersionId, String effective) {
        return new Builder(toVersionId, effective);
    }

    public String getToVersionId() { return toVersionId; }
    public String getEffective() { return effective; }
    public List<String> getSubscriptionIds() { return subscriptionIds; }
    public List<CreatePlanMoveParamsChangesItem> getChanges() { return changes; }
    public Boolean getPreview() { return preview; }
    public String getFromVersionId() { return fromVersionId; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String toVersionId;
        private final String effective;
        private List<String> subscriptionIds;
        private List<CreatePlanMoveParamsChangesItem> changes;
        private Boolean preview;
        private String fromVersionId;
        private String idempotencyKey;

        private Builder(String toVersionId, String effective) {
            this.toVersionId = toVersionId;
            this.effective = effective;
        }

        public Builder subscriptionIds(List<String> subscriptionIds) {
            this.subscriptionIds = subscriptionIds;
            return this;
        }

        public Builder changes(List<CreatePlanMoveParamsChangesItem> changes) {
            this.changes = changes;
            return this;
        }

        public Builder preview(Boolean preview) {
            this.preview = preview;
            return this;
        }

        public Builder fromVersionId(String fromVersionId) {
            this.fromVersionId = fromVersionId;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public CreatePlanMoveParams build() {
            return new CreatePlanMoveParams(this);
        }
    }
}
