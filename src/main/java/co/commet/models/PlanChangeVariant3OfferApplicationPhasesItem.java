package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = PlanChangeVariant3OfferApplicationPhasesItem.Deserializer.class)
public interface PlanChangeVariant3OfferApplicationPhasesItem {
    final class Deserializer extends JsonDeserializer<PlanChangeVariant3OfferApplicationPhasesItem> {
        @Override
        public PlanChangeVariant3OfferApplicationPhasesItem deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("type");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "free_trial":
                        return mapper.treeToValue(node, PlanChangeVariant3OfferApplicationPhasesItemVariant1.class);
                    case "percentage":
                        return mapper.treeToValue(node, PlanChangeVariant3OfferApplicationPhasesItemVariant2.class);
                    case "amount_off":
                        return mapper.treeToValue(node, PlanChangeVariant3OfferApplicationPhasesItemVariant3.class);
                    case "fixed_price":
                        return mapper.treeToValue(node, PlanChangeVariant3OfferApplicationPhasesItemVariant4.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, PlanChangeVariant3OfferApplicationPhasesItemVariant1.class);
        }
    }
}
