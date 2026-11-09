package co.commet.params;

import co.commet.models.UpdatePlanDraftParamsCountriesItem;
import co.commet.models.UpdatePlanDraftParamsPricesItem;
import co.commet.models.UpdatePlanDraftParamsRules;
import java.util.List;

public final class UpdatePlanDraftParams {

    private final List<UpdatePlanDraftParamsPricesItem> prices;
    private final List<UpdatePlanDraftParamsCountriesItem> countries;
    private final UpdatePlanDraftParamsRules rules;
    private final List<String> undo;
    private final String idempotencyKey;

    private UpdatePlanDraftParams(Builder builder) {
        this.prices = builder.prices;
        this.countries = builder.countries;
        this.rules = builder.rules;
        this.undo = builder.undo;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<UpdatePlanDraftParamsPricesItem> getPrices() { return prices; }
    public List<UpdatePlanDraftParamsCountriesItem> getCountries() { return countries; }
    public UpdatePlanDraftParamsRules getRules() { return rules; }
    public List<String> getUndo() { return undo; }
    public String getIdempotencyKey() { return idempotencyKey; }

    public static final class Builder {

        private List<UpdatePlanDraftParamsPricesItem> prices;
        private List<UpdatePlanDraftParamsCountriesItem> countries;
        private UpdatePlanDraftParamsRules rules;
        private List<String> undo;
        private String idempotencyKey;

        private Builder() {
        }

        public Builder prices(List<UpdatePlanDraftParamsPricesItem> prices) {
            this.prices = prices;
            return this;
        }

        public Builder countries(List<UpdatePlanDraftParamsCountriesItem> countries) {
            this.countries = countries;
            return this;
        }

        public Builder rules(UpdatePlanDraftParamsRules rules) {
            this.rules = rules;
            return this;
        }

        public Builder undo(List<String> undo) {
            this.undo = undo;
            return this;
        }

        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public UpdatePlanDraftParams build() {
            return new UpdatePlanDraftParams(this);
        }
    }
}
