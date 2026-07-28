package co.commet.params;

public final class ListCustomersParams {

    private final String cursor;
    private final Long limit;
    private final String externalId;

    private ListCustomersParams(Builder builder) {
        this.cursor = builder.cursor;
        this.limit = builder.limit;
        this.externalId = builder.externalId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCursor() { return cursor; }
    public Long getLimit() { return limit; }
    public String getExternalId() { return externalId; }

    public static final class Builder {

        private String cursor;
        private Long limit;
        private String externalId;

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

        public Builder externalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public ListCustomersParams build() {
            return new ListCustomersParams(this);
        }
    }
}
