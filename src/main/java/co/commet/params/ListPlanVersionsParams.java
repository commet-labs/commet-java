package co.commet.params;

public final class ListPlanVersionsParams {

    private final String cursor;
    private final Long limit;

    private ListPlanVersionsParams(Builder builder) {
        this.cursor = builder.cursor;
        this.limit = builder.limit;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCursor() { return cursor; }
    public Long getLimit() { return limit; }

    public static final class Builder {

        private String cursor;
        private Long limit;

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

        public ListPlanVersionsParams build() {
            return new ListPlanVersionsParams(this);
        }
    }
}
