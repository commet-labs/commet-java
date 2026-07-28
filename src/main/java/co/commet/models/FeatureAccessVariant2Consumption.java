package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = FeatureAccessVariant2Consumption.Deserializer.class)
public interface FeatureAccessVariant2Consumption {
    final class Deserializer extends JsonDeserializer<FeatureAccessVariant2Consumption> {
        @Override
        public FeatureAccessVariant2Consumption deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("model");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "metered":
                        return mapper.treeToValue(node, FeatureAccessVariant2ConsumptionVariant1.class);
                    case "credits":
                        return mapper.treeToValue(node, FeatureAccessVariant2ConsumptionVariant2.class);
                    case "balance":
                        return mapper.treeToValue(node, FeatureAccessVariant2ConsumptionVariant3.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, FeatureAccessVariant2ConsumptionVariant1.class);
        }
    }
}
