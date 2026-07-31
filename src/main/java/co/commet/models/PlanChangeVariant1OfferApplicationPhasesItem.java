package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = PlanChangeVariant1OfferApplicationPhasesItem.Deserializer.class)
public interface PlanChangeVariant1OfferApplicationPhasesItem {
    final class Deserializer extends JsonDeserializer<PlanChangeVariant1OfferApplicationPhasesItem> {
        @Override
        public PlanChangeVariant1OfferApplicationPhasesItem deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("type");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "free_trial":
                        return mapper.treeToValue(node, PlanChangeVariant1OfferApplicationPhasesItemVariant1.class);
                    case "percentage":
                        return mapper.treeToValue(node, PlanChangeVariant1OfferApplicationPhasesItemVariant2.class);
                    case "amount_off":
                        return mapper.treeToValue(node, PlanChangeVariant1OfferApplicationPhasesItemVariant3.class);
                    case "fixed_price":
                        return mapper.treeToValue(node, PlanChangeVariant1OfferApplicationPhasesItemVariant4.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, PlanChangeVariant1OfferApplicationPhasesItemVariant1.class);
        }
    }
}
