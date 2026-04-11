package co.commet.params;

public final class ListCustomersParams {

    private final String customerId;
    private final Boolean isActive;
    private final String search;
    private final Integer limit;
    private final String cursor;

    private ListCustomersParams(Builder builder) {
        this.customerId = builder.customerId;
        this.isActive = builder.isActive;
        this.search = builder.search;
        this.limit = builder.limit;
        this.cursor = builder.cursor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCustomerId() { return customerId; }
    public Boolean getIsActive() { return isActive; }
    public String getSearch() { return search; }
    public Integer getLimit() { return limit; }
    public String getCursor() { return cursor; }

    public static final class Builder {

        private String customerId;
        private Boolean isActive;
        private String search;
        private Integer limit;
        private String cursor;

        private Builder() {}

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder search(String search) {
            this.search = search;
            return this;
        }

        public Builder limit(int limit) {
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
