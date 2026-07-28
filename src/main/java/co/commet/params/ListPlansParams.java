package co.commet.params;

public final class ListPlansParams {

    private final Boolean includePrivate;

    private ListPlansParams(Builder builder) {
        this.includePrivate = builder.includePrivate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Boolean getIncludePrivate() { return includePrivate; }

    public static final class Builder {

        private Boolean includePrivate;

        private Builder() {
        }

        public Builder includePrivate(Boolean includePrivate) {
            this.includePrivate = includePrivate;
            return this;
        }

        public ListPlansParams build() {
            return new ListPlansParams(this);
        }
    }
}
