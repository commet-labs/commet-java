package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = UpdatePlanDraftParamsCountriesItemPricesItem.Deserializer.class)
public interface UpdatePlanDraftParamsCountriesItemPricesItem {
    final class Deserializer extends JsonDeserializer<UpdatePlanDraftParamsCountriesItemPricesItem> {
        @Override
        public UpdatePlanDraftParamsCountriesItemPricesItem deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            return mapper.treeToValue(node, UpdatePlanDraftParamsCountriesItemPricesItemVariant1.class);
        }
    }
}
