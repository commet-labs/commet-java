package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = UpdatePlanDraftParamsCountriesItemAddonPricesItem.Deserializer.class)
public interface UpdatePlanDraftParamsCountriesItemAddonPricesItem {
    final class Deserializer extends JsonDeserializer<UpdatePlanDraftParamsCountriesItemAddonPricesItem> {
        @Override
        public UpdatePlanDraftParamsCountriesItemAddonPricesItem deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            return mapper.treeToValue(node, UpdatePlanDraftParamsCountriesItemAddonPricesItemVariant1.class);
        }
    }
}
