package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = UpdatePlanDraftParamsCountriesItemCreditPackPricesItem.Deserializer.class)
public interface UpdatePlanDraftParamsCountriesItemCreditPackPricesItem {
    final class Deserializer extends JsonDeserializer<UpdatePlanDraftParamsCountriesItemCreditPackPricesItem> {
        @Override
        public UpdatePlanDraftParamsCountriesItemCreditPackPricesItem deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            return mapper.treeToValue(node, UpdatePlanDraftParamsCountriesItemCreditPackPricesItemVariant1.class);
        }
    }
}
