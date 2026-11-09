package co.commet.params;

import co.commet.models.ArchivePlanExperimentParamsChangesItem;
import java.util.List;

public final class ArchivePlanExperimentParams {

    private final String subscribers;
    private final List<ArchivePlanExperimentParamsChangesItem> changes;
    private final Boolean preview;
    private final String idempotencyKey;

    private ArchivePlanExperimentParams(Builder builder) {
        this.subscribers = builder.subscribers;
        this.changes = builder.changes;
        this.preview = builder.preview;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getSubscribers() { return subscribers; }
    public List<ArchivePlanExperimentParamsChangesItem> getChanges() { return changes; }
    public Boolean getPreview() { return preview; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private String subscribers;
        private List<ArchivePlanExperimentParamsChangesItem> changes;
        private Boolean preview;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder subscribers(String subscribers) {
            this.subscribers = subscribers;
            return this;
        }

        public Builder changes(List<ArchivePlanExperimentParamsChangesItem> changes) {
            this.changes = changes;
            return this;
        }

        public Builder preview(Boolean preview) {
            this.preview = preview;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public ArchivePlanExperimentParams build() {
            return new ArchivePlanExperimentParams(this);
        }
    }
}
