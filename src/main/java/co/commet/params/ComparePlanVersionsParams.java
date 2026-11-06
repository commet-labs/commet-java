package co.commet.params;

public final class ComparePlanVersionsParams {

    private final String against;

    private ComparePlanVersionsParams(Builder builder) {
        this.against = builder.against;
    }

    public static Builder builder(String against) {
        return new Builder(against);
    }

    public String getAgainst() { return against; }

    public static final class Builder {

        private final String against;

        private Builder(String against) {
            this.against = against;
        }

        public ComparePlanVersionsParams build() {
            return new ComparePlanVersionsParams(this);
        }
    }
}
