package co.commet.params;

import co.commet.models.PublishPlanDraftParamsChangesItem;
import java.util.List;

public final class PublishPlanDraftParams {

    private final String publishAs;
    private final String move;
    private final List<PublishPlanDraftParamsChangesItem> changes;
    private final Boolean preview;
    private final String experimentCode;
    private final String idempotencyKey;

    private PublishPlanDraftParams(Builder builder) {
        this.publishAs = builder.publishAs;
        this.move = builder.move;
        this.changes = builder.changes;
        this.preview = builder.preview;
        this.experimentCode = builder.experimentCode;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String publishAs) {
        return new Builder(publishAs);
    }

    public String getPublishAs() { return publishAs; }
    public String getMove() { return move; }
    public List<PublishPlanDraftParamsChangesItem> getChanges() { return changes; }
    public Boolean getPreview() { return preview; }
    public String getExperimentCode() { return experimentCode; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String publishAs;
        private String move;
        private List<PublishPlanDraftParamsChangesItem> changes;
        private Boolean preview;
        private String experimentCode;
        private String idempotencyKey;

        private Builder(String publishAs) {
            this.publishAs = publishAs;
        }

        public Builder move(String move) {
            this.move = move;
            return this;
        }

        public Builder changes(List<PublishPlanDraftParamsChangesItem> changes) {
            this.changes = changes;
            return this;
        }

        public Builder preview(Boolean preview) {
            this.preview = preview;
            return this;
        }

        public Builder experimentCode(String experimentCode) {
            this.experimentCode = experimentCode;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public PublishPlanDraftParams build() {
            return new PublishPlanDraftParams(this);
        }
    }
}
