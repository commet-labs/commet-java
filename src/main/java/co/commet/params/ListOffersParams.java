package co.commet.params;

public final class ListOffersParams {

    private final String cursor;
    private final Long limit;
    private final Boolean active;

    private ListOffersParams(Builder builder) {
        this.cursor = builder.cursor;
        this.limit = builder.limit;
        this.active = builder.active;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCursor() { return cursor; }
    public Long getLimit() { return limit; }
    public Boolean getActive() { return active; }

    public static final class Builder {

        private String cursor;
        private Long limit;
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

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public ListOffersParams build() {
            return new ListOffersParams(this);
        }
    }
}
