package co.commet.params;

public final class ListCustomersParams {

    private final String externalId;
    private final Long limit;
    private final String cursor;

    private ListCustomersParams(Builder builder) {
        this.externalId = builder.externalId;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getExternalId() { return externalId; }
    public Long getLimit() { return limit; }
    public String getCursor() { return cursor; }

    public static final class Builder {

        private String externalId;
        private Long limit;
        private String cursor;

        private Builder() {
        }

        public Builder externalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public Builder limit(Long limit) {
            this.limit = limit;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public ListCustomersParams build() {
            return new ListCustomersParams(this);
        }
    }
}
