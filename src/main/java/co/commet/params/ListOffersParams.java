package co.commet.params;

public final class ListOffersParams {

    private final String cursor;
    private final Long limit;
    private final String planPriceId;
    private final String purpose;
    private final Boolean active;

    private ListOffersParams(Builder builder) {
        this.cursor = builder.cursor;
        this.limit = builder.limit;
        this.planPriceId = builder.planPriceId;
        this.purpose = builder.purpose;
        this.active = builder.active;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCursor() { return cursor; }
    public Long getLimit() { return limit; }
    public String getPlanPriceId() { return planPriceId; }
    public String getPurpose() { return purpose; }
    public Boolean getActive() { return active; }

    public static final class Builder {

        private String cursor;
        private Long limit;
        private String planPriceId;
        private String purpose;
        private Boolean active;

        private Builder() {
        }

        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder limit(Long limit) {
            this.limit = limit;
            return this;
        }

        public Builder planPriceId(String planPriceId) {
            this.planPriceId = planPriceId;
            return this;
        }

        public Builder purpose(String purpose) {
            this.purpose = purpose;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public ListOffersParams build() {
            return new ListOffersParams(this);
        }
    }
}
