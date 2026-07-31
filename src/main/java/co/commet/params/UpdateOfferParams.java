package co.commet.params;

import co.commet.models.UpdateOfferParamsPhasesItem;
import java.util.List;
import java.util.Map;

public final class UpdateOfferParams {

    private final String name;
    private final List<UpdateOfferParamsPhasesItem> phases;
    private final Map<String, Object> metadata;
    private final String startsAt;
    private final String endsAt;
    private final Boolean active;
    private final String idempotencyKey;

    private UpdateOfferParams(Builder builder) {
        this.name = builder.name;
        this.phases = builder.phases;
        this.metadata = builder.metadata;
        this.startsAt = builder.startsAt;
        this.endsAt = builder.endsAt;
        this.active = builder.active;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder(String name, List<UpdateOfferParamsPhasesItem> phases) {
        return new Builder(name, phases);
    }

    public String getName() { return name; }
    public List<UpdateOfferParamsPhasesItem> getPhases() { return phases; }
    public Map<String, Object> getMetadata() { return metadata; }
    public String getStartsAt() { return startsAt; }
    public String getEndsAt() { return endsAt; }
    public Boolean getActive() { return active; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private final String name;
        private final List<UpdateOfferParamsPhasesItem> phases;
        private Map<String, Object> metadata;
        private String startsAt;
        private String endsAt;
        private Boolean active;
        private String idempotencyKey;

        private Builder(String name, List<UpdateOfferParamsPhasesItem> phases) {
            this.name = name;
            this.phases = phases;
        }

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder startsAt(String startsAt) {
            this.startsAt = startsAt;
            return this;
        }

        public Builder endsAt(String endsAt) {
            this.endsAt = endsAt;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdateOfferParams build() {
            return new UpdateOfferParams(this);
        }
    }
}
