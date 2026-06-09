package co.commet.params;

public final class ListPlansParams {

    private final String includePrivate;

    private ListPlansParams(Builder builder) {
        this.includePrivate = builder.includePrivate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getIncludePrivate() { return includePrivate; }

    public static final class Builder {

        private String includePrivate;

        private Builder() {
        }

        public Builder includePrivate(String includePrivate) {
            this.includePrivate = includePrivate;
            return this;
        }

        public ListPlansParams build() {
            return new ListPlansParams(this);
        }
    }
}
