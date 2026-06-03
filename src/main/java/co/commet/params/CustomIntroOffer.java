package co.commet.params;

public final class CustomIntroOffer {

    private final String discountType;
    private final long discountValue;
    private final int durationCycles;

    private CustomIntroOffer(Builder builder) {
        this.discountType = builder.discountType;
        this.discountValue = builder.discountValue;
        this.durationCycles = builder.durationCycles;
    }

    public static Builder builder(String discountType, long discountValue, int durationCycles) {
        return new Builder(discountType, discountValue, durationCycles);
    }

    public String getDiscountType() { return discountType; }
    public long getDiscountValue() { return discountValue; }
    public int getDurationCycles() { return durationCycles; }

    public static final class Builder {

        private final String discountType;
        private final long discountValue;
        private final int durationCycles;

        private Builder(String discountType, long discountValue, int durationCycles) {
            this.discountType = discountType;
            this.discountValue = discountValue;
            this.durationCycles = durationCycles;
        }

        public CustomIntroOffer build() {
            return new CustomIntroOffer(this);
        }
    }
}
