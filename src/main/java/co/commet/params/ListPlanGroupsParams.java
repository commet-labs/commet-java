package co.commet.params;

public final class ListPlanGroupsParams {

    private final Long limit;
    private final String cursor;

    private ListPlanGroupsParams(Builder builder) {
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getLimit() { return limit; }
    public String getCursor() { return cursor; }

    public static final class Builder {

        private Long limit;
        private String cursor;

        private Builder() {
        }

        public Builder limit(Long limit) {
            this.limit = limit;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public ListPlanGroupsParams build() {
            return new ListPlanGroupsParams(this);
        }
    }
}
